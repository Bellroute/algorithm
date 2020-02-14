package beckjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BaekJoon1644 {
    private static List<Integer> primeNumbers = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();

        setPrimeNumbers(N);

        int count = 0;

        for (int i = 0; i < primeNumbers.size(); i++) {
            int total = 0;
            int index = i;

            while (total <= N && index < primeNumbers.size()) {
                total += primeNumbers.get(index);
                index++;

                if (total == N) {
                    count++;
                    break;
                }
            }
        }

        System.out.println(count);
    }

    private static void setPrimeNumbers(int max) {
        boolean[] isNotPrime = new boolean[max + 1];

        isNotPrime[0] = true;
        isNotPrime[1] = true;

        for (int i = 2; i < isNotPrime.length; i++) {
            int next = i + i;

            if (!isNotPrime[i]) {
                while (next <= max) {
                    isNotPrime[next] = true;
                    next += i;
                }
            }
        }

        for (int i = 2; i < isNotPrime.length; i++) {
            if (!isNotPrime[i]) {
                primeNumbers.add(i);
            }
        }
    }
}
