package beckjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BaekJoon14226 {

    private static int S;
    private static int answer;
    private static boolean[][] visited = new boolean[2002][2002];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        S = Integer.parseInt(br.readLine());

        bfs(1, 0, 0);

        System.out.println(answer);
    }

    private static void bfs(int number, int clipBoard, int time) {
        Queue<Emoticon> queue = new LinkedList<>();
        queue.offer(new Emoticon(number, clipBoard, time));

        while (!queue.isEmpty()) {
            Emoticon emoticon = queue.poll();

            if (emoticon.length == S) {
                answer = emoticon.time;
                return;
            }

            queue.offer(new Emoticon(emoticon.length, emoticon.length, emoticon.time + 1));

            if (emoticon.clipBoard != 0 && !visited[emoticon.length + emoticon.clipBoard][emoticon.clipBoard] && emoticon.length  + emoticon.clipBoard <= 1000) {
                visited[emoticon.length + emoticon.clipBoard][emoticon.clipBoard] = true;
                queue.offer(new Emoticon(emoticon.length + emoticon.clipBoard, emoticon.clipBoard, emoticon.time + 1));
            }

            if (emoticon.length > 0 && !visited[emoticon.length - 1][emoticon.clipBoard]) {
                visited[emoticon.length - 1][emoticon.clipBoard] = true;
                queue.offer(new Emoticon(emoticon.length - 1, emoticon.clipBoard, emoticon.time + 1));
            }
        }
    }

    static class Emoticon {
        private int length;
        private int clipBoard;
        private int time;

        public Emoticon(int length, int clipBoard, int time) {
            this.length = length;
            this.clipBoard = clipBoard;
            this.time = time;
        }

        @Override
        public String toString() {
            return "Emoticon{" +
                    "length=" + length +
                    ", clipBoard=" + clipBoard +
                    ", time=" + time +
                    '}';
        }
    }
}
