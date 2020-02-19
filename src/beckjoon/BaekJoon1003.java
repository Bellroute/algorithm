package beckjoon;

import java.util.Scanner;

public class BaekJoon1003 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();
        int[] inputs = new int[T];

        for (int i = 0; i < inputs.length; i++) {
            inputs[i] = scanner.nextInt();
        }

        int[][] fibonacciSet = new int[41][2];

        fibonacciSet[0][0] = 1;
        fibonacciSet[0][1] = 0;
        fibonacciSet[1][0] = 0;
        fibonacciSet[1][1] = 1;

        for (int i = 2; i < fibonacciSet.length; i++) {
            fibonacciSet[i][0] = fibonacciSet[i - 1][1];
            fibonacciSet[i][1] = fibonacciSet[i - 1][0] + fibonacciSet[i - 1][1];
        }

        for (int input : inputs) {
            System.out.println(fibonacciSet[input][0] + " " + fibonacciSet[input][1]);
        }
    }
}
