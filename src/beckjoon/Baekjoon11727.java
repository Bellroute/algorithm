package beckjoon;

import java.util.Scanner;

public class Baekjoon11727 {
    private static int[] dp = new int[10001];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int result = solution(n);

        System.out.println(result);
    }

    private static int solution(int n) {
        dp[1] = 1;
        dp[2] = 3;

        if (n == 1) {
            return dp[1];
        } else if (n == 2) {
            return dp[2] % 10007;
        }

        if (dp[n] != 0) {
            return dp[n];
        } else {
            dp[n] = solution(n - 1) + 2 * solution(n - 2);

            return dp[n] % 10007;
        }
    }
}
