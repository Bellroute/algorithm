package beckjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BaekJoon13549 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        boolean[] visited = new boolean[100002];

        PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.time));
        queue.offer(new Node(N, 0));

        visited[N] = true;

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            visited[node.point] = true;

            if (node.point == K) {
                System.out.println(node.time);
                break;
            }

            if (node.point - 1 >= 0 && !visited[node.point - 1]) {
                queue.offer(new Node(node.point - 1, node.time + 1));
            }

            if (node.point + 1 <= 100000 && !visited[node.point + 1]) {
                queue.offer(new Node(node.point + 1, node.time + 1));
            }

            if (node.point * 2 <= 100000 && !visited[node.point * 2]) {
                queue.offer(new Node(node.point * 2, node.time));
            }

        }
    }

    static class Node {
        private int point;
        private int time;

        public Node(int point, int time) {
            this.point = point;
            this.time = time;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "point=" + point +
                    ", time=" + time +
                    '}';
        }
    }
}
