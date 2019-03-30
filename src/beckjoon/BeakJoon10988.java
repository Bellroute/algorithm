package beckjoon;

import java.util.Scanner;

public class BeakJoon10988 {
    private static Scanner scanner = new Scanner(System.in);
    private static char[] result = new char[102];
    private static String input;
    private static StringBuilder reverse = new StringBuilder();

    public static void main(String[] args) {
        input = scanner.next();

        for (int i = 0; i < input.length(); i++) {
            result[i] = input.charAt(i);
        }

        for (int i = input.length() - 1; i >= 0; i--) {
            reverse.append(result[i]);
        }

        if (input.equals(reverse.toString())) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}
