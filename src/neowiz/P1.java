package neowiz;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class P1 {

    private static final int NUM = 0; // 숫자
    private static final int LEFT = 1; // 왼쪽 괄호
    private static final int RIGHT = 2; // 오른쪽 괄호
    private static final int OP = 3; // 연산자
    private long answer;
    private List<String> result;

    @Test
    public void test() {
        assertEquals(11, solution("2-1x5-4x3+2"));
        assertEquals(5, solution("2x3-1"));
    }

    public long solution(String expression) {
        List<String> parsedExpression;

        char[] expressionSplit = expression.toCharArray();
        answer = Long.MIN_VALUE;
        String result = null;

        for (int i = 0; i < expressionSplit.length; i++) {
            if (expressionSplit[i] >= '0' && expressionSplit[i] <= '9') {
                String newExpression = expression.substring(0, i) + "(";


                for (int j = i + 1; j < expressionSplit.length; j++) {
                    if (expressionSplit[j] >= '0' && expressionSplit[j] <= '9') {
                        parsedExpression = parse(newExpression + expression.substring(i, j + 1) + ")" + expression.substring(j + 1));

                        if (parsedExpression != null) {
                            result = calculate(postfix(parsedExpression));
                            if (result != null) {
                                if (result.endsWith("-0")) {
                                    result = result.replace("-0", "0");
                                }
                            }
                        }

                        answer = Math.max(answer, Long.parseLong(result));
                    }
                }
            }
        }

        return answer;
    }


    private int getType(String expr) {
        if (expr.equals("("))
            return LEFT;
        if (expr.equals(")"))
            return RIGHT;
        if (expr.equals("+"))
            return OP;
        if (expr.equals("-"))
            return OP;
        if (expr.equals("x"))
            return OP;
        if (expr.equals("/"))
            return OP;
        if (expr.equals("%"))
            return OP;
        if (expr.equals("^"))
            return OP;
        return NUM;
    }

    private List<String> parse(String expression) {
        result = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < expression.length(); i++) {
            char element = expression.charAt(i);

            if (element >= '0' && element <= '9') {
                stringBuilder.append(element);
            } else if (element == '(' || element == ')') {
                sliceStringBuilder(stringBuilder, element);
            } else if (element == '-') {
                if (i == 0) {
                    stringBuilder.append(element);
                } else {
                    char beforeElement = expression.charAt(i - 1);
                    if (beforeElement == '(' || beforeElement == 'x')
                        stringBuilder.append(element);
                    else {
                        sliceStringBuilder(stringBuilder, element);
                    }
                }
            } else if (element == '+' || element == 'x' || element == '/') {
                sliceStringBuilder(stringBuilder, element);
            }
        }
        result.add(stringBuilder.toString());

        return result;
    }

    private void sliceStringBuilder(StringBuilder stringBuilder, char element) {
        if (stringBuilder.length() > 0) {
            result.add(stringBuilder.toString());
            stringBuilder.delete(0, stringBuilder.length());
        }
        stringBuilder.append(element);
        result.add(stringBuilder.toString());
        stringBuilder.delete(0, stringBuilder.length());
    }

    private int getPrecedence(String op) {
        if (op.equals("+"))
            return 1;
        else if (op.equals("-"))
            return 1;
        else if (op.equals("x"))
            return 2;
        return 0;
    }

    private List<String> postfix(List<String> expression) {
        ArrayList<String> result = new ArrayList<>();
        Stack<String> stack = new Stack<>();

        for (String element : expression) {
            if (getType(element) == NUM)
                result.add(element);
            else if (getType(element) == LEFT) {
                stack.push(element);
            } else if (getType(element) == OP) {
                if (stack.isEmpty())
                    stack.push(element);
                else {
                    while (!stack.isEmpty()) {
                        if (getPrecedence(stack.lastElement()) >= getPrecedence(element))
                            result.add(stack.pop());
                        else
                            break;
                    }
                    stack.push(element);
                }
            } else if (getType(element) == RIGHT) {
                while (!stack.isEmpty() && (getType(stack.lastElement()) != LEFT)) {
                    result.add(stack.pop());
                }
                stack.pop();
            }
        }
        while (!stack.isEmpty()) {
            result.add(stack.pop());
        }
        return result;
    }

    private String calculate(List<String> expression) {
        Stack<Long> stack = new Stack<>();
        long n1, n2;
        long result = 0;

        for (String element : expression) {
            if (element.equals("")) {
                continue;
            }

            if (getType(element) == NUM) {
                stack.push(Long.parseLong(element));
            } else if (getType(element) == OP) {
                n2 = stack.pop();
                n1 = stack.pop();
                if (element.equals("+")) {
                    result = n1 + n2;
                } else if (element.equals("-")) {
                    result = n1 - n2;
                } else if (element.equals("x")) {
                    result = n1 * n2;
                }

                stack.push(result);
            }
        }
        return stack.pop().toString();
    }
}
