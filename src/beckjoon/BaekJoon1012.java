package beckjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BaekJoon1012 {

    private static int answer;
    private static int N;
    private static int M;
    private static int[][] map;
    private static boolean[][] visited;
    private static int[] x_move = {1, 0, -1, 0};
    private static int[] y_move = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        while (T != 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            int count = Integer.parseInt(st.nextToken());
            answer = 0;

            map = new int[N][M];
            visited = new boolean[N][M];
            List<Point> list = new ArrayList<>();

            for (int i = 0; i < count; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                map[x][y] = 1;
                list.add(new Point(x, y));
            }

            for (Point point : list) {
                if (!visited[point.x][point.y]) {
                    bfs(point);
                }
            }

            sb.append(answer)
              .append("\n");

            T--;
        }

        System.out.println(sb.toString());
    }

    private static void bfs(Point point) {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(point);
        visited[point.x][point.y] = true;

        while (!queue.isEmpty()) {
            Point p = queue.poll();

            for (int i = 0; i < 4; i++) {
                int new_x = p.x + x_move[i];
                int new_y = p.y + y_move[i];

                if (!isInArea(new_x, new_y) || visited[new_x][new_y] || map[new_x][new_y] != 1) {
                    continue;
                }

                visited[new_x][new_y] = true;
                queue.offer(new Point(new_x, new_y));
            }
        }

        answer++;
    }

    private static boolean isInArea(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < M;
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
