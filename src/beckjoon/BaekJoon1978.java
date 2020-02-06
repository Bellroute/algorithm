package beckjoon;

import java.util.Scanner;

public class BaekJoon1978 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int[] numbers = new int[N];
        int count = 0;

        for (int i = 0; i < N; i++) {
            numbers[i] = scanner.nextInt();
        }

        boolean[] isNotPrime = new boolean[10001];

        isNotPrime[0] = true;
        isNotPrime[1] = true;

        for (int i = 2; i < isNotPrime.length; i++) {
            int number = i * 2;

            while (number <= 10000) {
                isNotPrime[number] = true;
                number += i;
            }
        }

        for (int i = 0; i < N; i++) {
            int number = numbers[i];

            if (!isNotPrime[number]) {
                count++;
            }
        }

        System.out.println(count);
    }
}
