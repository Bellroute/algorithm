package programmers.line;

import java.util.HashMap;
import java.util.Map;

public class Q1 {

    public static void main(String[] args) {
        System.out.println(solution(new int[][] {{1, 2}, {2, 1}, {3, 3}, {4, 5}, {5, 6}, {7, 8}}));
        System.out.println(solution(new int[][] {{1, 2}, {3, 4}, {5, 6}}));
        System.out.println(solution(new int[][] {{1, 2}, {2, 3}, {3, 1}}));
        System.out.println(solution(new int[][] {{1, 2}, {3, 4}, {5, 6}}));
    }

    public static int solution(int[][] boxes) {
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < boxes.length; i++) {
            map.put(boxes[i][0], map.getOrDefault(boxes[i][0], 0) + 1);
            map.put(boxes[i][1], map.getOrDefault(boxes[i][1], 0) + 1);
        }

        for (Integer key : map.keySet()) {
            if (map.get(key) % 2 != 0) {
                answer++;
            }
        }
        return answer / 2;
    }
}
