package beckjoon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class BaekJoon1931 {
    private static int N;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();

        List<Meeting> meetingList = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            meetingList.add(new Meeting(scanner.nextInt(), scanner.nextInt()));
        }

        Collections.sort(meetingList);

        int end = -1;
        int count = 0;

        for (int i = 0; i < N; i++) {
            int start = meetingList.get(i).start;

            if (start >= end) {
                end = meetingList.get(i).end;
                count++;
            }
        }

        System.out.println(count);
    }

    static class Meeting implements Comparable<Meeting> {
        private int start;
        private int end;

        public Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Meeting meeting) {
            if (this.end < meeting.end) {
                return -1;
            } else if (this.end == meeting.end) {
                if (this.start > meeting.start) {
                    return 1;
                } else return -1;
            }

            return 1;
        }

        @Override
        public String toString() {
            return "Meeting{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }
    }
}
