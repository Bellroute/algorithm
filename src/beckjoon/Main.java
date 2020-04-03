package beckjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Main {
    private static boolean[][] able;
    private static int N;
    private static int M;
    private static StringBuilder stringBuilder;
    private static int[] p_x = {1, 0, -1, 0};
    private static int[] p_y = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.valueOf(br.readLine());

        stringBuilder = new StringBuilder();


        for (int i = 0; i < T; i++) {
            String input = br.readLine();

            N = Integer.valueOf(input.split(" ")[0]);
            M = Integer.valueOf(input.split(" ")[1]);

            able = new boolean[N + 1][M + 1];

            for (int j = 1; j <= N; j++) {
                input = br.readLine();

                for (int k = 1; k <= M; k++) {
                    if (Integer.valueOf(input.split(" ")[k - 1]) == 1) {
                        able[j][k] = true;
                    }
                }
            }

            bfs(0, 0);
            stringBuilder.append("\n");
        }

        System.out.println(stringBuilder.toString().trim());
    }

    private static void bfs(int x, int y) {
        Queue<Point> queue = new LinkedList<>();

        Point point = new Point(x, y);

        queue.add(point);

        while (!queue.isEmpty()) {
            Point p = queue.poll();

            if (p.x == N - 1 && p.y == M - 1) {
                stringBuilder.append("YES");
                break;
            }

            for (int i = 0; i < 4; i++) {
                int newX = p.x + p_x[i];
                int newY = p.y + p_y[i];

                if (!(inArea(newX, newY) && isAble(newX, newY))) {
                    stringBuilder.append("NO");
                    return;
                } else {
                    queue.add(new Point(newX, newY));
                }
            }
        }
    }

    private static boolean isAble(int newX, int newY) {
        return able[newX][newY] && able[newX + 1][newY] && able[newX][newY + 1] && able[newX + 1][newY + 1];
    }

    private static boolean inArea(int newX, int newY) {
        return newX > 0 && newX <= N - 1 && newY > 0 && newY <= M - 1;
    }

    private static class Point {
        private int x;
        private int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}