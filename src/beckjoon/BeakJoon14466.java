package beckjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BeakJoon14466 {

    private static int N;
    private static int[] x_move = {1, 0, -1, 0};
    private static int[] y_move = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        int[][] map = new int[N + 1][N +1];

        ArrayList<Node>[][] bridges = new ArrayList[N + 1][N + 1];

        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < N + 1; j++) {
                bridges[i][j] = new ArrayList<>();
            }
        }

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());

            int r1 = Integer.parseInt(st.nextToken());
            int c1 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());
            int c2 = Integer.parseInt(st.nextToken());

            bridges[r1][c1].add(new Node(r2, c2));
            bridges[r2][c2].add(new Node(r1, c1));
        }

        List<Node> cows = new ArrayList<>();
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            cows.add(new Node(x, y));
            map[x][y] = 1;
        }

        int answer = 0;

        for (int t = 0; t < K; t++) {
            Node cow = cows.get(t);

            int count = 0;

            boolean[][] visited = new boolean[N + 1][N + 1];
            boolean[][] cowContacted = new boolean[K][K];
            Queue<Node> queue = new LinkedList<>();

            queue.offer(cow);
            visited[cow.x][cow.y] = true;

            while (!queue.isEmpty()) {
                Node node = queue.poll();

                if (map[node.x][node.y] == 1) {
                    for (int j = t + 1; j < K; j++) {
                        Node nextCow = cows.get(j);

                        if (nextCow.x == node.x && nextCow.y == node.y) {
                            cowContacted[t][j] = true;
                            break;
                        }
                    }
                }

                for (int i = 0; i < 4; i++) {
                    int new_x = node.x + x_move[i];
                    int new_y = node.y + y_move[i];

                    if (!isInArea(new_x, new_y) || visited[new_x][new_y]) {
                        continue;
                    }

                    if (bridges[node.x][node.y].contains(new Node(new_x, new_y))) {
                        continue;
                    }

                    visited[new_x][new_y] = true;
                    queue.offer(new Node(new_x, new_y));
                }
            }

            for (int i = t + 1; i < K; i++) {
                if (!cowContacted[t][i]) {
                    answer++;
                }
            }
        }

        System.out.println(answer);
    }

    private static boolean isInArea(int x, int y) {
        return x > 0 && y > 0 && x <= N && y <= N;
    }

    static class Node {
        private int x;
        private int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object obj) {
            Node node = (Node) obj;

            return this.x == node.x && this.y == node.y;
        }
    }
}
