package beckjoon;

import java.util.Scanner;

public class BaekJoon2667 {
    private static Scanner scanner = new Scanner(System.in);
    private static String[] dummy = new String[27];
    private static int[][] map = new int[27][27];
    private static boolean[][] visted = new boolean[27][27];
    private static int[] x = {1, 0, -1, 0};
    private static int[] y = {0, 1, 0, -1};
    private static int numberOfSector;
    private static int[] numberOfHouse = new int[365];

    public static void main(String[] args) {
        numberOfSector = 0;

        for (int i = 0; i < numberOfHouse.length; i++) {
            numberOfHouse[i] = 0;
        }

        int scale = scanner.nextInt();
        scanner.nextLine();
        for (int i = 1; i <= scale; i++) {
            dummy[i] = scanner.nextLine();
        }

        for (int i = 1; i <= scale; i++) {
            for (int j = 1; j <= scale; j++) {
                map[i][j] = dummy[i].charAt(j - 1) - 48;
            }
        }

        for (int i = 0; i < 27; i++) {
            for (int j = 0; j < 27; j++) {
                if (map[i][j] == 1) {
                    visted[i][j] = false;
                } else {
                    visted[i][j] = true;
                }
            }
        }

        for (int i = 1; i <= scale; i++) {
            for (int j = 1; j <= scale; j++) {
                if (map[i][j] == 1 && !visted[i][j]) {
                    numberOfSector++;
                    dfs(i, j);
                }
            }
        }

        int[] result = new int[numberOfSector];
        for (int i = 0; i < numberOfSector; i++) {
            result[i] = numberOfHouse[i];
        }

        for (int i = 0; i < result.length; i++) {
            for (int j = i + 1; j < result.length; j++) {
                if (result[i] > result[j]) {
                    int temp = result[i];
                    result[i] = result[j];
                    result[j] = temp;
                }
            }
        }

        System.out.println(numberOfSector);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }

    }

    private static void dfs(int py, int px) {
        visted[py][px] = true;
        numberOfHouse[numberOfSector - 1]++;

        for (int k = 0; k < 4; k++) {
            int nx = px + x[k];
            int ny = py + y[k];

            if (nx < 26 && nx > 0 && ny < 26 && ny > 0 && !visted[ny][nx] && map[ny][nx] == 1) {
                dfs(ny, nx);
            }
        }
    }
}
