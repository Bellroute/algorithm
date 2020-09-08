package programmers.kakao.internship2020;

import java.util.LinkedList;
import java.util.Queue;

public class Level3_RacingRoad {

    private int[][] board;
    private int n;
    private static final int WALL = 1;
    private static final int COST_OF_STRAIGHT_ROAD = 100;
    private static final int COST_OF_CORNER_ROAD = 500;
    private int[] x_move = {1, 0, -1, 0};
    private int[] y_move = {0, 1, 0, -1};
    private int[][] map;
    private int answer = Integer.MAX_VALUE;

    public int solution(int[][] board) {
        this.board = board;
        n = board.length;
        map = new int[n][n];

        bfs(new Point(0, 0));

        return answer;
    }

    private void bfs(Point point) {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(point);

        while (!queue.isEmpty()) {
            Point p = queue.poll();

            if (p.x == n - 1 && p.y == n - 1) {
                answer = Math.min(answer, p.cost);
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int new_x = p.x + x_move[i];
                int new_y = p.y + y_move[i];

                if (!isInArea(new_x, new_y) || board[new_x][new_y] == WALL) {
                    continue;
                }

                Point nextPoint = new Point(new_x, new_y, p.x, p.y, p.cost + COST_OF_STRAIGHT_ROAD);

                if (p.before_x != new_x && p.before_y != new_y) {
                    nextPoint.cost += COST_OF_CORNER_ROAD;
                }

                if (map[new_x][new_y] == 0) {
                    map[new_x][new_y] = nextPoint.cost;
                    queue.offer(nextPoint);
                    continue;
                }

                if (map[new_x][new_y] >= nextPoint.cost) {
                    map[new_x][new_y] = nextPoint.cost;
                    queue.offer(nextPoint);
                }
            }
        }

    }

    private boolean isInArea(int x, int y) {
        return x >= 0 && y >= 0 && x < n && y < n;
    }

    class Point {
        private int x;
        private int y;
        private int before_x;
        private int before_y;
        private int cost;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
            this.before_x = 0;
            this.before_y = 0;
            this.cost = 0;
        }

        public Point(int x, int y, int before_x, int before_y, int cost) {
            this.x = x;
            this.y = y;
            this.before_x = before_x;
            this.before_y = before_y;
            this.cost = cost;
        }
    }
}
