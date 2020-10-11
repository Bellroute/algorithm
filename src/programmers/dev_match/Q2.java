package programmers.dev_match;

import org.junit.Test;

import java.util.StringTokenizer;

public class Q2 {

    @Test
    public void test() {
        System.out.println(solution("PM 11:59:59", 60));
    }

    public String solution(String p, int n) {
        StringTokenizer st = new StringTokenizer(p);

        String cycle = st.nextToken();
        String[] time = st.nextToken().split(":");

        int hour = Integer.parseInt(time[0]);
        int minute = Integer.parseInt(time[1]);
        int second = Integer.parseInt(time[2]) + n;

        if (cycle.equals("PM")) {
            if (hour != 12) {
                hour += 12;
            }
        } else {
            if (hour == 12) {
                hour -= 12;
            }
        }

        if (second >= 60) {
            minute += second / 60;
            second %= 60;
        }

        if (minute >= 60) {
            hour += minute / 60;
            minute %= 60;
        }

        if (hour >= 24) {
            hour %= 24;
        }

        String hourFormat = String.valueOf(hour);
        String minuteFormat = String.valueOf(minute);
        String secondFormat = String.valueOf(second);

        if (hour < 10) {
            hourFormat = "0" + hourFormat;
        }

        if (minute < 10) {
            minuteFormat = "0" + minuteFormat;
        }

        if (second < 10) {
            secondFormat = "0" + secondFormat;
        }

        StringBuilder answer = new StringBuilder();
        answer.append(hourFormat)
              .append(":")
              .append(minuteFormat)
              .append(":")
              .append(secondFormat);

        return answer.toString();
    }

}
