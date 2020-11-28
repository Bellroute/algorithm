package nhngodo;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q3 {

    public int solution(String s, int n){
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        List<Integer> values = (List<Integer>) map.values();
        Collections.sort(values);

        return 0;
    }
}
