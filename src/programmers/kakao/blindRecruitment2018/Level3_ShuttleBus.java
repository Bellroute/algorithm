package programmers.kakao.blindRecruitment2018;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class Level3_ShuttleBus {

    @Test
    public void test() {
        assertEquals("09:00", solution(1, 1, 5, new String[]{"08:00", "08:01", "08:02", "08:03"}));
        assertEquals("09:09", solution(2, 10, 2, new String[]{"09:10", "09:09", "08:00"}));
        assertEquals("08:59", solution(2, 1, 2, new String[]{"09:00", "09:00", "09:00", "09:00"}));
        assertEquals("00:00", solution(1, 1, 5, new String[]{"00:01", "00:01", "00:01", "00:01", "00:01"}));
        assertEquals("09:00", solution(1, 1, 1, new String[]{"23:59"}));
    }

    public String solution(int n, int t, int m, String[] timetable) {
        int answer = -1;

        int[] busArriveTimeTable = getBusArriveTime(n, t);
        int[] waitTimeTable = getWaitTimeTable(timetable);

        Arrays.sort(waitTimeTable);

        int waitIndex = 0;
        for (int i = 0; i < busArriveTimeTable.length; i++) {
            int busArriveTime = busArriveTimeTable[i];
            int seats = 0;

            while (waitIndex < waitTimeTable.length) {
                // 버스 시간 전에 도착한 사람이 있고 && 자리가 있는 경우
                if (waitTimeTable[waitIndex] <= busArriveTime && seats < m) {
                    answer = waitTimeTable[waitIndex];
                    answer = answer - 1;

                    waitIndex++;
                    seats++;

                    // 버스 자리가 여유 있고, 마지막 탑승객이면 여유롭게 시간 맞춰서 도착
                    if (i == busArriveTimeTable.length - 1 && seats < m && waitIndex == m - 1) {
                        answer = busArriveTimeTable[i];
                    }
                } else {
                    // 마지막 버스 인데 탑승객이 전부 못타는 경우 최종탑승자(answer)보다 빨리 와야 함
                    if (waitIndex == busArriveTimeTable.length - 1 && waitIndex >= 1) {
                        // 마지막 탑승 가능한 사람 도착 시간 입시저장
                        answer = waitTimeTable[waitIndex - 1];
                        answer = answer - 1;
                    }
                    break;
                }
            }

        }

        // 마지막 버스를 타도 여유가 있는 경우
        int lastBustTime = busArriveTimeTable[busArriveTimeTable.length - 1];
        if (answer < 0 || answer > lastBustTime) {
            answer = lastBustTime;
        }

        return formatTime(answer);
    }

    private int[] getWaitTimeTable(String[] timetable) {
        int[] result = new int[timetable.length];

        for (int i = 0; i < result.length; i++) {
            result[i] = Integer.parseInt(timetable[i].split(":")[0]) * 60 + Integer.parseInt(timetable[i].split(":")[1]);
        }

        return result;
    }

    private int[] getBusArriveTime(int n, int t) {
        int[] result = new int[n];
        int start = 9 * 60;

        for (int i = 0; i < result.length; i++) {
            result[i] = start + t * i;
        }

        return result;
    }

    private String formatTime(int input) {
        String hour = String.valueOf(input / 60);
        String minute = String.valueOf(input % 60);

        if (hour.length() == 1) {
            hour = "0" + hour;
        }

        if (minute.length() == 1) {
            minute = "0" + minute;
        }
        return hour + ":" + minute;
    }
}
