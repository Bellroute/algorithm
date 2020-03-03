package beckjoon;

import java.util.Scanner;

public class BaekJoon1912 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] numbers = new int[n + 1];
        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            numbers[i] = scanner.nextInt();
        }

        dp[1] = numbers[1];
        int max = dp[1];

        for (int i = 2; i <= n; i++) {
            dp[i] = Math.max(dp[i - 1] + numbers[i], numbers[i]);
            max = Math.max(max, dp[i]);
        }

        System.out.println(max);
    }
}
