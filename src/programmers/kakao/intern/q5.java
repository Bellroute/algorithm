package programmers.kakao.intern;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class q5 {

    @Test
    public void test() {
        assertEquals(3, solution(new int[]{2, 4, 5, 3, 2, 1, 4, 2, 5, 1}, 3));
        assertEquals(2, solution(new int[]{3, 3, 3, 2, 0, 0}, 2));
        assertEquals(0, solution(new int[]{1, 0, 3, 2, 0, 0}, 1));
    }

    public int solution(int[] stone, int k) {
        int answer = 0;


        int max = 0;
        for (int i = 0; i < stone.length; i++) {
            if (stone[i] > max) {
                max = stone[i];
            }
        }

        List<Integer> index = new ArrayList<>();
        boolean isOver = false;

        for (int i = 1; i < max; i++) {
            if (isOver) {
                break;
            }

            index.add(0);

            for (int j = 1; j < stone.length - 1; j++) {
               if (stone[j] - i > 0) {
                   index.add(j);
               }
            }

            index.add(stone.length - 1);

            for (int j = 1; j < index.size(); j++) {
                if (Math.abs(index.get(j) - index.get(j - 1)) > k) {
                    answer = i;
                    isOver = true;
                }
            }

            index.clear();
        }

        return answer;
    }

    public int solution2(int[] stones, int k) {
        int answer = 0;
        boolean isStop = false;

        while (!isStop) {
            int skipCount = 0;

            for (int i = 0; i < stones.length; i++) {
                if (skipCount >= k) {
                    isStop = true;
                    break;
                }

                if (stones[i] != 0) {
                    skipCount = 0;
                    stones[i]--;
                } else {
                    skipCount++;
                }
            }

            if (!isStop) {
                answer++;
            }
        }
        return answer;
    }
}
