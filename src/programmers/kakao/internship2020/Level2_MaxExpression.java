package programmers.kakao.internship2020;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class Level2_MaxExpression {

    @Test
    public void test() {
        assertEquals(60420, solution("100-200*300-500+20"));
        assertEquals(300, solution("50*6-3*2"));
    }

    private char[][] sequence = {{'+', '-', '*'}, {'+', '*', '-'}, {'*', '+', '-'}, {'*', '-', '+'}, {'-', '+', '*'}, {'-', '*', '+'}};
    private List<Character> operations = new ArrayList<>();
    private long[] numbers;
    private int[] pointer;


    public long solution(String expression) {
        long max = 0;
        String parsedExpression = expression;

        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) > 57 || expression.charAt(i) < 48) {
                operations.add(expression.charAt(i));
                parsedExpression = parsedExpression.substring(0, i) + "," + parsedExpression.substring(i + 1);
            }
        }

        long[] inputNumbers = new long[parsedExpression.split(",").length];
        int[] inputPointer = new int[inputNumbers.length];

        for (int i = 0; i < inputNumbers.length; i++) {
            inputNumbers[i] = Integer.valueOf(parsedExpression.split(",")[i]);
            inputPointer[i] = i;
        }


        for (int i = 0; i < sequence.length; i++) {
            numbers = inputNumbers.clone();
            pointer = inputPointer.clone();

            for (int j = 0; j < sequence[i].length; j++) {
                char op = sequence[i][j];

                for (int k = 0; k < operations.size(); k++) {
                    if (op == operations.get(k)) {
                        calculate(op, pointer[k], pointer[k + 1]);
                    }
                }
            }

            max = Math.max(max, Math.abs(numbers[0]));
        }


        return max;
    }


    private void calculate(char op, int index1, int index2) {
        long number1 = numbers[index1];
        long number2 = numbers[index2];


        switch (op) {
            case '+':
                numbers[index1] = number1 + number2;
                break;
            case '-':
                numbers[index1] = number1 - number2;
                break;
            case '*':
                numbers[index1] = number1 * number2;
                break;
        }

        for (int i = 0; i < pointer.length; i++) {
            if (pointer[i] == index2) {
                pointer[i] = index1;
            }
        }
    }

}
