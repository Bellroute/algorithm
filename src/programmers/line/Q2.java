package programmers.line;

import java.util.*;

public class Q2 {

    public int[] solution(int[] ball, int[] order) {
        List<Integer> list = new ArrayList<>();
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < ball.length; i++) {
            deque.push(ball[i]);
        }

        Stack<Integer> stack = new Stack<>();
        Stack<Integer> tmpStack = new Stack<>();

        for (int i = order.length - 1; i >= 0; i--) {
            stack.push(order[i]);
        }

        while (!deque.isEmpty()) {
            if (stack.isEmpty()){
                while (!tmpStack.isEmpty()) {
                    stack.push(tmpStack.pop());
                }
            }

            int tmp = stack.pop();

            if (deque.peekFirst() == tmp) {
                deque.pollFirst();

                while (!tmpStack.isEmpty()) {
                    stack.push(tmpStack.pop());
                }

                list.add(tmp);
                continue;
            }

            if (deque.peekLast() == tmp) {
                deque.pollLast();
                while (!tmpStack.isEmpty()) {
                    stack.push(tmpStack.pop());
                }
                list.add(tmp);
                continue;
            }

            tmpStack.push(tmp);
        }

        return list.stream().mapToInt(i -> i).toArray();
    }
}
