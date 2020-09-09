package programmers.kakao.internship2020;

import java.util.*;

public class Level3_JewelryShopping {

    public int[] solution(String[] gems) {
        Queue<String> queue = new LinkedList<>();
        Set<String> jewelry = new HashSet<>(Arrays.asList(gems));
        Map<String, Integer> jewelryHashMap = new HashMap<>();

        int start = 0;
        int end = Integer.MAX_VALUE;
        int startPoint = 0;

        for (int i = 0; i < gems.length; i++) {
            jewelryHashMap.put(gems[i], jewelryHashMap.getOrDefault(gems[i], 0) + 1);
            queue.offer(gems[i]);

            while (true) {
                String jewel = queue.peek();

                if (jewelryHashMap.get(jewel) > 1) {
                    queue.poll();
                    start++;

                    jewelryHashMap.put(jewel, jewelryHashMap.get(jewel) - 1);
                } else {
                    break;
                }
            }

            if(jewelryHashMap.size() == jewelry.size() && end > queue.size()) {
                end = queue.size();
                startPoint = start;
            }
        }

        return new int[]{startPoint + 1, startPoint + end};
    }
}
