package beckjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BaekJoon9376 {

    private static char[][] map;
    private static boolean[][] visited;
    private static int h;
    private static int w;
    private static int[] x_move = {1, 0, -1, 0};
    private static int[] y_move = {0, 1, 0, -1};

    static class Point {
        private int x;
        private int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int tries = Integer.parseInt(in.readLine());

        int[] answers = new int[tries];

        for (int i = 0; i < tries; i++) {
            String firstLine = in.readLine();
            h = Integer.parseInt(firstLine.split(" ")[0]);
            w = Integer.parseInt(firstLine.split(" ")[1]);

            map = new char[h + 2][w + 2];
            int[] prisoner_x = new int[2];
            int[] prisoner_y = new int[2];

            int count = 0;

            for (int j = 0; j < w + 2; j++) {
                map[0][j] = '.';
                map[h + 1][j] = '.';
            }

            for (int j = 1; j <= h; j++) {
                String inputs = '.' + in.readLine() + '.';
                for (int k = 0; k < w + 2; k++) {
                    map[j][k] = inputs.charAt(k);

                    if (map[j][k] == '$') {
                        prisoner_x[count] = j;
                        prisoner_y[count] = k;
                        count++;
                    }
                }
            }

            if (checkWithoutDoors()) {
                answers[i] = 0;
                continue;
            }

            int[][] helper_dist = bfs(new Point(0, 0));
            int[][] prisoner1_dist = bfs(new Point(prisoner_x[0], prisoner_y[0]));
            int[][] prisoner2_dist = bfs(new Point(prisoner_x[1], prisoner_y[1]));

            int min = Integer.MAX_VALUE;

            for (int j = 1; j <= h; j++) {
                for (int k = 1; k <= w; k++) {
                    if (map[j][k] == '*') {
                        continue;
                    }

                    int sum = helper_dist[j][k] + prisoner1_dist[j][k] + prisoner2_dist[j][k];

                    if (map[j][k] == '#') {
                        sum -= 2;
                    }

                    min = Math.min(min, sum);
                }
            }

            answers[i] = min;
        }

        for (int answer : answers) {
            System.out.println(answer);
        }
    }

    private static boolean checkWithoutDoors() {
        Queue<Point> q = new LinkedList<>();
        visited = new boolean[h + 2][w + 2];
        q.add(new Point(0, 0));
        visited[0][0] = true;

        int cnt = 0;

        while (!q.isEmpty()) {
            Point p = q.poll();

            for (int i = 0; i < 4; i++) {
                int new_x = p.x + x_move[i];
                int new_y = p.y + y_move[i];

                if (!isInArea(new_x, new_y) || map[new_x][new_y] == '*' || map[new_x][new_y] == '#' || visited[new_x][new_y]) {
                    continue;
                }

                visited[new_x][new_y] = true;

                if (map[new_x][new_y] == '$') {
                    cnt++;
                }

                q.offer(new Point(new_x, new_y));
            }
        }

        if (cnt == 2) return true;
        else return false;
    }

    private static int[][] bfs(Point point) {
        visited = new boolean[h + 2][w + 2];
        int[][] dists = new int[h + 2][w + 2];
        visited[point.x][point.y] = true;

        for (int[] dist1 : dists) {
            Arrays.fill(dist1, -1);
        }

        dists[point.x][point.y] = 0;

        Queue<Point> queue = new LinkedList<>();
        queue.offer(point);

        while (!queue.isEmpty()) {
            Point p = queue.poll();
            int dist = dists[p.x][p.y];

            for (int i = 0; i < 4; i++) {
                int new_x = p.x + x_move[i];
                int new_y = p.y + y_move[i];

                if (!isInArea(new_x, new_y) || map[new_x][new_y] == '*' || visited[new_x][new_y]) {
                    continue;
                }

                visited[new_x][new_y] = true;

                if (map[new_x][new_y] == '#') {
                    dists[new_x][new_y] = dist + 1;
                } else {
                    dists[new_x][new_y] = dist;
                }

                queue.offer(new Point(new_x, new_y));
            }
        }

        return dists;
    }

    private static boolean isInArea(int x, int y) {
        return x >= 0 && y >= 0 && x < h + 2 && y < w + 2;
    }
}
