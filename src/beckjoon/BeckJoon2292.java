package beckjoon;

import java.util.Scanner;

public class BeckJoon2292 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        int n = 1;
        int c = 1;

        while (input > n) {
            n += 6 * c;
            c++;
        }

        System.out.println(c);
    }
}