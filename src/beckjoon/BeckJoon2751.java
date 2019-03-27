package beckjoon;

import java.util.Scanner;

public class BeckJoon2751 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] numbers = new int[N + 1];

        for (int i = 1; i < N + 1; i++) {
            numbers[i] = scanner.nextInt();
        }

        for (int i = N; i > 0; i--) {
            heap(numbers, i);
        }

        for (int i = 1; i < numbers.length; i++) {
            System.out.println(numbers[i]);
        }
    }

    static void heap(int[] numbers, int n) {
            if (numbers[2 * n] < numbers[n]) {
                int swap = numbers[2 * n];
                numbers[2 * n] = numbers[n];
                numbers[n] = swap;

                heap(numbers, 2 * n);
            }

            if (numbers[2 * n + 1] < numbers[n]) {
                int swap = numbers[n / 2];
                numbers[2 * n + 1] = numbers[n];
                numbers[n] = swap;

                heap(numbers, 2 * n + 1);
            }
    }
}
