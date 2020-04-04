package beckjoon;

import java.util.Scanner;

public class BaekJoon1654 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int K = scanner.nextInt();
        int N = scanner.nextInt();
        int[] lines = new int[K];
        int max = 0;

        for (int i = 0; i < K; i++) {
            lines[i] = scanner.nextInt();
            max = Math.max(max, lines[i]);
        }

        long start = 1;
        long end = max;

        while (start <= end) {
            long mid = (start + end) / 2;
            int count = 0;

            for (int line : lines) {
                count += line / mid;
            }

            if (count >= N) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        System.out.println(end);
    }
}
