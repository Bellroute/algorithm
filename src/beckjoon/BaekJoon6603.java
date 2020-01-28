package beckjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BaekJoon6603 {
    private static int[] numbers;
    private static int depth;
    private static List<String> results = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            int k = scanner.nextInt();

            if (k == 0) {
                break;
            } else {
                numbers = new int[k];

                for (int i = 0; i < k; i++) {
                    numbers[i] = scanner.nextInt();
                }

                for (int i = 0; i < k; i++) {
                    depth = 1;
                    backtracking(i, numbers[i] + " ");
                }

            }

            results.add("");
        }

        for (int i = 0; i < results.size() - 1; i++) {
            System.out.println(results.get(i));
        }
    }

    private static void backtracking(int start, String result) {
        if (depth == 6) {
            results.add(result.trim());
        } else {
            for (int i = start + 1; i < numbers.length; i++) {
                depth++;
                backtracking(i, result + numbers[i] + " ");
            }

        }
        --depth;
    }
}
