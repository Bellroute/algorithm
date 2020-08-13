package beckjoon;

import java.util.Scanner;

public class BaekJoon12865 {
    private static int N;
    private static int K;
    private static int[] W;
    private static int[] V;
    private static int max = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();
        K = scanner.nextInt();
        W = new int[N + 1];
        V = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            W[i] = scanner.nextInt();
            V[i] = scanner.nextInt();
        }

        int[][] dp = new int[N + 1][K + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= K; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j - W[i] >= 0) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - W[i]] + V[i]);
                }
            }
        }

        System.out.println(dp[N][K]);
    }

//    private static int N;
//    private static int K;
//    private static int[] W;
//    private static int[] V;
//    private static int max = 0;
//
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//
//        N = scanner.nextInt();
//        K = scanner.nextInt();
//        W = new int[N];
//        V = new int[N];
//
//        for (int i = 0; i < N; i++) {
//            W[i] = scanner.nextInt();
//            V[i] = scanner.nextInt();
//        }
//
//        for (int i = 0; i < N; i++) {
//            if (W[i] <= K) {
//                greedy(i, W[i], V[i]);
//            }
//        }
//
//        System.out.println(max);
//    }
//
//    private static void greedy(int index, int weight, int value) {
//        for (int i = index + 1; i < N; i++) {
//            if (weight + W[i] <= K) {
//                greedy(i, weight + W[i], value + V[i]);
//            }
//        }
//
//        max = Math.max(max, value);
//    }
}
