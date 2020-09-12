package programmers.kakao.blindRecruitment2021;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class Q2 {

    private Map<String, Integer> map;
    private String[] orders;
    private int max = 0;

    @Test
    public void test() {
        assertEquals(5, solution(new String[]{"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"}, new int[]{2, 3, 5}).length);
        assertEquals(4, solution(new String[]{"ABC", "ABC", "ABC"}, new int[]{2, 3}).length);
    }

    public String[] solution(String[] orders, int[] course) {
        List<String> answer = new ArrayList<>();
        this.orders = orders;

        for (int i = 0; i < orders.length; i++) {
            orders[i] = sortOrder(orders[i]);
        }

        Arrays.sort(orders, Comparator.comparingInt(String::length));

        for (int i = 0; i < course.length; i++) {
            int length = course[i];
            map = new HashMap<>();


            for (String order : orders) {
                max = 0;
                powerSet(order, new boolean[order.length()], length, "", 0);
            }

            for (String key : map.keySet()) {
                if (map.get(key) > 1 && map.get(key) == max && !answer.contains(key)) {
                    System.out.println(key + " " + map.get(key));
                    answer.add(key);
                }
            }
        }

        Collections.sort(answer);

        return answer.toArray(new String[]{});
    }

    private void powerSet(String order, boolean[] visited, int length, String set, int index) {
        if (set.length() == length) {
            for (int i = 0; i < orders.length; i++) {
                if (containOrder(set, orders[i])) {
                    map.put(set, map.getOrDefault(set, 0) + 1);
                }
            }

            max = Math.max(max, map.getOrDefault(set, 0));
            return;
        }

        if (index == visited.length) {
            return;
        }

        visited[index] = false;
        powerSet(order, visited, length, set, index + 1);
        visited[index] = true;
        powerSet(order, visited, length, set + order.charAt(index), index + 1);

    }

    private String sortOrder(String order) {
        String[] array = order.split("");
        Arrays.sort(array);

        return String.join("", array);
    }

    private boolean containOrder(String targetOrder, String order) {
        for (int i = 0; i < targetOrder.length(); i++) {
            if (!order.contains(String.valueOf(targetOrder.charAt(i)))) {
                return false;
            }
        }

        return true;
    }

}
