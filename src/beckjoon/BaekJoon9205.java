package beckjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BaekJoon9205 {

    private static int N;
    private static Point[] map;
    private static boolean[] visited;
    private static boolean flag;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tries = Integer.parseInt(br.readLine());

        while (tries-- > 0) {
            N = Integer.parseInt(br.readLine());
            flag = false;

            map = new Point[N + 2];
            visited = new boolean[N + 2];

            for (int i = 0; i < N + 2; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                map[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }

            Point home = map[0];
            Point goal = map[map.length - 1];

            Queue<Point> queue = new LinkedList<>();
            queue.offer(home);
            visited[0] = true;

            while (!queue.isEmpty()) {
                Point point = queue.poll();

                if (point.equals(goal)) {
                    flag = true;
                    break;
                }

                for (int i = 1; i < N + 2; i++) {
                    if (!visited[i] && Math.abs(point.x - map[i].x) + Math.abs(point.y - map[i].y) <= 1000) {
                        visited[i] = true;
                        queue.offer(map[i]);
                    }
                }
            }

            if (flag) {
                sb.append("happy")
                  .append("\n");
            } else {
                sb.append("sad")
                  .append("\n");
            }
        }

        System.out.println(sb.toString());
    }

    static class Point {
        private int x;
        private int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
