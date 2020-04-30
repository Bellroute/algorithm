package programmers.kakao.blindRecruitment2018;

public class ThatSong {

    public static void main(String[] args) {
        String m1 = "ABCDEFG";
        String[] musicinfos1 = {"12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF"};
        String m2 = "CC#BCC#BCC#BCC#B";
        String[] musicinfos2 = {"03:00,03:30,FOO,CC#B", "04:00,04:08,BAR,CC#BCC#BCC#B"};
        String m3 = "ABC";
        String[] musicinfos3 = {"12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF"};

        System.out.println(solution(m1, musicinfos1));
        System.out.println(solution(m2, musicinfos2));
        System.out.println(solution(m3, musicinfos3));
    }

    public static String solution(String m, String[] musicinfos) {
        String answer = "";
        int maxRunningTime = 0;

        m = replaceSharpCord(m);

        for (String musicInfo : musicinfos) {
            String[] info = musicInfo.split(",");

            int hour = Integer.parseInt(info[1].split(":")[0]) - Integer.parseInt(info[0].split(":")[0]);
            int minute = Integer.parseInt(info[1].split(":")[1]) - Integer.parseInt(info[0].split(":")[1]);
            int runningTime = hour * 60 + minute;

            String cords = replaceSharpCord(info[3]);
            StringBuilder stringBuilder = new StringBuilder();

            for (int i = 0; i < runningTime; i++) {
                stringBuilder.append(cords.charAt(i % cords.length()));
            }

            cords = stringBuilder.toString();

            if (cords.contains(m)) {
                if (maxRunningTime < cords.length()) {
                    maxRunningTime = cords.length();
                    answer = info[2];
                }
            }
        }

        if (answer.equals("")) {
            return "(None)";
        }

        return answer;
    }

    private static String replaceSharpCord(String m) {
        return m.replace("C#", "c")
                .replace("D#", "d")
                .replace("E#", "e")
                .replace("F#", "f")
                .replace("G#", "g")
                .replace("A#", "a");
    }
}
