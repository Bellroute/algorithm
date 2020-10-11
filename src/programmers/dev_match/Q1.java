package programmers.dev_match;

import org.junit.Test;

import java.util.*;

public class Q1 {

    @Test
    public void test() {
        System.out.println(solution(new String[] {"AVANT", "PRIDO", "SONATE", "RAIN", "MONSTER", "GRAND", "SONATE", "AVANT", "SONATE", "RAIN", "MONSTER", "GRAND", "SONATE", "SOULFUL", "AVANT", "SANTA"}, 2));
    }

    public String solution(String[] votes, int k) {
        String answer = "";

        Map<String, Integer> map = new HashMap<>();

        for (String vote : votes) {
            map.put(vote, map.getOrDefault(vote, 0) + 1);
        }

        for (String key : map.keySet()) {
            System.out.println(key + " " + map.get(key));
        }

        int topTotalScore = 0;
        int failTotalScore = 0;

        List<String> list = new ArrayList<>(map.keySet());
        Collections.sort(list, (o1, o2) -> {
            if (map.get(o1).equals(map.get(o2))) {
                return o1.compareTo(o2);
            }

            return map.get(o2) - map.get(o1);
        });

        System.out.println();
        for (String key : list) {
            System.out.println(key + " " + map.get(key));
        }

        for (int i = 0; i < k; i++) {
            topTotalScore += map.get(list.get(i));
        }

        Collections.reverse(list);
        System.out.println();
        for (String key : list) {
            System.out.println(key + " " + map.get(key));
        }

        for (int i = 0; i < list.size(); i++) {
            System.out.println("top " + topTotalScore);
            System.out.println("fail " + failTotalScore);

            if (topTotalScore <= failTotalScore + map.get(list.get(i))) {
                break;
            }

            answer = list.get(i);
            System.out.println(answer);
            failTotalScore += map.get(answer);
        }

        return answer;
    }
}
