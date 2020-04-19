package beckjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BaekJoon2644 {
    private static int n;
    private static int end;
    private static int[][] roots;
    private static boolean[][] visited;
    private static int m;
    private static int result = -1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt();
        int start = scanner.nextInt();
        end = scanner.nextInt();
        m = scanner.nextInt();

        roots = new int[n + 1][n + 1];
        visited = new boolean[n + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            int row = scanner.nextInt();
            int col = scanner.nextInt();

            roots[row][col] = 1;
            roots[col][row] = 1;
        }

        bfs(start);

        System.out.println(result);
    }

    private static void bfs(int now) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(now, 0));

        while (!queue.isEmpty()) {
            Point point = queue.poll();

            if (point.x == end) {
                result = point.depth;
                return;
            }

            for (int i = 1; i <= n; i++) {
                if (roots[point.x][i] == 1 && !visited[point.x][i]) {
                    visited[point.x][i] = true;
                    visited[i][point.x] = true;
                    queue.add(new Point(i, point.depth + 1));
                }
            }
        }
    }

    private static class Point {
        private int x;
        private int depth;

        private Point(int x, int depth) {
            this.x = x;
            this.depth = depth;
        }
    }
}
