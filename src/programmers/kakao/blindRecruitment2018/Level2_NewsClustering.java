package programmers.kakao.blindRecruitment2018;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class Level2_NewsClustering {

    @Test
    public void test() {
        assertEquals(16384, solution("FRANCE", "french"));
        assertEquals(65536, solution("handshake", "shake hands"));
        assertEquals(43690, solution("aa1+aa2", "AAAA12"));
        assertEquals(65536, solution("E=M*C^2", "e=m*c^2"));
    }

    public int solution(String str1, String str2) {
        List<String> str1Set = separateSet(str1);
        List<String> str2Set = separateSet(str2);

        double similarity;

        if (str1Set.size() == 0 && str2Set.size() == 0) {
            similarity = 1;
        } else {
            List<String> intersection = getIntersection(str1Set, str2Set);
            List<String> union = getUnion(str1Set, str2Set);

            similarity = (double) intersection.size() / (double) union.size();
        }

        return (int) Math.floor(similarity * 65536);
    }


    private boolean isAlphabet(char character) {
        return (character >= 65 && character <= 90) || (character >= 97 && character <= 122);
    }

    private List<String> getIntersection(List<String> str1Set, List<String> str2Set) {
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < str1Set.size(); i++) {
            map.put(str1Set.get(i), map.getOrDefault(str1Set.get(i), 0) + 1);
        }

        List<String> result = new ArrayList<>();

        for (String key : map.keySet()) {
            int count = 0;

            for (int i = 0; i < str2Set.size(); i++) {
                if (str2Set.get(i).equals(key)) {
                    count++;
                }
            }

            if (count > 0) {
                count = Math.min(count, map.get(key));

                for (int i = 0; i < count; i++) {
                    result.add(key);
                }
            }
        }

        return result;
    }

    private List<String> getUnion(List<String> str1Set, List<String> str2Set) {
        Map<String, Integer> str1Map = new HashMap<>();

        for (int i = 0; i < str1Set.size(); i++) {
            str1Map.put(str1Set.get(i), str1Map.getOrDefault(str1Set.get(i), 0) + 1);
        }

        Map<String, Integer> str2Map = new HashMap<>();

        for (int i = 0; i < str2Set.size(); i++) {
            str2Map.put(str2Set.get(i), str2Map.getOrDefault(str2Set.get(i), 0) + 1);
        }

        List<String> result = new ArrayList<>();

        for (String key : str1Map.keySet()) {
            int count;

            if (str2Map.keySet().contains(key)) {
                count = Math.max(str1Map.get(key), str2Map.get(key));
            } else {
                count = str1Map.get(key);
            }

            for (int i = 0; i < count; i++) {
                result.add(key);
            }
        }

        for (String key : str2Map.keySet()) {
            if (!str1Map.keySet().contains(key)) {
                int count = str2Map.get(key);

                for (int i = 0; i < count; i++) {
                    result.add(key);
                }
            }
        }

        return result;
    }

    private List<String> separateSet(String input) {
        List<String> list = new ArrayList<>();

        for (int i = 0; i < input.length() - 1; i++) {
            if (isAlphabet(input.charAt(i)) && isAlphabet(input.charAt(i + 1))) {
                list.add(input.substring(i, i + 2).toUpperCase());
            }
        }

        return list;
    }
}
