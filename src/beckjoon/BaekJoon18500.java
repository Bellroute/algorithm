package beckjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BaekJoon18500 {

    private static int R;
    private static int C;
    private static int N;
    private static char[][] map;
    private static int[] tries;
    private static int[] x_move = {1, 0, -1, 0};
    private static int[] y_move = {0, 1, 0, -1};
    private static int min;
    private static boolean[][] visited;
    private static boolean[][] checked;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];

        for (int i = 0; i < R; i++) {
            String line = br.readLine();

            for (int j = 0; j < C; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        N = Integer.parseInt(br.readLine());
        tries = new int[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            tries[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            min = Integer.MAX_VALUE;
            throwStick(i);

            visited = new boolean[R][C];
            checkFloor();

            for (int j = 0; j < R; j++) {
                for (int k = 0; k < C; k++) {
                    if (map[j][k] == 'x' && !visited[j][k]) {
                        checked = new boolean[R][C];
                        downClusters(findMinLength(j, k));
                    }
                }
            }
        }

        for (int j = 0; j < R; j++) {
            for (int k = 0; k < C; k++) {
                System.out.print(map[j][k]);
            }
            System.out.println();
        }
    }

    private static void downClusters(int height) {
        for (int i = R - 1; i >= 0; i--) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == 'x' && !visited[i][j]) {
                    map[i][j] = '.';
                    map[i + height][j] = 'x';
                }
            }
        }
    }

    private static int findMinLength(int x, int y) {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(x, y));
        checked[x][y] = true;

        int min = Integer.MAX_VALUE;

        while (!queue.isEmpty()) {
            Point point = queue.poll();

            int length = (R - 1) - point.x;

            for (int i = x; i < R; i++) {
                if (visited[i][y]) {
                    min -= (R - 1) - i;
                    break;
                }
            }

            min = Math.min(min, length);

            for (int i = 0; i < 4; i++) {
                int new_x = point.x + x_move[i];
                int new_y = point.y + y_move[i];

                if (!isInArea(new_x, new_y) || map[new_x][new_y] == '.' || visited[new_x][new_y] || checked[new_x][new_y]) {
                    continue;
                }

                checked[new_x][new_y] = true;
                queue.offer(new Point(new_x, new_y));
            }
        }

        return min;
    }

    private static void checkFloor() {
        for (int i = 0; i < C; i++) {
            if (map[R - 1][i] == 'x' && !visited[R - 1][i]) {
                dfs(R - 1, i);
            }
        }
    }

    private static void dfs(int x, int y) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int new_x = x + x_move[i];
            int new_y = y + y_move[i];

            if (!isInArea(new_x, new_y) || visited[new_x][new_y] || map[new_x][new_y] != 'x') {
                continue;
            }

            dfs(new_x, new_y);
        }
    }

    private static boolean isInArea(int x, int y) {
        return x >= 0 && y >= 0 && x < R && y < C;
    }

    private static void throwStick(int i) {
        int height = R - tries[i];

        if (i % 2 == 0) {
            for (int j = 0; j < C; j++) {
                if (map[height][j] == 'x') {
                    map[height][j] = '.';
                    return;
                }
            }
        }

        if (i % 2 == 1) {
            for (int j = C - 1; j >= 0; j--) {
                if (map[height][j] == 'x') {
                    map[height][j] = '.';
                    return;
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
