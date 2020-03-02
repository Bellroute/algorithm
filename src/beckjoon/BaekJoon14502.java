package beckjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BaekJoon14502 {
    private static int N;
    private static int M;
    private static int[][] map;
    private static boolean[][] visited;
    private static int[][] cloneMap;
    private static int numberOfWalls = 0;
    private static int[] dx = {1, 0, -1, 0};
    private static int[] dy = {0, 1, 0, -1};
    private static int count;
    private static int max = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();
        M = scanner.nextInt();

        map = new int[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                map[i][j] = scanner.nextInt();
            }
        }

        makeWall();
        System.out.println(max);
    }

    private static void makeWall() {
        if (numberOfWalls == 3) {
            cloneMap = deepCopy(map);
            visited = new boolean[N + 1][M + 1];
            count = 0;

            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= M; j++) {
                    if (cloneMap[i][j] == 2 && !visited[i][j]) {
                        visited[i][j] = true;
                        bfs2(i, j);
                    }
                }
            }

            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= M; j++) {
                    if (cloneMap[i][j] == 0 && !visited[i][j]) {
                        visited[i][j] = true;
                        bfs(i, j);
                    }
                }
            }

            max = Math.max(max, count);
        } else {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= M; j++) {
                    if (map[i][j] == 0) {
                        numberOfWalls++;
                        map[i][j] = 1;

                        makeWall();

                        numberOfWalls--;
                        map[i][j] = 0;
                    }
                }
            }
        }
    }

    private static int[][] deepCopy(int[][] map) {
        int[][] cloneMap = new int[map.length][];

        for (int i = 0; i < map.length; i++) {
            cloneMap[i] = map[i].clone();
        }

        return cloneMap;
    }

    private static void bfs2(int x, int y) {
        Queue<Point> queue = new LinkedList<>();

        queue.add(new Point(x, y));

        while (!queue.isEmpty()) {
            Point point = queue.poll();

            for (int i = 0; i < 4; i++) {
                int newX = point.x + dx[i];
                int newY = point.y + dy[i];

                if (isInArea(newX, newY) && cloneMap[newX][newY] == 0 && !visited[newX][newY]) {
                    visited[newX][newY] = true;
                    cloneMap[newX][newY] = 2;
                    queue.add(new Point(newX, newY));
                }
            }
        }
    }

    private static void bfs(int x, int y) {
        Queue<Point> queue = new LinkedList<>();

        queue.add(new Point(x, y));

        while (!queue.isEmpty()) {
            Point point = queue.poll();
            count++;

            for (int i = 0; i < 4; i++) {
                int newX = point.x + dx[i];
                int newY = point.y + dy[i];

                if (isInArea(newX, newY) && cloneMap[newX][newY] == 2) {
                    return;
                }

                if (isInArea(newX, newY) && cloneMap[newX][newY] == 0 && !visited[newX][newY]) {
                    visited[newX][newY] = true;
                    queue.add(new Point(newX, newY));
                }
            }
        }
    }

    private static boolean isInArea(int x, int y) {
        return x > 0 && y > 0 && x <= N && y <= M;
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
