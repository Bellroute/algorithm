package beckjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Point {
    int x;
    int y;
    int depth;

    Point(int x, int y, int depth) {
        this.x = x;
        this.y = y;
        this.depth = depth;
    }

}

public class BeckJoon2178 {
    private static int[][] maze;
    private static boolean[][] isvisited;
    private static int n;
    private static int m;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] splitedInput = input.split(" ");
        n = Integer.parseInt(splitedInput[0]);
        m = Integer.parseInt(splitedInput[1]);

        maze = new int[n][m];
        isvisited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String arrays = scanner.nextLine();
            for (int j = 0; j < m; j++) {
                maze[i][j] = Integer.parseInt(arrays.split("")[j]);
            }
        }

        bfs(new Point(0, 0, 1));
    }

    public static void bfs(Point point) {
        Queue<Point> q = new LinkedList<>();

        q.offer(point);
        isvisited[point.y][point.x] = true;

        int[] x = {1, 0, -1, 0};
        int[] y = {0, 1, 0, -1};

        while (!q.isEmpty()) {
            Point p = q.poll();

            if (p.x == m - 1 && p.y == n - 1) {
                System.out.println(p.depth);
            }

            for (int i = 0; i < 4; i++) {
                int p_x = p.x + x[i];
                int p_y = p.y + y[i];

                if (p_x >= 0 && p_x < m && p_y >= 0 && p_y < n && !isvisited[p_y][p_x] && maze[p_y][p_x] == 1) {
                    isvisited[p_y][p_x] = true;
                    q.offer(new Point(p_x, p_y, p.depth + 1));
                }
            }
        }


    }

}

