package programmers;

import java.util.*;

public class Q3 {

    public int[] solution(int n, int[] passenger, int[][] train) {
        int[] values = new int[n + 1];

        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < train.length; i++) {
            int start = train[i][0];
            int end = train[i][1];

            List<Integer> startList = graph.getOrDefault(start, new ArrayList<>());
            startList.add(end);
            graph.put(start, startList);

            List<Integer> endList = graph.getOrDefault(end, new ArrayList<>());
            startList.add(start);
            graph.put(end, endList);
        }

        List<Integer> list = graph.getOrDefault(1, new ArrayList<>());
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];
        visited[1] = true;

        for (int station : list) {
            values[station] += passenger[0] + passenger[station - 1];
            visited[station] = true;
            queue.offer(station);
        }

        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (int station : graph.getOrDefault(now, new ArrayList<>())) {
                if (visited[station]) {
                    continue;
                }

                values[station] += values[now] + passenger[station - 1];
                visited[station] = true;
                queue.offer(station);
            }
        }

        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((o1, o2) -> {
            if (o1[1] == o2[1]) {
                return o2[0] - o1[0];
            }
            return o2[1] - o1[1];
        });

        for (int i = 1; i < values.length; i++) {
            priorityQueue.offer(new int[] {i, values[i]});
        }

        int[] answer = priorityQueue.poll();
        while (answer[0] == 1) {
            answer = priorityQueue.poll();
        }

        return answer;
    }
}
