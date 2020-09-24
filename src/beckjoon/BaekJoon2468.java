package beckjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BaekJoon2468 {

    private static int N;
    private static int[][] map;
    private static boolean[][] visited;
    private static int max = 0;
    private static int min = Integer.MAX_VALUE;
    private static int count;
    private static int height;
    private static int[] x_move = {1, 0, -1, 0};
    private static int[] y_move = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(map[i][j], max);
                min = Math.min(map[i][j], min);
            }
        }

        int result = 1;

        for (height = min; height < max; height++) {
            visited = new boolean[N][N];
            count = 0;

            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    if (map[j][k] > height && !visited[j][k]) {
                        bfs(j, k);
                        count++;
                    }
                }
            }

            if (result < count) {
                result = count;
            }
        }

        System.out.println(result);
    }

    private static void bfs(int x, int y) {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(x, y));
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            Point point = queue.poll();

            for (int i = 0; i < 4; i++) {
                int new_x = point.x + x_move[i];
                int new_y = point.y + y_move[i];

                if (!isInArea(new_x, new_y) || map[new_x][new_y] <= height || visited[new_x][new_y]) {
                    continue;
                }

                queue.offer(new Point(new_x, new_y));
                visited[new_x][new_y] = true;
            }
        }
    }

    private static boolean isInArea(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < N;
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
