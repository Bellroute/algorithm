package programmers.kakao.summerinternship2020;

import java.util.*;
import java.util.stream.Collectors;

public class P3 {
    public int[] solution(String[] gems) {
        Set<String> allGems = Arrays.stream(gems)
                                    .collect(Collectors.toSet());
        int index = 1;
        int finalDistance = Integer.MAX_VALUE;
        int[] result = new int[2];

        while (isIndexSizeHalfOfList(gems, allGems, index)) {
            Map<Integer, String> map = convertDisplaysToIndexedMap(gems, index);
            Set<String> existGems = new HashSet<>();
            map = filterDuplicateGems(map, existGems);

            if (!existAllGems(allGems, existGems)) {
                return result;
            }
            // 진열장 거리 계산
            List<Integer> displayNumbers = new ArrayList<>(map.keySet());
            Integer lastIndex = displayNumbers.get(displayNumbers.size() - 1);
            int thisLoopDistance = lastIndex - index;
            // 이전 기록들과 비교하고 결과값 세팅
            if (finalDistance > thisLoopDistance) {
                finalDistance = thisLoopDistance;
                result[0] = index;
                result[1] = lastIndex;
            }
            index++;
        }
        return result;
    }

    private boolean existAllGems(Set<String> allGems, Set<String> existGems) {
        if (existGems.containsAll(allGems)) {
            return true;
        }
        return false;
    }

    private Map<Integer, String> filterDuplicateGems(Map<Integer, String> map, Set<String> existGems) {
        map = map.entrySet()
                 .stream()
                 .filter(e -> existGems.add(e.getValue()))
                 .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        return map;
    }

    private Map<Integer, String> convertDisplaysToIndexedMap(String[] data, int index) {
        Map<Integer, String> map = new HashMap<>();
        for (int i = index - 1; i < data.length; i++) {
            map.put(i + 1, data[i]);
        }
        return map;
    }

    private boolean isIndexSizeHalfOfList(String[] data, Set<String> allGems, int index) {
        return index <= data.length - allGems.size() + 1;
    }
}
