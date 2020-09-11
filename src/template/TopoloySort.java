package template;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TopoloySort {

    private int n;

    public void topologicalSort(int[] indegree, List<List<Integer>> array) {
        Queue<Integer> q = new LinkedList<>();
        Queue<Integer> result = new LinkedList<>();

        // 큐에 indegree 가 0 인 노드 담기
        for (int i = 1; i < n + 1; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        /**
         * 1. 큐에서 값을 꺼내며 해당 노드가 가리키는 노드의 indegree 를 1 감소
         * 2. 만약 indegree가 0 이 된다면 큐에 넣기
         * 3. 큐가 빌때까지 반복
         */

        while (!q.isEmpty()) {
            int node = q.poll();
            result.offer(node);

            for (Integer i : array.get(node)) {
                indegree[i]--;

                if (indegree[i] == 0) {
                    q.offer(i);
                }
            }
        }

        System.out.println(result);
    }

    // [출처] https://bcp0109.tistory.com/21
}
