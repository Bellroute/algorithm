package programmers.kakao.code2017;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

import static org.junit.Assert.assertEquals;

public class ColoringBook {

    @Test
    public void test() {
        assertEquals(4, solution(6, 4, new int[][]{{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}})[0]);
        assertEquals(5, solution(6, 4, new int[][]{{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}})[1]);
    }

    private int[] answer = new int[2];
    private int[][] map;
    private boolean[][] visited;
    private int row;
    private int col;
    private int[] x_move = {1, 0, -1, 0};
    private int[] y_move = {0, 1, 0, -1};

    public int[] solution(int m, int n, int[][] picture) {
        answer[0] = 0;
        answer[1] = 0;

        map = picture;
        visited = new boolean[m][n];
        row = m;
        col = n;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && map[i][j] != 0) {
                    bfs(i, j);
                }
            }
        }

        return answer;
    }

    private void bfs(int x, int y) {
        int count = 1;
        Point point = new Point(x, y);
        visited[x][y] = true;

        Queue<Point> queue = new LinkedList<>();
        queue.offer(point);

        while (!queue.isEmpty()) {
            Point p = queue.poll();

            for (int i = 0; i < 4; i++) {
                int new_x = p.x + x_move[i];
                int new_y = p.y + y_move[i];

                if (inArea(new_x, new_y) && !visited[new_x][new_y] && map[x][y] == map[new_x][new_y]) {
                    count++;
                    visited[new_x][new_y] = true;
                    queue.offer(new Point(new_x, new_y));
                }
            }
        }

        answer[0]++;
        answer[1] = Math.max(answer[1], count);
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && y >= 0 && x < row && y < col;
    }

    class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
