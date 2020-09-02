package programmers.kakao.blindRecruitment2020;

import java.util.LinkedList;
import java.util.Queue;

public class Level3_BlockMoving {

    private int[][] map;
    private boolean[][][] visited;
    private int N;
    private int[] x_move = {0, 1, 0, -1};
    private int[] y_move = {1, 0, -1, 0};
    private final int[] x_diagonal = {-1, 1, 1, -1};
    private final int[] y_diagonal = {1, 1, -1, -1};

    public int solution(int[][] board) {
        N = board.length;
        map = board;
        visited = new boolean[N][N][4];

        return bfs(new Robot(0, 0, 0, 0));
    }

    private int bfs(Robot startBot) {
        Queue<Robot> queue = new LinkedList<>();
        queue.offer(startBot);
        visited[startBot.x][startBot.y][startBot.direction] = true;

        while (!queue.isEmpty()) {
            Robot robot = queue.poll();

            if (isFinish(robot.x, robot.y) || isFinish(robot.getTailX(), robot.getTailY())) {
                return robot.time;
            }

            // 상하좌우 이동
            for (int i = 0; i < 4; i++) {
                int new_x = robot.x + x_move[i];
                int new_y = robot.y + y_move[i];
                int new_tail_x = robot.getTailX() + x_move[i];
                int new_tail_y = robot.getTailY() + y_move[i];

                if (!isInArea(new_x, new_y) || !isInArea(new_tail_x, new_tail_y)) {
                    continue;
                }

                if (map[new_x][new_y] == 1 || map[new_tail_x][new_tail_y] == 1) {
                    continue;
                }

                if (visited[new_x][new_y][robot.direction]) {
                    continue;
                }

                visited[new_x][new_y][robot.direction] = true;
                queue.offer(new Robot(new_x, new_y, robot.direction, robot.time + 1));
            }


            // x, y 기준
            for (int i = 1; i < 4; i += 2) { // 시계방향 90도는 + 1, 반시계방향 90도는 +3
                int new_direction = (robot.direction + i) % 4;
                int new_tail_x = robot.x + x_move[new_direction];
                int new_tail_y = robot.y + y_move[new_direction];

                int tempDirection = new_direction;
                if (i != 1) {
                    tempDirection = robot.direction;
                }

                int diagonal_x = robot.x + x_diagonal[tempDirection];
                int diagonal_y = robot.y + y_diagonal[tempDirection];

                if (!isInArea(diagonal_x, diagonal_y) || !isInArea(new_tail_x, new_tail_y)) {
                    continue;
                }

                if (map[new_tail_x][new_tail_y] == 1 || map[diagonal_x][diagonal_y] == 1) {
                    continue;
                }

                if (visited[robot.x][robot.y][new_direction]) {
                    continue;
                }

                visited[robot.x][robot.y][new_direction] = true;
                queue.offer(new Robot(robot.x, robot.y, new_direction, robot.time + 1));
            }


            // tail_x, tail_y 기준
            int direction = (robot.direction + 2) % 4;
            for (int i = 1; i < 4; i += 2) {
                int new_direction = (direction + i) % 4;
                int new_x = robot.getTailX() + x_move[new_direction];
                int new_y = robot.getTailY() + y_move[new_direction];

                int tempDirection = new_direction;
                if (i != 1) {
                    tempDirection = direction;
                }

                int diagonal_x = robot.getTailX() + x_diagonal[tempDirection];
                int diagonal_y = robot.getTailY() + y_diagonal[tempDirection];

                new_direction = (new_direction + 2) % 4;
                if (!isInArea(diagonal_x, diagonal_y) || !isInArea(new_x, new_y)) {
                    continue;
                }

                if (map[new_x][new_y] == 1 || map[diagonal_x][diagonal_y] == 1) {
                    continue;
                }

                if (visited[new_x][new_y][new_direction]) {
                    continue;
                }

                visited[new_x][new_y][new_direction] = true;
                queue.offer(new Robot(new_x, new_y, new_direction, robot.time + 1));
            }
        }

        return -1;
    }

    private boolean isInArea(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < N;
    }

    private boolean isFinish(int x, int y) {
        return x == N - 1 && y == N - 1;
    }

    class Robot {
        int x;
        int y;
        int direction;
        int time;

        public Robot(int x, int y, int direction, int time) {
            this.x = x;
            this.y = y;
            this.direction = direction;
            this.time = time;
        }

        public int getTailX() {
            return x + x_move[direction];
        }

        public int getTailY() {
            return y + y_move[direction];
        }

        @Override
        public String toString() {
            return "Robot{" +
                    "x=" + x +
                    ", y=" + y +
                    ", direction=" + direction +
                    ", time=" + time +
                    '}';
        }
    }
}
