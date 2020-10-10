package coupang;

import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Q4 {

    private Map<String, List<String>> map;
    private int deparToHub = 0;
    private int hubToDest = 0;

    @Test
    public void test() {
        System.out.println(solution("SEOUL", "DAEGU", "YEOSU", new String[][]{{"ULSAN", "BUSAN"}, {"DAEJEON", "ULSAN"}, {"DAEJEON", "GWANGJU"}, {"SEOUL", "DAEJEON"}, {"SEOUL", "ULSAN"}, {"DAEJEON", "DAEGU"}, {"GWANGJU", "BUSAN"}, {"DAEGU", "GWANGJU"}, {"DAEGU", "BUSAN"}, {"ULSAN", "DAEGU"}, {"GWANGJU", "YEOSU"}, {"BUSAN", "YEOSU"}}));
    }

    public int solution(String depar, String hub, String dest, String[][] roads) {
        map = new HashMap<>();

        for (String[] road : roads) {
            String start = road[0];
            String end = road[1];

            List<String> list;

            if (map.containsKey(start)) {
                list = map.get(start);
            } else {
                list = new LinkedList<>();
            }

            list.add(end);
            map.put(start, list);
        }

        getNumberOfRoute(0, depar, hub);
        getNumberOfRoute(1, hub, dest);

        return (deparToHub * hubToDest) % 10007;
    }

    private void getNumberOfRoute(int part, String depar, String end) {
        List<String> route = map.get(depar);

        if (depar.equals(end)) {
            if (part == 0) {
                deparToHub++;
                return;
            }

            hubToDest++;
            return;
        }

        if (route == null) {
            return;
        }

        for (String start : route) {
            getNumberOfRoute(part, start, end);
        }
    }
}
