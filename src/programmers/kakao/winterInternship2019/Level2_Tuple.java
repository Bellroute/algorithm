package programmers.kakao.winterInternship2019;

import java.util.*;

public class Level2_Tuple {

    public int[] solution(String s) {
        String parsedInput = s.replace("{", "")
                              .replace("}", "")
                              .replace(",", " ");

        String[] numbers = parsedInput.split(" ");

        Map<String, Integer> map = new HashMap<>();

        for (String number : numbers) {
            map.put(number, map.getOrDefault(number, 0) + 1);
        }

        List<CompareObject> list = new ArrayList<>();

        for (String key : map.keySet()) {
            list.add(new CompareObject(key, map.get(key)));
        }

        Collections.sort(list);

        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = Integer.valueOf(list.get(i).key);
        }

        return answer;
    }

    class CompareObject implements Comparable {

        String key;
        int value;

        public CompareObject(String key, int value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public int compareTo(Object o) {
            CompareObject object = (CompareObject) o;

            return object.value - this.value;
        }
    }
}
