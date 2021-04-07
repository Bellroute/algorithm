package programmers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Q2 {

    private int max = 0;
    private int partSize;
    private Map<String, Integer> countTable;

    public int solution(int[][] needs, int r) {
        int itemSize = needs.length;
        partSize = needs[0].length;

        countTable = new HashMap<>();
        for (int i = 0; i < itemSize; i++) {
            StringBuilder stringBuilder = new StringBuilder();

            for (int j = 0; j < needs[i].length; j++) {
                stringBuilder.append(needs[i][j]);
            }

            String key = stringBuilder.toString();
            countTable.put(key, countTable.getOrDefault(key, 0) + 1);
        }

        int[] arr = new int[partSize];
        boolean[] visited = new boolean[partSize];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }

        combination(arr, visited, 0, partSize, r);

        return max;
    }

    private void combination(int[] arr, boolean[] visited, int start, int partSize, int r) {
        if (r == 0) {
            int count = getCount(arr, visited);
            max = Integer.max(max, count);
            return;
        }

        for (int i = start; i < partSize; i++) {
            visited[i] = true;
            combination(arr, visited, i + 1, partSize, r - 1);
            visited[i] = false;
        }
    }

    private int getCount(int[] arr, boolean[] visited) {
        int count = 0;
        int[] keyArr = new int[partSize];
        for (int i = 0; i < arr.length; i++) {
            if (visited[i]) {
                keyArr[arr[i]] = 1;
            }
        }

        int combKey = Integer.parseInt(Arrays.toString(keyArr).replaceAll("[^0-9]",""), 2);
        for (String key : countTable.keySet()) {
            int result = Integer.parseInt(key, 2) & combKey;

            if (result == Integer.parseInt(key, 2)) {
                count += countTable.get(key);
            }
        }

        return count;
    }
}
