package beckjoon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class BaekJoon2529 {
    private static int k;
    private static char[] signs;
    private static boolean[] used = new boolean[10];
    private static List<String> results = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        k = scanner.nextInt();
        signs = new char[k];

        for (int i = 0; i < k; i++) {
            signs[i] = scanner.next().toCharArray()[0];
        }

        getResult(0, 0);

        Collections.sort(results);

        System.out.println(results.get(results.size() - 1));
        System.out.println(results.get(0));
    }

    private static void getResult(int index, long number) {

        if (index == k + 1) {
            String result = Long.toString(number);

            if (number / Math.pow(10, k) < 1) {
                result = "0" + result;
            }

            results.add(result);
            return;
        }

        for (int i = 0; i < 10; i++) {

            if (used[i]) {
                continue;
            }

            if (index == 0) {
                used[i] = true;
                getResult(1, i);
                used[i] = false;
                continue;
            }

            long lastNumber = number & 10;

            if (signs[index - 1] == '<') {
                if (lastNumber < i) {
                    used[i] = true;
                    getResult(index + 1, number * 10 + i);
                    used[i] = false;
                }
            } else if (signs[index - 1] == '>') {
                if (lastNumber > i) {
                    used[i] = true;
                    getResult(index + 1, number * 10 + i);
                    used[i] = false;
                }
            }
        }
    }
}
