package beckjoon;

import java.io.IOException;
import java.util.Scanner;

public class BaekJoon9095 {
    private static int count;

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String result = "";


        int T = scanner.nextInt();

        for (int i = 0; i < T; i++) {
            int n = scanner.nextInt();
            count = 0;

            for (int j = 1; j <= 3; j++) {
                backtracking(n, j);
            }

            result += count + "\n";
        }

        System.out.println(result.substring(0, result.length() - 1));
    }

    private static void backtracking(int number, int total) {
        if (total > number) return;

        if (total == number) {
            count++;
        }

        for (int i = 1; i <= 3; i++) {
            backtracking(number, total + i);
        }


    }
}
