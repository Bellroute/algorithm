package beckjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BaekJoon13023 {

    private static int N;
    private static int M;
    private static boolean[] visited;
    private static ArrayList<Integer>[] graph;
    private static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N];
        graph = new ArrayList[N];

        for (int i = 0; i < N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b);
            graph[b].add(a);
        }

        for (int i = 0; i < N; i++) {
            dfs(i, 1);

            if (result == 1) {
                break;
            }
        }

        System.out.println(result);
    }

    private static void dfs(int index, int count) {
        if (count == 5 || result == 1) {
            result = 1;
            return;
        }

        visited[index] = true;

        for (int i = 0; i < graph[index].size(); i++) {
            if (!visited[graph[index].get(i)]) {
                visited[graph[index].get(i)] = true;
                dfs(graph[index].get(i), count + 1);
                visited[graph[index].get(i)] = false;
            }
        }

        visited[index] = false;
    }
}
