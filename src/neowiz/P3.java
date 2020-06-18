package neowiz;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import static org.junit.Assert.assertEquals;

public class P3 {

    @Test
    public void test() {
        assertEquals(4, solution(new int[]{3,2,1,4,5}));
        assertEquals(2, solution(new int[]{20,10,10,20}));
        assertEquals(7, solution(new int[]{103,101,103,103,101,102,100,100,101,104}));
    }

    public int solution(int[] p) {
        int answer = 0;

        Map<Integer, Integer> hashMap = new HashMap<>();
        Set<Integer> keys = new TreeSet<>();

        for (int i : p) {
            keys.add(i);
            hashMap.put(i, hashMap.getOrDefault(i, 0) + 1);
        }

        while (true) {
            if (hashMap.keySet().size() == 0) {
                break;
            }

            int count = 0;

            for (int key : keys) {
                if (hashMap.containsKey(key)) {
                    count++;

                    if (hashMap.get(key) == 1) {
                        hashMap.remove(key);
                    } else {
                        hashMap.put(key, hashMap.get(key) - 1);
                    }
                }
            }

            answer += count - 1;
        }

        return answer;
    }
}
