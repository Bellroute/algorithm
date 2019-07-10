package beckjoon;

import java.util.Scanner;

public class BaekJoon2908 {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String input = scanner.nextLine();

        String A = input.split(" ")[0];
        String B = input.split(" ")[1];



        int reversedA = reverse(A);
        int reversedB = reverse(B);

        if (reversedA > reversedB) {
            System.out.println(reversedA);
        } else {
            System.out.println(reversedB);
        }

    }

    private static int reverse(String number) {
        return Integer.parseInt(number.split("")[2] + number.split("")[1] + number.split("")[0]);
    }
}
