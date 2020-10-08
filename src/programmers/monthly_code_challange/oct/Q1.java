package programmers.monthly_code_challange.oct;

import java.util.Stack;

public class Q1 {

    public int solution(int n) {
        String number = makeTernary(n);
        number = reverse(number);

        int answer = makeDecimal(number);

        return answer;
    }

    private int makeDecimal(String number) {
        int result = 0;
        int temp = 1;

        for (int i = number.length() - 1; i >= 0; i--) {
            result += (number.charAt(i) - '0') * temp;
            temp *= 3;
        }

        return result;
    }

    private String reverse(String number) {
        StringBuilder sb = new StringBuilder();

        for (int i = number.length() - 1; i >= 0; i--) {
            sb.append(number.charAt(i));
        }

        return sb.toString();
    }

    private String makeTernary(int value) {
        Stack<Integer> stack = new Stack<>();

        StringBuilder result = new StringBuilder();

        while (value > 0) {
            stack.add(value % 3);
            value = value / 3;
        }

        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }

        if (result.toString().equals("")) {
            result = new StringBuilder("0");
        }

        return result.toString();
    }
}