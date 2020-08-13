package beckjoon;

import java.util.Scanner;

public class BaekJoon1735 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numerator1 = scanner.nextInt();
        int denominator1 = scanner.nextInt();
        int numerator2 = scanner.nextInt();
        int denominator2 = scanner.nextInt();

        int numerator = denominator1 * numerator2 + denominator2 * numerator1;
        int denominator = denominator1 * denominator2;
        int gcd = getGCD(denominator, numerator);

        System.out.print(numerator/gcd + " " + denominator/gcd);
    }

    private static int getGCD(int denominator, int numerator) {
        int large = Math.max(denominator, numerator);
        int small = Math.min(denominator, numerator);

        while (small > 0) {
            int temp = large % small;
            large = small;
            small = temp;
        }

        return large;
    }
}