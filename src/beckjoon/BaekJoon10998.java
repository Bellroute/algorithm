package beckjoon;

import java.util.Scanner;

public class BaekJoon10998 {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String input = scanner.nextLine();

        int a = Integer.parseInt(input.split(" ")[0]);
        int b = Integer.parseInt(input.split(" ")[1]);

        System.out.println(a * b);
    }
}