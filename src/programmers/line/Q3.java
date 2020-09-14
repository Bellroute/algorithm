package programmers.line;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Q3 {

    @Test
    public void test() {
        assertEquals(4, solution(73425)[0]);
        assertEquals(0, solution(9)[0]);
    }

    private int[] answer = new int[2];

    public int[] solution(int n) {
        String strNumber = Integer.toString(n);
        int count = 0;

        if (n < 10) {
            answer[0] = 0;
            answer[1] = n;

            return answer;
        }

        while (true) {
            int min = Integer.MAX_VALUE;

            for (int i = 1; i < strNumber.length(); i++) {
                String first = strNumber.substring(0, i);
                String second = strNumber.substring(i);

                if (second.charAt(0) == '0') {
                    continue;
                }

                int sum = Integer.parseInt(first) + Integer.parseInt(second);
                min = Math.min(sum, min);
            }

            strNumber = Integer.toString(min);
            count++;

            if (min < 10) {
                break;
            }
        }

        answer[0] = count;
        answer[1] = Integer.parseInt(strNumber);

        return answer;
    }
}
