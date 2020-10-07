package beckjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BaekJoon1707 {

    private static int V;
    private static int E;
    private static ArrayList[] map;
    private static int[] status;
    private static boolean flag;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int tries = Integer.parseInt(br.readLine());

        while (tries-- > 0) {
            flag = false;
            StringTokenizer st = new StringTokenizer(br.readLine());

            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());

            map = new ArrayList[V + 1];
            status = new int[V + 1];

            for (int i = 1; i <= V; i++) {
                map[i] = new ArrayList<Integer>();
            }

            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());

                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());

                map[start].add(end);
                map[end].add(start);
            }

            for (int i = 1; i <= V; i++) {
                if (status[i] == 0) {
                    dfs(i);
                }
            }

            if (flag) {
                sb.append("NO")
                  .append("\n");

            } else {
                sb.append("YES")
                  .append("\n");
            }
        }

        System.out.println(sb.toString());
    }

    private static void dfs(int index) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(index);
        status[index] = 1;

        while (!queue.isEmpty()) {
            int now = queue.poll();
            List<Integer> nextIndexes = map[now];
            int group = (status[now] % 2) + 1;

            for (int next : nextIndexes) {
                if (status[next] == status[now]) {
                    flag = true;
                    return;
                }

                if (status[next] == 0) {
                    queue.offer(next);
                    status[next] = group;
                }
            }
        }
    }
}
