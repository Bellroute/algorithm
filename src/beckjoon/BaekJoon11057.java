package beckjoon;

import java.util.Scanner;

public class BaekJoon11057 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int[][] dp = new int[N + 1][10];


        for (int i = 0; i < 10; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i <= N; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k <= j; k++) {
                    dp[i][j] += dp[i - 1][k];
                    dp[i][j] %= 10007;
                }
            }
        }

        int result = 0;

        for (int i = 0; i < 10; i++) {
            result += dp[N][i];
        }

        System.out.println(result % 10007);
    }
}
