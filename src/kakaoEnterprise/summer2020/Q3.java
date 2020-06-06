package kakaoEnterprise.summer2020;

import java.util.Scanner;

public class Q3 {
    private static int N;
    private static int K;
    private static int[] cookies;
    private static int max = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();
        K = scanner.nextInt();

        cookies = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            double input = scanner.nextDouble();
            cookies[i] = (int) (input * 1000);
            max = Math.max(max, cookies[i]);
        }

        int start = 0;
        int end = max;
        int result = 0;

        while (start <= end) {
            int mid = (int) Math.round((double)(start + end) / 2.0);
            int sum = 0;

            for (int cookie : cookies) {
                sum += cookie / mid;
            }

            if (sum == K) {
                result = Math.max(result, mid);
            }

            if (sum >= K) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        long answer = Math.round((double) result / 10.0);

        System.out.println(String.format("%.2f", (double) answer / 100.0));
    }
}
