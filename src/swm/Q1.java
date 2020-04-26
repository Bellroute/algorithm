package swm;

import java.util.Scanner;

public class Q1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int input[] = new int[n];
        int sum[] = new int[n];

        for (int i = 0; i < n; i++) {
            input[i] = scanner.nextInt();
        }

        sum[0] = input[0];
        int max = input[0];

        for (int i = 1; i < n; i++) {
            sum[i] = Math.max(input[i], sum[i - 1] + input[i]);
            max = Math.max(max, sum[i]);
        }

        System.out.println(max);
    }

}
