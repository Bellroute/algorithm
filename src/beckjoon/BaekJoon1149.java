package beckjoon;

import java.util.Scanner;

public class BaekJoon1149 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int[][] rgb = new int[N + 1][3];

        for (int i = 1; i <= N; i++) {
            for (int j = 0; j < 3; j++) {
                rgb[i][j] = scanner.nextInt();
            }
        }

        int[][] dp = new int[N + 1][3];

        dp[1][0] = rgb[1][0];
        dp[1][1] = rgb[1][1];
        dp[1][2] = rgb[1][2];

        for (int i = 2; i < N + 1; i++) {
            for (int j = 0; j < 3; j++) {
                dp[i][j] = Math.min(dp[i - 1][(j + 1) % 3], dp[i - 1][(j + 2) % 3]);
                dp[i][j] += rgb[i][j];
            }
        }

        int result = dp[N][0];

        result = Math.min(result, dp[N][1]);
        result = Math.min(result, dp[N][2]);

        System.out.println(result);
    }
}
