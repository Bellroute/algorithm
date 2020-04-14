package programmers.hash;

import java.util.HashMap;
import java.util.Map;

public class Camouflage {

    public int solution(String[][] clothes) {
        int answer = 1;
        Map<String, Integer> hashMap = new HashMap<>();

        for (String[] cloth : clothes) {
            hashMap.put(cloth[1], hashMap.getOrDefault(cloth[1], 0) + 1);
        }

        for (int value : hashMap.values()) {
            // 옷 가지수 + 안입는 경우
            answer *= (value + 1);
        }

        // 옷을 하나도 안입는 경우는 없으니까 빼줌
        answer--;

        return answer;
    }

//    public int solution(String[][] clothes) {
//        Map<String, Integer> hashMap = new HashMap<>();
//
//        for (String[] cloth : clothes) {
//            hashMap.put(cloth[1], hashMap.getOrDefault(cloth[1], 0) + 1);
//        }
//
//        for (int i = 1; i <= hashMap.size(); i++) {
//            if (i == 1) {
//                answer += clothes.length;
//                continue;
//            }
//
//            boolean[] visited = new boolean[hashMap.size()];
//            combination(hashMap.values().toArray(new Integer[0]), visited, i, 0, 0);
//        }
//
//        return answer;
//    }
//
//    private void combination(Integer[] arr, boolean[] visited, int count, int now, int index) {
//        if (count == now) {
//            int result = 1;
//
//            for (int i = 0; i < visited.length; i++) {
//                if (visited[i]) {
//                    result *= arr[i];
//                }
//            }
//
//            answer += result;
//        }
//
//        for (int i = index; i < visited.length; i++) {
//            if (!visited[i]) {
//                visited[i] = true;
//                combination(arr, visited, count, now + 1, i + 1);
//                visited[i] = false;
//            }
//        }
//    }
}
