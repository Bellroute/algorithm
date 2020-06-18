package neowiz;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class P2 {
    private boolean increaseFlag;

    @Test
    public void test() {
        assertEquals(1, solution(new int[]{1, 2, 3}));
        assertEquals(2, solution(new int[]{3, -1, 0, 4}));
    }

    public int solution(int[] s) {
        int answer = 0;
        increaseFlag = true;

        for (int i = 0; i < s.length - 1; i++) {

            if (increaseFlag) {
                if (!isIncrease(s[i], s[i + 1])) {
                    reverseFlag();
                    answer++;
                }

                reverseFlag();
            } else {
                if (!isDecrease(s[i], s[i + 1])) {
                    reverseFlag();
                    answer++;
                }
                reverseFlag();
            }
        }

        return answer;
    }

    private void reverseFlag() {
        increaseFlag = !increaseFlag;
    }

    private boolean isDecrease(int a, int b) {
        return a > b;
    }

    private boolean isIncrease(int a, int b) {
        return a < b;
    }
}
