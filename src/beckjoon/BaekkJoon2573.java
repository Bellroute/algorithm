package beckjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BaekkJoon2573 {

    private static int N;
    private static int M;
    private static int[][] map;
    private static boolean[][] visited;
    private static int[] x_move = {1, 0, -1, 0};
    private static int[] y_move = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int year = 1;

        while (true) {
            melt();

            if (isAllMelted()) {
                System.out.println(0);
                return;
            }

            int count = 0;
            visited = new boolean[N][M];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] != 0 && !visited[i][j]) {
                        bfs(i, j);
                        count++;
                    }
                }
            }

            if (count >= 2) {
                System.out.println(year);
                return;
            }

            year++;
        }
    }

    private static boolean isAllMelted() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] != 0) {
                    return false;
                }
            }
        }

        return true;
    }

    private static void bfs(int x, int y) {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(x, y));
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            Point point = queue.poll();

            for (int k = 0; k < 4; k++) {
                int new_x = point.x + x_move[k];
                int new_y = point.y + y_move[k];

                if (!isInArea(new_x, new_y) || map[new_x][new_y] == 0 || visited[new_x][new_y]) {
                    continue;
                }

                visited[new_x][new_y] = true;
                queue.offer(new Point(new_x, new_y));
            }
        }
    }

    private static boolean isInArea(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < M;
    }

    private static void melt() {
        boolean[][] melted = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    continue;
                }

                for (int k = 0; k < 4; k++) {
                    int new_x = i + x_move[k];
                    int new_y = j + y_move[k];

                    if (map[new_x][new_y] == 0 && !melted[new_x][new_y] && map[i][j] > 0) {
                        map[i][j]--;
                        melted[i][j] = true;
                    }
                }
            }
        }
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
