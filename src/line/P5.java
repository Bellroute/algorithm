package line;

import java.util.*;

public class P5 {

    public static void main(String[] args) {
        List<String> l1 = Arrays.asList(new String[]{"doc1", "t1", "t2", "t3"});
        List<String> l2 = Arrays.asList(new String[]{"doc2", "t0", "t2", "t3"});
        List<String> l3 = Arrays.asList(new String[]{"doc3", "t1", "t6", "t7"});
        List<String> l4 = Arrays.asList(new String[]{"doc4", "t1", "t2", "t4"});
        List<String> l5 = Arrays.asList(new String[]{"doc5", "t6", "t100", "t8"});
        List<String>[] dataSource = new List[]{l1, l2, l3, l4, l5};

        String[] tags = {"t1", "t2", "t3"};

        String[] answer = solution(dataSource, tags);

        for (int i = 0; i < answer.length; i++) {
            System.out.println(answer[i]);
        }
    }

    public static String[] solution(List<String>[] dataSource, String[] tags) {
        Map<String, List<String>> tagHashMap = new HashMap<>();

        for (List<String> data : dataSource) {
            for (int i = 1; i < data.size(); i++) {
                if (tagHashMap.get(data.get(i)) == null) {
                    List<String> documents = new ArrayList<>();
                    documents.add(data.get(0));
                    tagHashMap.put(data.get(i), documents);
                } else {
                    List<String> documents = tagHashMap.get(data.get(i));
                    documents.add(data.get(0));
                    tagHashMap.put(data.get(i), documents);
                }
            }
        }

        Map<String, Integer> documentHashMap = new HashMap<>();
        for (String tag : tags) {
            List<String> documents = tagHashMap.get(tag);

            for (String document : documents) {
                documentHashMap.put(document, documentHashMap.getOrDefault(document, 0) + 1);
            }
        }

        List<String> keys = sortByValue(documentHashMap);

        String[] answer;

        if (keys.size() > 10) {
            answer = new String[10];
        } else {
            answer = new String[keys.size()];
        }

        for (int i = 0; i < answer.length; i++) {
            answer[i] = keys.get(i);
        }

        return answer;
    }

    private static List<String> sortByValue(Map<String, Integer> map) {
        List<String> list = new ArrayList<>();
        list.addAll(map.keySet());

        list.sort((o1, o2) -> {
            int v1 = map.get(o1);
            int v2 = map.get(o2);

            if (((Comparable<Integer>) v2).compareTo(v1) == 0) {
                return o1.compareTo(o2);
            } else {
                return ((Comparable<Integer>) v2).compareTo(v1);
            }
        });

        return list;
    }
}
