package beckjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class BaekJoon10828 {
    private static Stack<Integer> stack = new Stack<>();
    private static int N;
    private static List<Integer> results = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < N; i++) {
            String command = scanner.nextLine();
            getCommandResult(command);
        }

        for (int i = 0; i < results.size(); i++) {
            System.out.println(results.get(i));
        }
    }

    private static void getCommandResult(String command) {
        switch (command.split(" ")[0]) {
            case "push":
                stack.push(Integer.parseInt(command.split(" ")[1]));
                break;
            case "pop":
                if (stack.isEmpty()) {
                    results.add(-1);
                } else {
                    results.add(stack.pop());
                }
                break;
            case "size":
                results.add(stack.size());
                break;
            case "empty":
                if (stack.isEmpty()) {
                    results.add(1);
                } else {
                    results.add(0);
                }
                break;
            case "top":
                if (stack.isEmpty()) {
                    results.add(-1);
                } else {
                    results.add(stack.peek());
                }
                break;
        }
    }
}


//    push X: 정수 X를 스택에 넣는 연산이다.
//    pop: 스택에서 가장 위에 있는 정수를 빼고, 그 수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
//    size: 스택에 들어있는 정수의 개수를 출력한다.
//    empty: 스택이 비어있으면 1, 아니면 0을 출력한다.
//    top: 스택의 가장 위에 있는 정수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.