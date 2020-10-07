package beckjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BaekJoon11724 {

    private static int N;
    private static int M;
    private static boolean[] visited;
    private static ArrayList[] connections;
    private static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N + 1];
        connections = new ArrayList[N + 1];

        for (int i = 1; i <= N ; i++) {
            connections[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            connections[start].add(end);
            connections[end].add(start);
        }

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                answer++;
                bfs(i);
            }
        }

        System.out.println(answer);
    }

    private static void bfs(int index) {
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(index);
        visited[index] = true;

        while (!queue.isEmpty()) {
            int now = queue.poll();
            List<Integer> nextIndexes = connections[now];

            for (int i = 0; i < nextIndexes.size(); i++) {
                int next = nextIndexes.get(i);
                if (visited[next]) {
                    continue;
                }

                queue.offer(next);
                visited[next] = true;
            }
        }
    }
}
