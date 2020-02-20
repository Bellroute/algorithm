package beckjoon;

import java.util.Scanner;

public class BaekJoon2579 {
    private static int[] stairs;

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            int N = scanner.nextInt();
            stairs = new int[N + 1];

            for (int i = 1; i <= N; i++) {
                stairs[i] = scanner.nextInt();
            }

            int[] dp = new int[N + 1];

            dp[1] = stairs[1];

            if (N >= 2) {
                dp[2] = dp[1] + stairs[2];
            }

            for (int i = 3; i <= N; i++) {
                dp[i] = Math.max(dp[i - 3] + stairs[i] + stairs[i - 1], dp[i - 2] + stairs[i]);
            }

            System.out.println(dp[N]);
        }
}

//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//
//        int N = scanner.nextInt();
//        stairs = new int[N];
//
//        for (int i = 0; i < N; i++) {
//            stairs[i] = scanner.nextInt();
//        }
//
//        boolean[] isNotAble = new boolean[N];
//
//        int sum = 0;
//        int index = N - 1;
//
//        while (index >= 2) {
//            int min = stairs[index];
//            int minIndex = index;;
//
//            if (index == N - 1) {
//                if (stairs[index - 1] < stairs[index - 2]) {
//                    minIndex = index - 1;
//                } else {
//                    minIndex = index - 2;
//                }
//            } else {
//                for (int i = index - 1; i >= index - 2; i--) {
//                    if (min >= stairs[i]) {
//                        min = stairs[i];
//                        minIndex = i;
//                    }
//                }
//            }
//
//            isNotAble[minIndex] = true;
//            index = minIndex - 1;
//        }
//
//        for (int i = 0; i < isNotAble.length; i++) {
//            if (!isNotAble[i]) {
//                sum += stairs[i];
//            }
//        }
//
//        System.out.println(sum);
//    }
