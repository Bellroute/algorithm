package beckjoon;

import java.util.Arrays;
import java.util.Scanner;

public class BaekJoon1037 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = scanner.nextInt();
        int[] factors = new int[number];

        for (int i = 0; i < number; i++) {
            factors[i] = scanner.nextInt();
        }

        Arrays.sort(factors);

        System.out.println(factors[0] * factors[number - 1]);
    }
}
