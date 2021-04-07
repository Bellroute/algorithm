package programmers;

import java.util.HashMap;
import java.util.Map;

public class Q1 {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{5, 4, 5, 4, 5}, new int[]{1, 2, 3, 5, 4}));
    }
    public static int solution(int[] giftCards, int[] wants) {
            int answer = 0;
            Map<Integer, Integer> cardTable = new HashMap<>();

            for (int i = 0; i < giftCards.length; i++) {
                cardTable.put(giftCards[i], i);
            }

            for (int i = 0; i < wants.length; i++) {
                int now = giftCards[i];
                int want = wants[i];
                int onwer = cardTable.get(want);

                if (onwer == i) {
                    continue;
                }

                cardTable.put(want, i);
                cardTable.put(now, onwer);
            }

            for (int i = 0; i < giftCards.length; i++) {
                if (cardTable.get(wants[i]) != i) {
                    answer++;
                }
            }

            return answer;
    }
}
