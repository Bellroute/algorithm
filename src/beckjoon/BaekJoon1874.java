package beckjoon;

import java.util.Scanner;
import java.util.Stack;

public class BaekJoon1874 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] numbers = new int[N];


        for (int i = 0; i < N; i++) {
            numbers[i] = scanner.nextInt();
        }

        Stack<Integer> stack = new Stack<>();


        int count = 1;
        stack.push(1);

        for (int i = 0; i < N; i++) {
            int n = numbers[i];

            while (stack.peek() != n) {
                if (stack.peek() < n) {
                    stack.push(++count);
                    System.out.println("+");
                    continue;
                }

                if (stack.peek() >= n) {
                    stack.pop();
                    System.out.println("-");
                }
            }


        }
    }
}
