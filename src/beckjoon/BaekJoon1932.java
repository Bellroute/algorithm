package beckjoon;

import java.util.Scanner;

public class BaekJoon1932 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int[][] triangle = new int[N + 1][N + 1];
        int[][] dp = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= i; j++) {
                triangle[i][j] = scanner.nextInt();
            }
        }

        dp[1][1] = triangle[1][1];

        for (int i = 2; i <= N; i++) {
            dp[i][1] = dp[i - 1][1] + triangle[i][1];
            dp[i][i] = dp[i - 1][i - 1] + triangle[i][i];

            for (int j = 2; j < i; j++) {
                dp[i][j] = Math.max(dp[i - 1][j - 1] + triangle[i][j], dp[i - 1][j] + triangle[i][j]);
            }
        }

        int result = dp[N][1];

        for (int i = 2; i <= N; i++) {
            result = Math.max(result, dp[N][i]);
        }

        System.out.println(result);
    }
}
