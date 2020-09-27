package programmers.naver.recurit2020;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q3 {

    private static int[][] map;
    private static Map<Integer, List<Integer>> hashMap = new HashMap<>();
    private static int count;
    private static int answer = 51;

    public static void main(String[] args) {
        System.out.println(solution(19, new int[][]{{0, 1}, {0, 2}, {0, 3}, {1, 4}, {1, 5}, {2, 6}, {3, 7}, {3, 8}, {3, 9}, {4, 10}, {4, 11}, {5, 12}, {5, 13}, {6, 14}, {6, 15}, {6, 16}, {8, 17}, {8, 18}}));
    }

    public static int solution(int n, int[][] edges) {
        map = new int[n][n];

        for (int i = 0; i < edges.length; i++) {
            int parent = edges[i][0];
            int child = edges[i][1];

            map[parent][child] = 1;

            List<Integer> list;
            if (!hashMap.containsKey(parent)) {
                list = new ArrayList<>();
            } else {
                list = hashMap.get(parent);
            }

            list.add(child);
            hashMap.put(parent, list);
        }

        dfs(0);

        return answer;
    }

    private static void dfs(int now) {
        if (!hashMap.containsKey(now)) {
            System.out.println(count);
            answer = Math.min(answer, count);
            return;
        }

        List<Integer> list = hashMap.get(now);

        for (int i = 0; i < list.size(); i++) {
            int child = list.get(i);

            list.remove(i);
            count += list.size() - 1;
            dfs(i);
            count -= list.size() - 1;
            list.add(i, child);
        }
    }


}
