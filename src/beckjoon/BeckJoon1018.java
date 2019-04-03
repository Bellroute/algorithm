package beckjoon;

import java.util.Scanner;

public class BeckJoon1018 {
    private static Scanner scanner = new Scanner(System.in);
    private static String input;
    private static String[] inputs = new String[52];
    private static char[][] board = new char[52][52];
    private static int N;
    private static int M;
    private static int result = 999;
    private static int count;

    public static void main(String[] args) {
        input = scanner.nextLine();
        N = Integer.parseInt(input.split(" ")[0]);
        M = Integer.parseInt(input.split(" ")[1]);

        for (int i = 1; i <= N; i++) {
            inputs[i] = scanner.nextLine();
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                board[i][j] = inputs[i].charAt(j - 1);
            }
        }


        for (int i = 1; i <= N - 7; i++) {
            for (int j = 1; j <= M - 7; j++) {
                checkPainting(i, j);
            }
        }

        System.out.println(result);
    }

    private static void checkPainting(int a, int b) {
        count = 0;
        for (int i = a; i < a + 8; i++) {
            for (int j = b; j < b + 8; j++) {
                if (i % 2 == 0 && ((j % 2 == 0 && board[i][j] != 'B') || (j % 2 == 1 && board[i][j] != 'W'))) {
                    count++;
                }

                if (i % 2 == 1 && ((j % 2 == 0 && board[i][j] != 'W') || (j % 2 == 1 && board[i][j] != 'B'))) {
                    count++;
                }
            }
        }

        checkMinimum(count);
        count = 0;

        for (int i = a; i < a + 8; i++) {
            for (int j = b; j < b + 8; j++) {
                if (i % 2 == 0 && ((j % 2 == 0 && board[i][j] != 'W') || (j % 2 == 1 && board[i][j] != 'B'))) {
                    count++;
                }

                if (i % 2 == 1 && ((j % 2 == 0 && board[i][j] != 'B') || (j % 2 == 1 && board[i][j] != 'W'))) {
                    count++;
                }
            }
        }

        checkMinimum(count);
    }

    private static void checkMinimum(int number) {
        if (number < result) {
            result = number;
        }
    }
}
