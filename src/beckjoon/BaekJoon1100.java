package beckjoon;

import java.util.Scanner;

public class BaekJoon1100 {
    private static Scanner scanner = new Scanner(System.in);
    private static char[][] chess = new char[8][8];

    public static void main(String[] args) {
        for (int i = 0; i < chess.length; i++) {
            String input = scanner.nextLine();

            for (int j = 0; j < chess[i].length; j++) {
                chess[i][j] = input.toCharArray()[j];
            }
        }

        int count = 0;

        for (int i = 0; i < chess.length; i++) {
            for (int j = 0; j < chess[i].length; j++) {
                if ((i + j) % 2 == 0 && chess[i][j] == 'F') {
                    count++;
                }
            }
        }

        System.out.println(count);
    }
}
