package beckjoon;

import java.util.Scanner;

public class BaekJoon2609 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = scanner.nextInt();
        int b = scanner.nextInt();

        int gcd = euclid(a, b);
        int lcm = lcm(a, b);

        System.out.println(gcd);
        System.out.println(lcm);
    }

    private static int lcm(int a, int b) {
        int gcd = euclid(a, b);
        int total = gcd * (a / gcd) * (b / gcd);

        return total;
    }

    private static int euclid(int a, int b) {
        int num = b;

        while (num != 0) {
            if (a % num != 0) {
                int temp = a;
                a = num;
                num = temp % num;
            } else {
                break;
            }
        }

        return num;
    }
}
