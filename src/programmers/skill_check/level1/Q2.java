package programmers.skill_check.level1;

import java.util.*;

public class Q2 {

    private int[] supo1 = {1, 2, 3, 4, 5};
    private int[] supo2 = {2, 1, 2, 3, 2, 4, 2, 5};
    private int[] supo3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

    public int[] solution(int[] answers) {
        int length = answers.length;
        int[][] students = {supo1, supo2, supo3};
        Map<Integer, List<Integer>> map = new HashMap<>();
        int max = 0;

        for (int i = 0; i < students.length; i++) {
            int count = 0;

            for (int j = 0; j < length; j++) {
                if (answers[j] == students[i][j % students[i].length]) {
                    count++;
                }
            }

            List<Integer> list = map.getOrDefault(count, new ArrayList<>());
            list.add(i + 1);

            map.put(count, list);

            max = Math.max(max, count);
        }

        Collections.sort(map.get(max));

        for (Integer key :
                map.keySet()) {
            System.out.println(key +  " " + map.get(key));
        }

        int[] answer = new int[map.get(max).size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = map.get(max).get(i);
        }

        return answer;
    }
}
