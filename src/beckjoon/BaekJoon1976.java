package beckjoon;

import java.util.Scanner;

public class BaekJoon1976 {

    private static int[] join;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int M = scanner.nextInt();

        int[][] map = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N ; j++) {
                map[i][j] = scanner.nextInt();
            }
        }

        int[] route = new int[M + 1];
        for (int i = 1; i <= M; i++) {
            route[i] = scanner.nextInt();
        }

        join = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            join[i] = i;
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (map[i][j] == 1) {
                    if (i < j) {
                        union(j, i);
                    } else {
                        union(i, j);
                    }
                }
            }
        }

        int index = find(route[1]);
        for (int i = 2; i < route.length; i++) {
            if (index != find(route[i])) {
                System.out.println("NO");
                return;
            }
        }

        System.out.println("YES");
    }

    private static int find(int city) {
        if (join[city] == city) {
            return city;
        }

        int p = find(join[city]);
        join[city] = p;

        return p;
    }

    private static void union(int city1, int city2) {
        int x = find(city1);
        int y = find(city2);

        if (x != y) {
            join[x] = y;
        }
    }
}
