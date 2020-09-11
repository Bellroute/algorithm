package template;

import java.util.LinkedList;
import java.util.Queue;

public class DFS_BFS {

    private int n;
    private int answer;
    private int[][] map;
    private boolean[][] visited;
    private int[] x_move = {1, 0, -1, 0};
    private int[] y_move = {0, 1, 0, -1};

    private void bfs(int x, int y) {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(x, y));

        while (!queue.isEmpty()) {
            Point point = queue.poll(); // peek()은 값을 제거하지 않고 불러오는 메소드임

            for (int i = 0; i < 4; i++) {
                int new_x = point.x + x_move[i];
                int new_y = point.y + y_move[i];

                if (!isInArea(new_x, new_y)) {
                    continue;
                }

                if (visited[new_x][new_y]) {
                    continue;
                }

                visited[new_x][new_y] = true;
                queue.offer(new Point(new_x, new_y));
            }
        }
    }

    private void dfs(int x, int y, int depth) {
        if (depth == answer) {
            return;
        }

        for (int i = 0; i < 4; i++) {
            int new_x = x + x_move[i];
            int new_y = y + y_move[i];

            if (!isInArea(new_x, new_y)) {
                continue;
            }

            if (visited[new_x][new_y]) {
                continue;
            }

            visited[new_x][new_y] = true;
            dfs(new_x, new_y, depth + 1);
            visited[new_x][new_y] = false;
        }
    }

    private boolean isInArea(int x, int y) {
        return x >= 0 && y >= 0 && x < n && y < n;
    }

    class Point {
        private int x;
        private int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
