package beckjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BaekJoon7569 {
    private static int N;
    private static int M;
    private static int H;
    private static int box[][][];
    private static boolean visited[][][];
    private static int[] dx = {1, 0, -1, 0, 0, 0};
    private static int[] dy = {0, 1, 0, -1, 0, 0};
    private static int[] dz = {0, 0, 0, 0, 1, -1};
    private static int count = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        M = scanner.nextInt();
        N = scanner.nextInt();
        H = scanner.nextInt();

        box = new int[H + 1][N + 1][M + 1];
        visited = new boolean[H + 1][N + 1][M + 1];

        for (int i = 1; i <= H; i++) {
            for (int j = 1; j <= N; j++) {
                for (int k = 1; k <= M; k++) {
                    box[i][j][k] = scanner.nextInt();
                }
            }
        }

        bfs();

        for (int i = 1; i <= H; i++) {
            for (int j = 1; j <= N; j++) {
                for (int k = 1; k <= M; k++) {
                    if (box[i][j][k] == 0) {
                        System.out.println(-1);
                        return;
                    }
                }
            }
        }

        System.out.println(count);
    }

    private static void bfs() {
        Queue<Point> queue = new LinkedList<>();

        for (int i = 1; i <= H; i++) {
            for (int j = 1; j <= N; j++) {
                for (int k = 1; k <= M; k++) {
                    if (box[i][j][k] == 1) {
                        queue.add(new Point(j, k, i, 0));
                        visited[i][j][k] = true;
                    }
                }
            }
        }

        while (!queue.isEmpty()) {
            Point point = queue.poll();

            count = Math.max(count, point.depth);

            for (int i = 0; i < 6; i++) {
                int x = point.x + dx[i];
                int y = point.y + dy[i];
                int z = point.z + dz[i];

                if (isInArea(x, y, z)) {
                    if (box[z][x][y] == 0 && !visited[z][x][y]) {
                        queue.add(new Point(x, y, z, point.depth + 1));
                        box[z][x][y] = 1;
                        visited[z][x][y] = true;
                    }
                }
            }
        }
    }

    private static boolean isInArea(int x, int y, int z) {
        return x > 0 && x <= N && y > 0 && y <= M && z > 0 && z <= H;
    }

    static class Point {
        private int x;
        private int y;
        private int z;
        private int depth;

        public Point(int x, int y, int z, int depth) {
            this.x = x;
            this.y = y;
            this.z = z;
            this.depth = depth;
        }
    }
}
