package coupang;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Q2 {

    @Test
    public void test() {
        System.out.println(solution(3, new String[] {"10/01 23:20:25 30", "10/01 23:25:50 26", "10/01 23:31:00 05", "10/01 23:33:17 24", "10/01 23:50:25 13", "10/01 23:55:45 20", "10/01 23:59:39 03", "10/02 00:10:00 10"}));
        System.out.println(solution(2, new String[]{"02/28 23:59:00 03", "03/01 00:00:00 02", "03/01 00:05:00 01"}));
    }

    public int solution(int n, String[] customers) {
        int answer = 0;

        PriorityQueue<Kiosk> kioskQueue = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            kioskQueue.offer(new Kiosk(i));
        }

        List<CustomerInfo> customerInfoList = new LinkedList<>();

        for (int i = 0; i < customers.length; i++) {
            StringTokenizer st = new StringTokenizer(customers[i]);
            customerInfoList.add(new CustomerInfo(st.nextToken(), st.nextToken(), Integer.parseInt(st.nextToken())));
        }

        PriorityQueue<Kiosk> usedKioskQueue = new PriorityQueue<>();

        for (int i = 0; i < customerInfoList.size(); i++) {
            CustomerInfo customerInfo = customerInfoList.get(i);

            while (!usedKioskQueue.isEmpty()) {
                Kiosk kiosk = usedKioskQueue.poll();

                if (kioskQueue.isEmpty()) {
                    kiosk.endTime = 0;
                    kioskQueue.offer(kiosk);
                    break;
                }

                if (customerInfo.getTotalTime() < kiosk.endTime) {
                    usedKioskQueue.offer(kiosk);
                    break;
                }

                kiosk.endTime = 0;
                kioskQueue.offer(kiosk);
            }

            Kiosk kiosk = kioskQueue.poll();

            kiosk.count = kiosk.count + 1;
            answer = Math.max(answer, kiosk.count);

            kiosk.endTime = customerInfo.getEndTime();

            usedKioskQueue.offer(kiosk);
        }

        return answer;
    }

    class Kiosk implements Comparable<Kiosk> {
        private int id;
        private int count;
        private int endTime;

        public Kiosk(int id) {
            this.id = id;
            this.count = 0;
            this.endTime = 0;
        }

        @Override
        public int compareTo(Kiosk o) {
            if (endTime == o.endTime) {
                return Integer.compare(this.id, o.id);
            }

            return Integer.compare(this.endTime, o.endTime);
        }
    }

    class CustomerInfo {
        private String date;
        private String time;
        private int takenTime;

        public CustomerInfo(String date, String time, int takenTime) {
            this.date = date;
            this.time = time;
            this.takenTime = takenTime;
        }

        public int getTotalTime() {
            int totalTime = 0;

            int month = Integer.parseInt(date.split("/")[0]);
            int day = Integer.parseInt(date.split("/")[1]);
            int hour = Integer.parseInt(time.split(":")[0]);
            int minute = Integer.parseInt(time.split(":")[1]);
            int second = Integer.parseInt(time.split(":")[2]);

            totalTime += second;
            totalTime += minute * 60;
            totalTime += hour * 60 * 60;
            totalTime += day * 60 * 60 * 60;
            totalTime += month * 60 * 60 * 60 * 60;

            return totalTime;
        }

        public int getEndTime() {
            int totalTime = 0;

            int month = Integer.parseInt(date.split("/")[0]);
            int day = Integer.parseInt(date.split("/")[1]);
            int hour = Integer.parseInt(time.split(":")[0]);
            int minute = Integer.parseInt(time.split(":")[1]) + takenTime;
            int second = Integer.parseInt(time.split(":")[2]);

            if (minute >= 60) {
                hour += minute / 60;
                minute = minute - 60;
            }

            if (hour >= 24) {
                day += hour / 24;
                hour = hour - 24;
            }

            if (month == 2  && day >= 29) {
                month += day / 28;
                day = day - 28;
            }

            switch (month) {
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12:
                    if (day > 31) {
                        month += day / 31;
                        day = day - 31;
                    }
                case 4:
                case 6:
                case 9:
                case 11:
                    if (day > 30) {
                        month += day / 30;
                        day = day - 30;
                    }

            }

            totalTime += second;
            totalTime += minute * 60;
            totalTime += hour * 60 * 60;
            totalTime += day * 60 * 60 * 60;
            totalTime += month * 60 * 60 * 60 * 60;

            return totalTime;
        }
    }
}
