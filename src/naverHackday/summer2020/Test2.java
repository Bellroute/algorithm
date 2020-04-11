package naverHackday.summer2020;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Test2 {

    public static void main(String[] args) {
        String[] id_list = {"A B C D", "A D", "A B D", "B D"};
        System.out.println(solution(id_list, 2));
    }

    public static int solution(String[] id_list, int k) {
        int answer = 0;

        Map<String, Integer> purchaseLog = new HashMap();

        for (String day : id_list) {
            String[] dayList = day.split(" ");
            dayList = removeDuplicatedId(dayList);

            for (String id : dayList) {
                if (purchaseLog.containsKey(id)) {
                    if (purchaseLog.get(id) < k) {
                        purchaseLog.put(id, purchaseLog.get(id) + 1);
                        answer++;
                    }
                } else {
                    purchaseLog.put(id, 1);
                    answer++;
                }
            }
        }

        return answer;
    }

    private static String[] removeDuplicatedId(String[] dayList) {
        return new HashSet<>(Arrays.asList(dayList)).toArray(new String[0]);
    }
}
