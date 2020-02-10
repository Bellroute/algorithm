package beckjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class BaekJoon15686 {
    private static int M;
    private static List<Point> homeList;
    private static List<Point> chickenList;
    private static Stack<Point> selectedStore;
    private static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        M = scanner.nextInt();
        scanner.nextLine();

        homeList = new ArrayList<>();
        chickenList = new ArrayList<>();
        selectedStore = new Stack<>();

        for (int i = 1; i <= N; i++) {
            String input = scanner.nextLine();
            for (int j = 0; j < N; j++) {
                if (input.split(" ")[j].equals("1")) {
                    homeList.add(new Point(i, j + 1));
                } else if (input.split(" ")[j].equals("2")) {
                    chickenList.add(new Point(i, j + 1));
                }
            }
        }

        selectStore(0, 0);
        System.out.println(min);
    }

    private static void selectStore(int start, int count) {
        if (count == M) {
            int result = calculateDistance();

            min = Math.min(min, result);
            return;
        }

        for (int i = start; i < chickenList.size(); i++) {
            selectedStore.push(chickenList.get(i));
            selectStore(i + 1, count + 1);
            selectedStore.pop();
        }
    }

    private static int calculateDistance() {
        int sum = 0;

        for (Point home : homeList) {
            int min = Integer.MAX_VALUE;

            for (Point chicken : selectedStore) {
                int total = Math.abs(home.x - chicken.x) + Math.abs(home.y - chicken.y);

                min = Math.min(min, total);
            }

            sum += min;
        }

        return sum;
    }

    public static class Point {
        private int x;
        private int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }

//    private static int N;
//    private static int M;
//    private static int[][] map;
//    private static int result = 999;
//
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//
//        N = scanner.nextInt();
//        M = scanner.nextInt();
//        scanner.nextLine();
//
//        map = new int[N + 1][N + 1];
//        int[] chicken_r = new int[M + 1];
//        int[] chicken_c = new int[M + 1];
//
//        for (int i = 1; i <= N; i++) {
//            String input = scanner.nextLine();
//
//            for (int j = 1; j <= N; j++) {
//                map[i][j] = Integer.parseInt(input.split(" ")[j - 1]);
//            }
//        }
//
//
//        dfs(0, 1, 1, chicken_r, chicken_c);
//
//
//        System.out.println(result);
//    }
//
//    private static void dfs(int count, int now_r, int now_c, int[] chicken_r, int[] chicken_c) {
//        if (count == M) {
//            int total = calculateLength(chicken_r, chicken_c);
//
//            if (total < result) {
//                result = total;
//            }
//        } else {
//            for (int i = now_r; i <= N; i++) {
//                for (int j = 1; j <= N; j++) {
//                    if (i == now_r && j <= now_c) continue;
//
//                    if (map[i][j] == 2) {
//                        chicken_r[count + 1] = i;
//                        chicken_c[count + 1] = j;
//
//                        dfs(count + 1, i, j, chicken_r, chicken_c);
//                    }
//                }
//            }
//        }
//    }
//
//    private static int calculateLength(int[] chicken_r, int[] chicken_c) {
//        int total = 0;
//
//        for (int i = 1; i <= N; i++) {
//            for (int j = 1; j <= N; j++) {
//                if (map[i][j] == 1) {
//                    int min = 999;
//
//                    for (int k = 1; k <= M; k++) {
//                        int x = chicken_r[k];
//                        int y = chicken_c[k];
//
//                        int length = Math.abs(i - x) + Math.abs(j - y);
//
//                        if (length < min) {
//                            min = length;
//                        }
//                    }
//
//                    total += min;
//                }
//            }
//        }
//
//        return total;
//    }
}
