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

public class BaekJoon2178 {
    private static Scanner scanner = new Scanner(System.in);
    private static int[][] map = new int[102][102];
    private static boolean[][] visited = new boolean[102][102];
    private static int[] xMove = {1, 0, -1, 0};
    private static int[] yMove = {0, 1, 0, -1};
    private static int N;
    private static int M;

    public static void main(String[] args) {
        String input = scanner.nextLine();
        N = Integer.parseInt(input.split(" ")[0]);
        M = Integer.parseInt(input.split(" ")[1]);

        for (int i = 1; i <= N; i++) {
            input = scanner.nextLine();
            for (int j = 1; j <= M; j++) {
                map[i][j] = Integer.parseInt(String.valueOf(input.charAt(j - 1)));
            }
        }

        bfs(1, 1);
    }

    private static void bfs(int x, int y) {
        Queue<Point> queue = new LinkedList<>();

        Point point = new Point(x, y, 1);

        queue.add(point);

        while (!queue.isEmpty()) {
            Point p = queue.poll();

            if (p.x == N && p.y == M) {
                System.out.println(p.depth);
                break;
            }

            for (int i = 0; i < 4; i++) {
                int newX = p.x + xMove[i];
                int newY = p.y + yMove[i];

                if (newX > 0 && newX <= 100 && newY > 0 && newY <= 100 && !visited[newX][newY] && map[newX][newY] == 1) {
                    queue.add(new Point(newX, newY, p.depth + 1));
                    visited[newX][newY] = true;
                }
            }
        }
    }
}
