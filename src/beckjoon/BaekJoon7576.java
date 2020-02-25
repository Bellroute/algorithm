package beckjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BaekJoon7576 {
    private static int N;
    private static int M;
    private static int[][] box;
    private static boolean[][] isVisited;
    private static int[] dx = {1, 0, -1, 0};
    private static int[] dy = {0, 1, 0, -1};
    private static int count = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        M = scanner.nextInt();
        N = scanner.nextInt();

        box = new int[N + 1][M + 1];
        isVisited = new boolean[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                box[i][j] = scanner.nextInt();
            }
        }

        bfs();

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (box[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
            }
        }

        System.out.println(count);
    }

    private static void bfs() {
        Queue<Point> queue = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (box[i][j] == 1) {
                    queue.add(new Point(i, j, 0));
                    isVisited[i][j] = true;
                }
            }
        }

        while (!queue.isEmpty()) {
            Point point = queue.poll();

            count = Math.max(count, point.depth);

            for (int i = 0; i < 4; i++) {
                int x = point.x + dx[i];
                int y = point.y + dy[i];

                if (isInArea(x, y)) {
                    if (box[x][y] == 0 && !isVisited[x][y]) {
                        queue.add(new Point(x, y, point.depth + 1));
                        box[x][y] = 1;
                        isVisited[x][y] = true;
                    }
                }
            }
        }
    }

    private static boolean isInArea(int x, int y) {
        return x > 0 && x <= N && y > 0 && y <= M;
    }

    private static class Point {
        private int x;
        private int y;
        private int depth;

        public Point(int x, int y, int depth) {
            this.x = x;
            this.y = y;
            this.depth = depth;
        }
    }
}
