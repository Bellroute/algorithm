package programmers.kakao.blindRecruitment2018;

import java.util.ArrayList;
import java.util.List;

public class Traffic {
    public static void main(String[] args) {
        String[] lines1 = {
                "2016-09-15 01:00:04.001 2.0s",
                "2016-09-15 01:00:07.000 2s"};
        String[] lines2 = {
                "2016-09-15 01:00:04.002 2.0s",
                "2016-09-15 01:00:07.000 2s"};
        String[] lines3 = {
                "2016-09-15 20:59:57.421 0.351s",
                "2016-09-15 20:59:58.233 1.181s",
                "2016-09-15 20:59:58.299 0.8s",
                "2016-09-15 20:59:58.688 1.041s",
                "2016-09-15 20:59:59.591 1.412s",
                "2016-09-15 21:00:00.464 1.466s",
                "2016-09-15 21:00:00.741 1.581s",
                "2016-09-15 21:00:00.748 2.31s",
                "2016-09-15 21:00:00.966 0.381s",
                "2016-09-15 21:00:02.066 2.62s"};

        System.out.println(solution(lines1));
        System.out.println(solution(lines2));
        System.out.println(solution(lines3));
    }

    public static int solution(String[] lines) {
        int answer = 0;
        List<TrafficLog> logList = new ArrayList<>();

        for (int i = 0; i < lines.length; i++) {
            String s = lines[i].split(" ")[1];
            float t = Float.parseFloat(lines[i].split(" ")[2].replace("s", ""));

            int hour = Integer.parseInt(s.split(":")[0]);
            int minute = Integer.parseInt(s.split(":")[1]);
            float second = Float.parseFloat(s.split(":")[2]);

            float time = hour * 3600 + minute * 60 + second;
            System.out.println(time - t);
            System.out.println(time);
            logList.add(new TrafficLog(time - t + 0.001f, time));
        }

        for (int i = 0; i < logList.size(); i++) {
            float point = logList.get(i).start;
            int count = 0;
            for (int j = 0; j < logList.size(); j++) {
                if (logList.get(j).start <= point + 0.999f && logList.get(j).end >= point) {
                    count++;
                }
            }

            point = logList.get(i).end;
            count = 0;

            for (int j = 0; j < logList.size(); j++) {
                if (logList.get(j).start <= point + 0.999f && logList.get(j).end >= point) {
                    count++;
                }
            }

            answer = Math.max(answer, count);
        }

        return answer;
    }
}

class TrafficLog {
    float start;
    float end;

    public TrafficLog(float start, float end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public String toString() {
        return "TrafficLog{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }
}
