package beckjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BaekJoon6603 {
    private static List<String> results = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            int k = scanner.nextInt();

            if (k == 0) {
                break;
            }

            int[] numbers = new int[k];

            for (int i = 0; i < k; i++) {
                numbers[i] = scanner.nextInt();
            }

            for (int i = k - 1; i >= 0; i--) {
                backtracking(numbers, 0, 0, i, new StringBuilder());
            }

            results.add("");
        }

        for (int i = 0; i < results.size() - 1; i++) {
            System.out.println(results.get(i));
        }
    }

    private static void backtracking(int[] numbers, int count, int now, int index, StringBuilder result) {
        System.out.println("count: " + count);
        System.out.println("now: " + now);

        if (count < 6) {
            if (now != index) {
                result.append(numbers[now] + " ");
            }

            for (int i = now + 1; i < numbers.length; i++) {
                backtracking(numbers, count + 1, i, index, result);
            }

        } else {
            results.add(result.toString().trim());
        }
    }
}
