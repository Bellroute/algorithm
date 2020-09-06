package programmers.kakao.blindRecruitment2018;

import org.junit.Test;

import java.util.PriorityQueue;
import java.util.Queue;

import static org.junit.Assert.assertEquals;

public class Level2_ThatSong {

    @Test
    public void test() {
        String m1 = "ABCDEFG";
        String[] musicinfos1 = {"12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF"};
        String m2 = "CC#BCC#BCC#BCC#B";
        String[] musicinfos2 = {"03:00,03:30,FOO,CC#B", "04:00,04:08,BAR,CC#BCC#BCC#B"};
        String m3 = "ABC";
        String[] musicinfos3 = {"12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF"};

        assertEquals("HELLO", solution(m1, musicinfos1));
        assertEquals("FOO", solution(m2, musicinfos2));
        assertEquals("WORLD", solution(m3, musicinfos3));
    }

    public String solution(String m, String[] musicinfos) {
        String answer = "(None)";

        Queue<Music> queue = new PriorityQueue<>();

        for (String musicInfo : musicinfos) {
            String startTime = musicInfo.split(",")[0];
            String endTime = musicInfo.split(",")[1];
            String name = musicInfo.split(",")[2];
            String cords = musicInfo.split(",")[3];

            queue.offer(new Music(name, replaceSharp(cords), startTime, endTime));
        }

        queue.forEach(System.out::println);

        while (!queue.isEmpty()) {
            Music music = queue.poll();

            if (music.getTotalCord().contains(replaceSharp(m))) {
                answer = music.name;
                break;
            }
        }

        return answer;
    }

    private String replaceSharp(String cords) {
        return cords.replace("C#", "c")
                    .replace("D#", "d")
                    .replace("F#", "f")
                    .replace("G#", "g")
                    .replace("A#", "a");
    }

    class Music implements Comparable<Music> {
        private String name;
        private String cords;
        private String startTime;
        private String endTime;

        public Music(String name, String cords, String startTime, String endTime) {
            this.name = name;
            this.cords = cords;
            this.startTime = startTime;
            this.endTime = endTime;
        }

        @Override
        public int compareTo(Music o) {
            if (this.getRunningTime() == o.getRunningTime()) {
                return this.startTime.compareTo(o.startTime);
            }
            return o.getRunningTime() - this.getRunningTime();
        }

        private int getRunningTime() {
            int startMinute = Integer.parseInt(this.startTime.split(":")[0]) * 60 + Integer.parseInt(this.startTime.split(":")[1]);
            int endMinute = Integer.parseInt(this.endTime.split(":")[0]) * 60 + Integer.parseInt(this.endTime.split(":")[1]);

            return endMinute - startMinute;
        }

        public String getTotalCord() {
            StringBuilder totalCord = new StringBuilder();

            for (int i = 0; i < getRunningTime(); i++) {
                int index = i % cords.length();
                totalCord.append(cords.charAt(index));
            }

            return totalCord.toString();
        }

        @Override
        public String toString() {
            return "Music{" +
                    "name='" + name + '\'' +
                    ", cords='" + getTotalCord() + '\'' +
                    ", startTime='" + startTime + '\'' +
                    ", endTime='" + endTime + '\'' +
                    '}';
        }
    }
}
