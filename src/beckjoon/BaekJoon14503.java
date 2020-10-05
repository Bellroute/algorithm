package beckjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BaekJoon14503 {

    private static final int BLANK = 0;
    private static final int WALL = 1;
    private static final int CLEANED = 2;
    private static int[][] map;
    private static int N;
    private static int M;
    private static int result = 0;

    private static int[] x_foward = {-1, 0, 1, 0};
    private static int[] y_foward = {0, 1, 0, -1};
    private static int[] x_back = {1, 0, -1, 0};
    private static int[] y_back = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int robot_x = Integer.parseInt(st.nextToken());
        int robot_y = Integer.parseInt(st.nextToken());
        int robot_direction = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bfs(robot_x, robot_y, robot_direction);

        System.out.println(result);
    }

    private static void bfs(int x, int y, int direction) {
        Queue<Robot> queue = new LinkedList<>();
        queue.offer(new Robot(x, y, direction));
        result++;
        map[x][y] = CLEANED;

        while (!queue.isEmpty()) {
            Robot robot = queue.poll();
            int robot_x = robot.x;
            int robot_y = robot.y;
            int robot_direction = robot.direction;

            for (int i = 0; i < 4; i++) {
                robot_direction = (robot_direction + 3) % 4;

                int new_x = robot_x + x_foward[robot_direction];
                int new_y = robot_y + y_foward[robot_direction];

                if (!isInArea(new_x, new_y)) {
                    continue;
                }

                if (map[new_x][new_y] == WALL || map[new_x][new_y] == CLEANED) {
                    continue;
                }

                queue.offer(new Robot(new_x, new_y, robot_direction));
                map[new_x][new_y] = CLEANED;
                result++;
                break;
            }

            if (!queue.isEmpty()) {
                continue;
            }

            robot_x = robot.x + x_back[robot.direction];
            robot_y = robot.y + y_back[robot.direction];

            if (map[robot_x][robot_y] != WALL && isInArea(robot_x, robot_y)) {
                queue.offer(new Robot(robot_x, robot_y, robot.direction));

                if (map[robot_x][robot_y] == BLANK) {
                    map[robot_x][robot_y] = CLEANED;
                    result++;
                }
            }
        }
    }

    private static boolean isInArea(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < M;
    }

    static class Robot {
        private int x;
        private int y;
        private int direction;

        public Robot(int x, int y, int direction) {
            this.x = x;
            this.y = y;
            this.direction = direction;
        }
    }
}
