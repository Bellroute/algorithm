package programmers.monthly_code_challange.oct;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Q3 {

    private int n;
    private int[][] map;
    private int[][] dist;
    private int answer = 0;

    @Test
    public void test() {
        System.out.println(solution(4, new int[][]{{1, 2}, {2, 3}, {3, 4}}));
    }

    public int solution(int n, int[][] edges) {

        this.n = n;

        map = new int[n][n];

        for (int i = 0; i < edges.length; i++) {
            map[edges[i][0] - 1][edges[i][1] - 1] = 1;
            map[edges[i][1] - 1][edges[i][0] - 1] = 1;
        }

        dist = new int[n][n];

        for (int i = 0; i < n; i++) {
            dist[i] = makeDaijkstra(i);
        }

        boolean[] visited = new boolean[n];
        combination(visited, 0, 0);

        return answer;
    }

    private void combination(boolean[] visited, int start, int r) {
        if (r == 3) {
            int[] indexes = new int[3];
            int index = 0;

            for (int i = 0; i < visited.length; i++) {
                if (visited[i]) {
                    indexes[index] = i;
                    index++;
                }

                if (index == 3) {
                    break;
                }
            }

            answer = Math.max(answer, getMedian(indexes));
            return;
        }

        for (int i = start; i < n; i++) {
            visited[i] = true;
            combination(visited, i + 1, r + 1);
            visited[i] = false;
        }
    }

    private int getMedian(int[] indexes) {
        int[] result = new int[3];

        result[0] = dist[indexes[0]][indexes[1]];
        result[1] = dist[indexes[1]][indexes[2]];
        result[2] = dist[indexes[2]][indexes[1]];

        Arrays.sort(result);

        return result[1];
    }

    private int[] makeDaijkstra(int start) {
        int[] distance = new int[n];
        boolean[] visited = new boolean[n];

        distance[start] = 0;
        visited[start] = true;

        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(start, 0));

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            distance[node.index] = node.depth;

            for (int i = 0; i < n; i++) {
                if (map[node.index][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    queue.offer(new Node(i, node.depth + 1));
                }
            }
        }

        return distance;
    }

    class Node {
        private int index;
        private int depth;

        public Node(int index, int depth) {
            this.index = index;
            this.depth = depth;
        }
    }
}
