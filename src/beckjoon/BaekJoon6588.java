package beckjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BaekJoon6588 {
    private static final String NOT_FOUND_MESSAGE = "Goldbach's conjecture is wrong.";
    private static List<Integer> primeNumbers = new ArrayList<>();
    private static int max = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = new ArrayList<>();

        int input = scanner.nextInt();

        while (input != 0) {
            numbers.add(input);

            max = Math.max(max, input);
            input = scanner.nextInt();
        }

        setPrimeNumbers(max);

        for (int target : numbers) {

            int s = 0;
            int e = setEndPoint(target);

            while (primeNumbers.get(s) + primeNumbers.get(e) != target) {

                if (primeNumbers.get(s) + primeNumbers.get(e) < target) {
                    s++;
                } else if (primeNumbers.get(s) + primeNumbers.get(e) > target) {
                    e--;
                }

                if (s >= primeNumbers.size() || e < 0) {
                    System.out.println(NOT_FOUND_MESSAGE);
                    break;
                } else if (primeNumbers.get(s) + primeNumbers.get(e) == target) {
                    System.out.printf("%d = %d + %d\n", target, primeNumbers.get(s), primeNumbers.get(e));
                    break;
                }

            }
        }
    }

    private static int setEndPoint(int target) {
        int result = 0;

        if (target == max) {
            return primeNumbers.size() - 1;
        }

            for (int i = 0; i < primeNumbers.size(); i++) {
                if (target < primeNumbers.get(i)) {
                    result = i - 1;
                    break;
                }
            }

        return result;
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
