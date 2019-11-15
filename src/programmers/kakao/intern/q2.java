package programmers.kakao.intern;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class q2 {

    @Test
    public void test() {
        assertEquals(new int[]{2, 1, 3, 4}.length, solution("{{2},{2,1},{2,1,3},{2,1,3,4}}").length);
        assertEquals(4, solution("{{1,2,3},{2,1},{1,2,4,3},{2}}").length);
        assertEquals(2, solution("{{20,111},{111}}").length);
    }

    public int[] solution(String s) {
        List<List> elements = new ArrayList<>();

        s = s.substring(1, s.length() - 2);

        String[] set = s.split("},");

        for (int i = 0; i < set.length; i++) {
            int length = set[i].split(",").length;
            List<Integer> partSet = new ArrayList<>();

            for (int j = 0; j < length; j++) {
                partSet.add(Integer.parseInt(set[i].replace("{", "").split(",")[j]));
            }

            elements.add(partSet);
        }

        for (List element : elements) {
            Collections.sort(element);
        }


        List<Integer> tuple = new ArrayList<>();

        int size = 1;
        while (size <= elements.size()) {
            for (int i = 0; i < elements.size(); i++) {
                List<Integer> partSet = elements.get(i);

                if (elements.get(i).size() == size) {
                    for (int j = 0; j < partSet.size(); j++) {
                        if (!tuple.contains(partSet.get(j))) {
                            tuple.add(partSet.get(j));
                            break;
                        }
                    }

                }
            }

            size++;
        }

        int[] answer = new int[tuple.size()];

        for (int i = 0; i < answer.length; i++) {
            answer[i] = tuple.get(i);
        }

        return answer;
    }
}
