package beckjoon;

import java.util.Scanner;

public class Baekjoon14581 {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String input = scanner.nextLine();

        printResult(input);
    }

    private static void printResult(String input) {
        String boj = ":fan:";

        System.out.println(boj + boj + boj);
        System.out.println(boj + ":" + input + ":" + boj);
        System.out.println(boj + boj + boj);
    }
}
