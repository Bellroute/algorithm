package coupang;

import org.junit.Test;

import java.util.Stack;

public class Q1 {

    @Test
    public void test() {
        System.out.println(solution(10)[0]);
        System.out.println(solution(10)[1]);
    }

    public int[] solution(int N) {
        int[] answer = new int[2];

        answer[0] = 10;
        answer[1] = getDigitProduct(String.valueOf(N));

        for (int k = 2; k < 10; k++) {
            int digitProduct = getDigitProduct(makeBase(N, k));

            if (digitProduct > answer[1]) {
                answer[0] = k;
                answer[1] = digitProduct;
            } else if (digitProduct == answer[1]) {
                if (k > answer[0]) {
                    answer[0] = k;
                }
            }
        }

        return answer;
    }

    private int getDigitProduct(String number) {
        int result = 1;

        if (Integer.parseInt(number) == 0) {
            return 0;
        }

        for (int i = 0; i < number.length(); i++) {
            if (number.charAt(i) == '0') {
                continue;
            }

            result *= number.charAt(i) - '0';
        }

        return result;
    }

    private String makeBase(int value, int baseNumber) {
        Stack<Integer> stack = new Stack<>();

        StringBuilder result = new StringBuilder();

        while (value > 0) {
            stack.add(value % baseNumber);
            value = value / baseNumber;
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
