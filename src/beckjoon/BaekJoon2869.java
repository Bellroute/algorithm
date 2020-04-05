package beckjoon;

import java.util.Scanner;

public class BaekJoon2869 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int A = scanner.nextInt();
        int B = scanner.nextInt();
        int V = scanner.nextInt();

        int result = (V - B) / (A - B);

        if ((V - B) % (A - B) != 0) {
            result++;
        }

        System.out.println(result);
    }
}
