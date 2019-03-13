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
            for (int i = 0; i < c; i++) {
                result = (n - i) + "/" + (1 + i);
            }
        }
        if (n % 2 == 0) {
            for (int i = 0; i < c; i++) {
                result = (1 + i) + "/" + (n - i);
            }
        }

        if (input == 1) {
            System.out.println("1/1");
        } else {
            System.out.println(result);
        }
    }
}
