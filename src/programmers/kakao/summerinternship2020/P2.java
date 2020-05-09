package programmers.kakao.summerinternship2020;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import static org.junit.Assert.assertEquals;

public class P2 {
    private long max = 0;
    private List<Long> numbers = new ArrayList<>();
    private List<Character> operators = new ArrayList<>();

    @Test
    public void test() {
        assertEquals(60420, solution("100-200*300-500+20"));
        assertEquals(300, solution("50*6-3*2"));
    }

    public long solution(String expression) {

        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) == '*' || expression.charAt(i) == '+' || expression.charAt(i) == '-') {
                operators.add(expression.charAt(i));
            }
        }

        StringTokenizer stringTokenizer = new StringTokenizer(expression, "*|+|-");

        while(stringTokenizer.hasMoreTokens()){
            numbers.add(Long.parseLong(stringTokenizer.nextToken()));
        }

        operate('*', '+', '-');
        operate('*', '-', '+');
        operate('+', '*', '-');
        operate('+', '-', '*');
        operate('-', '+', '*');
        operate('-', '*', '+');

        return max;
    }

    private void operate(char o1, char o2, char o3) {
        List<Long> cloneNumbers = numbers;
        List<Character> cloneOperators = operators;
        boolean[] visited1 = new boolean[cloneNumbers.size()];

        List<Long> numberList1 = new ArrayList<>();
        List<Character> operatorList1 = new ArrayList<>();


        for (int i = 0; i < operators.size(); i++) {
            if (operators.get(i) == o1) {
                numberList1.add(changeOperate(o1, cloneNumbers.get(i), cloneNumbers.get(i + 1)));
                visited1[i + 1] = true;
            } else {
                numberList1.add(numbers.get(i));
                operatorList1.add(operators.get(i));
            }

            visited1[i] = true;
        }

        List<Long> numberList2 = new ArrayList<>();
        List<Character> operatorList2 = new ArrayList<>();

        for (int i = 0; i < operatorList1.size(); i++) {
            if (operatorList1.get(i) == o2) {
                numberList2.add(changeOperate(o2, numberList1.get(i), numberList1.get(i + 1)));
            } else {
                numberList2.add(numberList1.get(i));
                operatorList2.add(operatorList1.get(i));
            }
        }

        long result = numberList2.get(0);

        for (int i = 1; i < numberList2.size(); i++) {
            result = changeOperate(operatorList2.get(0), result, numberList2.get(i));
        }

        if (result < 0) result *= -1;

        max = Math.max(max, result);
    }

    private long changeOperate(char operator, long num1, long num2) {
        switch (operator) {
            case '*':
                return num1 * num2;
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
        }

        return 0;
    }
}
