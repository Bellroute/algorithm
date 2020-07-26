package naver.mainplatformIntern;

import java.util.LinkedList;
import java.util.Queue;

public class Q4 {
    private static int[][] map;
    private static boolean[][] isVisited;
    private static int m, n;
    private static int[] move_x = {1, -1, 0, 0};
    private static int[] move_y = {0, 0, -1, 1};


    public static void main(String[] args) {
        int[][] test = {{5, 4, 4}, {4, 3, 4}, {3, 2, 4}, {2, 2, 2}, {3, 3, 4}, {1, 4, 4}, {4, 1, 1}};

        int count = solution(test);
        System.out.println(count);

    }

    public static int solution(int[][] A) {
        m = A.length;
        n = A[0].length;
        isVisited = new boolean[m][n];
        map = A.clone();

        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!isVisited[i][j]) {
                    bfs(j, i, map[i][j]);
                    count++;
                }
            }
        }

        return count;
    }

    public static void bfs(int x, int y, int value) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x, y, value));
        isVisited[y][x] = true;

        while (!queue.isEmpty()) {

            Point p = queue.poll();

            for (int i = 0; i < 4; i++) {
                int new_x = move_x[i] + p.x;
                int new_y = move_y[i] + p.y;

                if (new_x >= 0 && new_x < n && new_y >= 0 && new_y < m) {
                    if (!isVisited[new_y][new_x] && p.value == map[new_y][new_x]) {
                        isVisited[new_y][new_x] = true;
                        queue.add(new Point(new_x, new_y, map[new_y][new_x]));
                    }
                }
            }
        }
    }
}

class Point {
    int x;
    int y;
    int value;

    Point(int x, int y, int value) {
        this.x = x;
        this.y = y;
        this.value = value;
    }
}