package coupang;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class Q3 {

    @Test
    public void test() {
        System.out.println(solution(3, new int[]{24, 22, 20, 10, 5, 3, 2, 1}));
        System.out.println(solution(2, new int[] {1300000000,700000000,668239490,618239490,568239490,568239486,518239486,157658638,157658634,100000000,100}));
    }

    public int solution(int k, int[] score) {
        int answer = 0;

        Map<Integer, Integer> countMap = new HashMap<>();
        int[] scoreGaps = new int[score.length];

        scoreGaps[0] = 0;

        for (int i = 1; i < score.length; i++) {
            int gap = score[i - 1] - score[i];

            countMap.put(gap, countMap.getOrDefault(gap, 0) + 1);
            scoreGaps[i] = gap;
        }

        for (int i = 1; i < scoreGaps.length; i++) {
            if (countMap.get(scoreGaps[i]) >= k) {
                scoreGaps[i - 1] = -1;
                scoreGaps[i] = -1;
            }
        }

        for (int i = 0; i < scoreGaps.length; i++) {
            if (scoreGaps[i] == -1) {
                continue;
            }

            answer++;
        }


        return answer;
    }
}
