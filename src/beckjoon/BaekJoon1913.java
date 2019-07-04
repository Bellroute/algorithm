package beckjoon;

import java.util.Scanner;

public class BaekJoon1913 {
    private static Scanner scanner = new Scanner(System.in);
    private static int[][] output;
    private static int N;

    public static void main(String[] args) {
        N = scanner.nextInt();
        int number = scanner.nextInt();

        output = new int[N + 2][N + 2];

        output[1][1] = N * N;

        for (int i = 2; i <= N / 2 + 1; i++) {
            output[i][i] = (N - 2 * (i - 1)) * (N - 2 * (i - 1));
        }

        output[N / 2 + 1][N / 2 + 1] = 1;

        for (int i = 1; i < N/2 + 1; i++) {
            blackBox(i);
        }


        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < N + 1; j++) {
                System.out.print(output[i][j] + " ");
            }
            System.out.println();
        }

        foundPoint(number);
    }

    private static void foundPoint(int number) {
        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < N + 1; j++) {
                if (output[i][j] == number) {
                    System.out.println(i + " " + j);
                }
            }
        }
    }

    private static void blackBox(int number) {
        for (int i = number + 1; i <= N + 1 - number; i++) {
            output[i][number] = output[i - 1][number] - 1;
        }

        for (int i = number + 1; i <= N + 1 - number; i++) {
            output[N + 1 - number][i] = output[N + 1 - number][i - 1] - 1;
        }

        for (int i = N - number; i >= number; i--) {
            output[i][N + 1 - number] = output[i + 1][N + 1 - number] - 1;
        }

        for (int i = N - number; i > number; i--) {
            output[number][i] = output[number][i + 1] - 1;
        }
    }
}
