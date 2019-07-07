package beckjoon;

import java.util.Scanner;

public class BaekJoon15964 {
    private static Scanner scanner = new Scanner(System.in);
    private static String input;

    public static void main(String[] args) {
        input = scanner.nextLine();

        long A = Long.parseLong(input.split(" ")[0]);
        long B = Long.parseLong(input.split(" ")[1]);

        long result = (A + B) * (A - B);

        System.out.println(result);
    }
}
