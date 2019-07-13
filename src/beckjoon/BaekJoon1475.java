package beckjoon;

import java.util.Scanner;

public class BaekJoon1475 {
    private static Scanner scanner = new Scanner(System.in);
    private static int[] set = new int[10];

    public static void main(String[] args) {
        String input = scanner.nextLine();

        input = input.replace('9', '6');

        for (int i = 0; i < input.length(); i++) {
            set[Integer.parseInt(input.split("")[i])]++;
        }

        set[6] = set[6] / 2 + set[6] % 2;

        int max = 0;

        for (int i = 0; i < set.length; i++) {
            if (max < set[i]) {
                max = set[i];
            }
        }

        System.out.println(max);
    }
}
