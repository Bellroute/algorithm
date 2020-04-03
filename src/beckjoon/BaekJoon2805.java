package beckjoon;

import java.util.Scanner;

public class BaekJoon2805 {
    private static int N;
    private static int M;
    private static int[] trees;
    private static long max = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();
        M = scanner.nextInt();

        trees = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            trees[i] = scanner.nextInt();
            max = Math.max(max, trees[i]);
        }

        long start = 0;
        long end = max;

        while (start <= end) {
            long mid = (start + end) / 2;
            long sum = 0;

            for (int tree : trees) {
                if (tree > mid) {
                    sum += tree - mid;
                }
            }

            if (sum >= M) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        System.out.println(end);
    }
}
