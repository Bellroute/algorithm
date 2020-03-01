package beckjoon;

import java.util.Scanner;

public class BaekJoon11726 {
    private static int[] dp = new int[1001];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        dp[1] = 1;
        dp[2] = 2;

        int answer = solution(n);

        System.out.println(answer);
    }

    private static int solution(int n) {
        if (n == 1) {
            return dp[1];
        } else if (n == 2) {
            return dp[2];
        }

        if (dp[n] != 0) {
            return dp[n];
        } else {
            dp[n] = solution(n - 1) + solution(n - 2);

            return dp[n] % 10007;
        }
    }
}
