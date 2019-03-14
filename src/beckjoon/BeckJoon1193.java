package beckjoon;

import java.util.Scanner;

public class BeckJoon1193 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        int n = 1;

        while (input > n * (n + 1) / 2) {
            n++;
        }

        String result = null;

        int c = input - n * (n - 1) / 2;

        if (n % 2 == 1) {
            result = (n - c + 1) + "/" + c;
        }
        if (n % 2 == 0) {
            result = c + "/" + (n - c + 1);
        }

        if (input == 1) {
            System.out.println("1/1");
        } else {
            System.out.println(result);
        }
    }
}
