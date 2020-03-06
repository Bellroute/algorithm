package beckjoon;

import java.util.Scanner;

public class BaekJoon11052 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int[] P = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            P[i] = scanner.nextInt();
        }

        int[] dp = new int[N + 1];

        dp[1] = P[1];

        for (int i = 2; i <= N; i++) {
            dp[i] = P[i];

            for (int j = 0; j <= i / 2; j++) {
                dp[i] = Math.max(dp[i], dp[i - j] + dp[j]);
            }
        }

        System.out.println(dp[N]);
    }
}
