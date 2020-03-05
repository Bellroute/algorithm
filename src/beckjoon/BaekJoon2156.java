package beckjoon;

import java.util.Scanner;

public class BaekJoon2156 {
    private static int n;
    private static int[] numbers;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt();
        numbers = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            numbers[i] = scanner.nextInt();
        }

        int[] dp = new int[n + 1];

        dp[1] = numbers[1];

        if (n > 1) {
            dp[2] = dp[1] + numbers[2];

            for (int i = 3; i <= n; i++) {
                dp[i] = Math.max(dp[i - 3] + numbers[i] + numbers[i - 1], dp[i - 2] + numbers[i]);
                dp[i] = Math.max(dp[i], dp[i - 1]);
            }

        }


        System.out.println(dp[n]);
    }


//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//
//        n = scanner.nextInt();
//        numbers = new int[n + 1];
//
//        for (int i = 1; i <= n; i++) {
//            numbers[i] = scanner.nextInt();
//        }
//
//        int[][] dp = new int[n + 1][2];
//
//        dp[1][0] = 0;
//        dp[1][1] = numbers[1];
//
//        if (n > 1) {
//            dp[2][0] = Math.max(dp[1][0], dp[1][1]);
//            dp[2][1] = Math.max(dp[1][0] + numbers[2], dp[1][1] + numbers[2]);
//
//            for (int i = 3; i <= n; i++) {
//                dp[i][0] = Math.max(dp[i - 3][0] + numbers[i - 2]+ numbers[i - 1], dp[i - 3][1] + numbers[i - 1]);
//                dp[i][1] = Math.max(dp[i - 3][1] + numbers[i - 1] + numbers[i], dp[i - 3][1] + numbers[i]);
//                dp[i][1] = Math.max(dp[i][1], dp[i - 3][1] + numbers[i - 2] + numbers[i]);
//            }
//        }
//
//
//        System.out.println(Math.max(dp[n][0], dp[n][1]));
//    }
}
