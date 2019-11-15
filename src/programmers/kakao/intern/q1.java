package programmers.kakao.intern;

import org.junit.Test;

import java.util.Stack;

import static org.junit.Assert.assertEquals;

public class q1 {
    @Test
    public void test() {
        assertEquals(4, solution(new int[][]{new int[]{0, 0, 0, 0, 0}, new int[]{0, 0, 1, 0, 3}, new int[]{0, 2, 5, 0, 1}, new int[]{4, 2, 4, 4, 2}, new int[]{3, 5, 1, 3, 1}}, new int[]{1, 5, 3, 5, 1, 2, 1, 4}));
    }

    public int solution(int[][] board, int[] moves) {
        int answer = 0;

        Stack<Integer> basket = new Stack<>();

        for (int move : moves) {
            for (int j = 0; j < board.length; j++) {
                int item = board[j][move - 1];

                if (item == 0) {
                    continue;
                }

                System.out.println(item);

                if (basket.isEmpty() || item != basket.peek()) {
                    basket.push(item);
                    board[j][move - 1] = 0;
                    break;
                }

                if (!basket.isEmpty() && item == basket.peek()) {
                    basket.pop();
                    board[j][move - 1] = 0;
                    answer += 2;
                    break;
                }
            }
        }


        return answer;
    }
}
