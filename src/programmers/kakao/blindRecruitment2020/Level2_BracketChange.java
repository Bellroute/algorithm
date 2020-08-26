package programmers.kakao.blindRecruitment2020;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Level2_BracketChange {

    @Test
    public void test() {
        assertEquals("(()())()", solution("(()())()"));
        assertEquals("()", solution(")("));
        assertEquals("()(())()", solution("()))((()"));
    }


    public String solution(String p) {
        String answer = "";

        if (isRight(p)) {
            return p;
        }

        answer = separate(p);

        return answer;
    }

    private String separate(String p) {
        String result = "";

        if (p.equals("")) {
            return p;
        }

        int index = findSeparatePoint(p);
        String u = p.substring(0, index);
        String v = p.substring(index);

        if (isRight(u)) {
            result = u + separate(v);
        } else {
            v = "(" + separate(v) + ")";
            result = v + change(u);
        }



        return result;
    }

    private int findSeparatePoint(String p) {
        int close = 0, open = 0;
        int i;

        for (i = 0; i < p.length(); i++) {

            if (p.charAt(i) == '(') {
                open++;
            } else {
                close++;
            }

            if (open == close) {
                return i + 1;
            }
        }

        return i;
    }

    private String change(String input) {
        input = input.replace("(", "0");
        input = input.replace(")", "(");
        input = input.replace("0", ")");

        return input.substring(1, input.length() - 1);
    }

    private boolean isRight(String p) {
        int count = 0;

        for (int i = 0; i < p.length(); i++) {

            switch (p.charAt(i)) {
                case '(':
                    count++;
                    continue;
                case ')':
                    count--;
            }

            if (count < 0) {
                return false;
            }
        }

        return count == 0;
    }
}
