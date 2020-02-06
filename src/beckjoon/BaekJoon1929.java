package beckjoon;

import java.util.Scanner;

public class BaekJoon1929 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int M = scanner.nextInt();
        int N = scanner.nextInt();
        boolean[] isNotPrime = new boolean[N + 1];

        isNotPrime[0] = true;
        isNotPrime[1] = true;
        for (int i = 2; i < isNotPrime.length; i++) {
            int number = i + i;

            while (number <= N) {
                isNotPrime[number] = true;
                number += i;
            }
        }

        for (int i = M; i <= N; i++) {
            if (!isNotPrime[i]) {
                System.out.println(i);
            }
        }
    }
}
