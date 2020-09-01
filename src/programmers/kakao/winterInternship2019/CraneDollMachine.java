package programmers.kakao.winterInternship2019;

import org.junit.Test;

import java.util.Stack;

import static org.junit.Assert.assertEquals;


public class CraneDollMachine {

    private Stack<Integer> bucket = new Stack<>();
    private int answer = 0;

    @Test
    public void test() {
        assertEquals(4, solution(new int[][]{{0, 0, 0, 0, 0}, {0, 0, 1, 0, 3}, {0, 2, 5, 0, 1}, {4, 2, 4, 4, 2}, {3, 5, 1, 3, 1}}, new int[] {1, 5, 3, 5, 1, 2, 1, 4}));
    }

    public int solution(int[][] board, int[] moves) {
        int height = board.length;

        for (int target : moves) {
            target--;

            for (int j = 0; j < height; j++) {
                if (board[j][target] != 0) {
                    pick(board[j][target]);
                    board[j][target] = 0;

                    break;
                }
            }
        }

        return answer;
    }

    private void pick(int item) {
        if (!bucket.empty() && bucket.peek() == item) {
            bucket.pop();
            answer += 2;

            return;
        }

        bucket.push(item);
    }
}
