package programmers.kakao.blindRecruitment2019;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class Level2_Compression {

    private List<String> dictionary;

    @Test
    public void test() {
        assertEquals(new int[]{11, 1, 27, 15}.length, solution("KAKAO").length);
        assertEquals(new int[]{20, 15, 2, 5, 15, 18, 14, 15, 20, 27, 29, 31, 36, 30, 32, 34}.length, solution("TOBEORNOTTOBEORTOBEORNOT").length);
        assertEquals(new int[]{1, 2, 27, 29, 28, 31, 30}.length, solution("ABABABABABABABAB").length);
    }

    public int[] solution(String msg) {
        Map<String, Integer> dictionary = initDictionary();
        List<Integer> result = new ArrayList<>();

        int index = 0;

        StringBuilder stringBuilder = new StringBuilder();
        while (index < msg.length()) {
            int i;
            boolean flag = false;
            String character = "";

            for (i = index; i < msg.length(); i++) {
                stringBuilder.append(msg.charAt(i));
                character = stringBuilder.toString();

                if (!dictionary.containsKey(character)) {
                    flag = true;
                    result.add(dictionary.get(character.substring(0, character.length() - 1)));
                    dictionary.put(character, dictionary.keySet().size() + 1);
                    break;
                }
            }

            index = i;

            if (!flag) {
                result.add(dictionary.get(character));
            }

            stringBuilder = new StringBuilder();
        }

        return result.stream().mapToInt(i -> i).toArray();
    }

    private Map<String, Integer> initDictionary() {
        Map<String, Integer> map = new HashMap<>();
        char start = 'A';
        int index = 1;

        for (int i = 0; i < 26; i++) {
            map.put(Character.toString((char) (start + i)), index++);
        }

        return map;
    }
}
