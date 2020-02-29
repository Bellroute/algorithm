package beckjoon;

import java.util.*;

public class BaekJoon2583 {
    private static int M;
    private static int N;
    private static int K;
    private static int[][] map;
    private static boolean[][] visited;
    private static List<Integer> results = new ArrayList<>();
    private static int[] dx = {1, 0, -1, 0};
    private static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        M = scanner.nextInt();
        N = scanner.nextInt();
        K = scanner.nextInt();

        map = new int[M][N];
        visited = new boolean[M][N];

        for (int i = 0; i < K; i++) {
            int startY = scanner.nextInt();
            int startX = scanner.nextInt();
            int endY = scanner.nextInt();
            int endX = scanner.nextInt();

            for (int j = startX; j < endX; j++) {
                for (int k = startY; k < endY; k++) {
                    map[j][k] = 1;
                }
            }
        }

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 0 && !visited[i][j]) {
                    bfs(i, j);
                }
            }
        }

        Collections.sort(results);
        StringBuilder result = new StringBuilder();

        for (int number : results) {
            result.append(number).append(" ");
        }

        System.out.println(results.size());
        System.out.println(result.toString().trim());
    }

    private static void bfs(int x, int y) {
        Queue<Point> queue = new LinkedList<>();

        visited[x][y] = true;
        queue.add(new Point(x, y, 0));

        int count = 0;

        while (!queue.isEmpty()) {
            Point point = queue.poll();
            count++;

            for (int i = 0; i < 4; i++) {
                int newX = point.x + dx[i];
                int newY = point.y + dy[i];

                if (isInArea(newX, newY) && map[newX][newY] == 0 && !visited[newX][newY]) {
                    visited[newX][newY] = true;
                    queue.add(new Point(newX, newY, point.depth + 1));
                }
            }
        }

        results.add(count);
    }

    private static boolean isInArea(int x, int y) {
        return x >= 0 && x < M && y >= 0 && y < N;
    }


    static class Point {
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
