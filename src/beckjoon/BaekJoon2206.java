package beckjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BaekJoon2206 {
    private static int[] x = {1, 0, -1, 0};
    private static int[] y = {0, 1, 0, -1};
    private static int N;
    private static int M;
    private static int[][] map;
    private static int[][] isVisited;
    private static int result;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();
        M = scanner.nextInt();
        map = new int[N + 1][M + 1];
        isVisited = new int[N + 1][M + 1];

        scanner.nextLine();
        for (int i = 1; i <= N; i++) {
            String input = scanner.nextLine();
            for (int j = 1; j <= M; j++) {
                map[i][j] = Integer.parseInt(input.split("")[j - 1]);
                isVisited[i][j] = Integer.MAX_VALUE;
            }
        }

        result = Integer.MAX_VALUE;
        bfs(1, 1);

        if (result == Integer.MAX_VALUE)  {
            System.out.println(-1);
        } else {
            System.out.println(result);
        }
    }

    private static void bfs(int px, int py) {
        Queue<Point> queue = new LinkedList<>();

        queue.add(new Point(px, py, 1, 0));
        isVisited[px][py] = 0;

        while (!queue.isEmpty()) {
            Point point = queue.poll();

            if (point.px == N && point.py == M) {
                result = point.depth;
                break;
            }

            for (int i = 0; i < 4; i++) {
                int newX = point.px + x[i];
                int newY = point.py + y[i];

                if (newX > N || newX <= 0 || newY > M || newY <= 0) continue;

                if (isVisited[newX][newY] <= point.isAbleBreakWall) continue;

                if (map[newX][newY] == 0) {
                    isVisited[newX][newY] = point.isAbleBreakWall;
                    queue.add(new Point(newX, newY, point.depth + 1, point.isAbleBreakWall));
                } else {
                    if (point.isAbleBreakWall == 0) {
                        isVisited[newX][newY] = point.isAbleBreakWall + 1;
                        queue.add(new Point(newX, newY, point.depth + 1, point.isAbleBreakWall + 1));
                    }
                }

            }
        }
    }

    private static class Point {
        private int px;
        private int py;
        private int depth;
        private int isAbleBreakWall;

        Point(int x, int y, int depth, int isAbleBreakWall) {
            this.px = x;
            this.py = y;
            this.depth = depth;
            this.isAbleBreakWall = isAbleBreakWall;
        }
    }
}

//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//
//        N = scanner.nextInt();
//        M = scanner.nextInt();
//        map = new int[N + 1][M + 1];
//        isVisited = new boolean[N + 1][M + 1];
//
//        scanner.nextLine();
//        for (int i = 1; i <= N; i++) {
//            String input = scanner.nextLine();
//            for (int j = 1; j <= M; j++) {
//                map[i][j] = Integer.parseInt(input.split("")[j - 1]);
//            }
//        }
//
//        isVisited[1][1] = true;
//        bfs(1, 1);
//    }
//
//    private static void bfs(int px, int py) {
//        Queue<Point> queue = new LinkedList<>();
//
//        Point newPoint = new Point(px, py, 1, true);
//        queue.add(newPoint);
//
//        while (!queue.isEmpty()) {
//            Point point = queue.poll();
//
//            if (point.px == N && point.py == M) {
//                System.out.println(point.depth);
//                System.exit(1);
//            }
//
//            for (int i = 0; i < 4; i++) {
//                int newX = point.px + x[i];
//                int newY = point.py + y[i];
//
//                if (newX > N || newX <= 0 || newY > M || newY <= 0) continue;
//
//                if (isVisited[newX][newY]) continue;
//
//                if (map[newX][newY] == 0) {
//                    queue.add(new Point(newX, newY, point.depth + 1, point.isAbleBreakWall));
//                    isVisited[newX][newY] = true;
//                } else {
//                    if (point.isAbleBreakWall) {
//                        queue.add(new Point(newX, newY, point.depth + 1, false));
//                        isVisited[newX][newY] = true;
//                    }
//                }
//
//            }
//        }
//
//        System.out.println(-1);

//    }
