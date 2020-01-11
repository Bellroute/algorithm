package beckjoon;

import java.util.Scanner;
import java.util.Stack;

public class BaekJoon9012 {
    private static final String YES = "YES";
    private static final String NO = "NO";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        String[] inputs = new String[N];
        scanner.nextLine();

        for (int i = 0; i < N; i++) {
            inputs[i] = scanner.nextLine();
        }

        for (int i = 0; i < N; i++) {
            String input = inputs[i];
            if (isVPS(input)) {
                System.out.println(YES);
            } else {
                System.out.println(NO);
            }
        }
    }

    private static boolean isVPS(String input) {
        Stack<Character> stack = new Stack<>();

        for (int j = 0; j < input.length(); j++) {
            if (input.charAt(j) == '(') {
                stack.push(input.charAt(j));
            } else {
                if (!stack.empty()) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }

        if (stack.empty()) {
            return true;
        } else {
            return false;
        }
    }


}
