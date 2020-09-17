package beckjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BaekJoon2933 {

    private static int R;
    private static int C;
    private static char[][] map;
    private static int[] x_move = {1, 0, -1, 0};
    private static int[] y_move = {0, 1, 0, -1};
    private static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String firstLine = in.readLine();
        R = Integer.valueOf(firstLine.split(" ")[0]);
        C = Integer.valueOf(firstLine.split(" ")[1]);

        map = new char[R][C];

        for (int i = 0; i < R; i++) {
            String input = in.readLine();

            for (int j = 0; j < C; j++) {
                map[i][j] = input.charAt(j);
            }
        }

        int[] bars = new int[Integer.valueOf(in.readLine())];
        StringTokenizer stringTokenizer = new StringTokenizer(in.readLine());

        for (int i = 0; i < bars.length; i++) {
            bars[i] = Integer.valueOf(stringTokenizer.nextToken());
        }

        for (int i = 0; i < bars.length; i++) {
            int height = bars[i];

            if (i % 2 == 0) {
                for (int j = 0; j < C; j++) {
                    if (map[R - height][j] == 'x') {
                        map[R - height][j] = '.';
                        break;
                    }
                }
            } else {
                for (int j = C - 1; j >= 0; j--) {
                    if (map[R - height][j] == 'x') {
                        map[R - height][j] = '.';
                        break;
                    }
                }
            }

            List<Point> clusters = findCluster();

            if (clusters.size() != 0) {
                update(clusters);
            }
        }

        print();
    }

    private static void print() {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }

    private static void update(List<Point> clusters) {
        for (Point cluster : clusters) {
            map[cluster.x][cluster.y] = '.';
        }

        int count = 0;
        for (int i = 1; i < R; i++) {
            for (Point cluster : clusters) {
                if (cluster.x + i == R || map[cluster.x + i][cluster.y] == 'x') {
                    count = i - 1;
                    break;
                }
            }

            if (count != 0) {
                break;
            }
        }

        for (Point cluster : clusters) {
            map[cluster.x + count][cluster.y] = 'x';
        }
    }

    private static List<Point> findCluster() {
        List<Point> clusters = new ArrayList<>();
        Queue<Point> queue = new LinkedList<>();
        visited = new boolean[R][C];

        for (int i = 0; i < C; i++) {
            if (map[R - 1][i] == 'x') {
                visited[R - 1][i] = true;
                queue.offer(new Point(R - 1, i));
            }
        }

        while (!queue.isEmpty()) {
            Point point = queue.poll();

            for (int i = 0; i < 4; i++) {
                int new_x = point.x + x_move[i];
                int new_y = point.y + y_move[i];

                if (!isInArea(new_x, new_y) || visited[new_x][new_y] || map[new_x][new_y] == '.') {
                    continue;
                }

                visited[new_x][new_y] = true;
                queue.offer(new Point(new_x, new_y));
            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == 'x' && !visited[i][j]) {
                    clusters.add(new Point(i, j));
                }
            }
        }

        return clusters;
    }

    private static boolean isInArea(int x, int y) {
        return x >= 0 && y >= 0 && x < R && y < C;
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
