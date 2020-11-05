package beckjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BaekJoon17780 {

    private static final int WHITE = 0;
    private static final int RED = 1;
    private static final int BLUE = 2;
    private static int[] dir_x = {0, 0, -1, 1};
    private static int[] dir_y = {1, -1, 0, 0};

    private static int N;
    private static int K;
    private static int[][] map;
    private static Deque<Integer>[][] dequeMap;
    private static List<Node> nodes = new ArrayList<>();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        dequeMap = new ArrayDeque[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                dequeMap[i][j] = new ArrayDeque<>();
            }
        }

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            int dir = (Integer.parseInt(st.nextToken()) + 3) % 4;

            nodes.add(new Node(x, y, dir));
            dequeMap[x][y].offer(i);
        }

        int count = 1;

        while (count <= 1000) {

            for (int i = 0; i < K; i++) {
                Node node = nodes.get(i);

                int x = node.x;
                int y = node.y;

                if (dequeMap[x][y].getFirst() != i) {
                    continue;
                }

                int new_x = x + dir_x[node.dir];
                int new_y = y + dir_y[node.dir];

                if (!isInArea(new_x, new_y) || map[new_x][new_y] == BLUE) {
                    int new_dir = (node.dir + 1) % 2;

                    if (node.dir >= 2) {
                        new_dir += 2;
                    }

                    new_x = x + dir_x[new_dir];
                    new_y = y + dir_y[new_dir];

                    if (!isInArea(new_x, new_y) || map[new_x][new_y] == BLUE) {
                        new_x = x;
                        new_y = y;

                    } else if (map[new_x][new_y] == RED) {
                        moveStackInCaseOfRed(x, y, new_x, new_y, i, node);
                    } else {
                        moveStackInCaseOfWhite(x, y, new_x, new_y, i, node);
                    }

                    nodes.set(i, new Node(new_x, new_y, new_dir));

                } else if (map[new_x][new_y] == WHITE) {
                    moveStackInCaseOfWhite(x, y, new_x, new_y, i, node);
                } else if (map[new_x][new_y] == RED) {
                    moveStackInCaseOfRed(x, y, new_x, new_y, i, node);
                }

                if (dequeMap[new_x][new_y].size() >= 4) {
                    System.out.println(count);
                    return;
                }
            }

            count++;
        }

        System.out.println(-1);
    }

    private static void moveStackInCaseOfWhite(int x, int y, int new_x, int new_y, int i, Node node) {
        while (!dequeMap[x][y].isEmpty()) {
            int index = dequeMap[x][y].pollFirst();
            nodes.set(index, new Node(new_x, new_y, nodes.get(index).dir));

            dequeMap[new_x][new_y].offer(index);
        }

        nodes.set(i, new Node(new_x, new_y, node.dir));
    }

    private static void moveStackInCaseOfRed(int x, int y, int new_x, int new_y, int i, Node node) {
        while (!dequeMap[x][y].isEmpty()) {
            int index = dequeMap[x][y].pollLast();
            nodes.set(index, new Node(new_x, new_y, nodes.get(index).dir));

            dequeMap[new_x][new_y].offer(index);
        }

        nodes.set(i, new Node(new_x, new_y, node.dir));
    }

    private static boolean isInArea(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < N;
    }

    static class Node {
        private int x;
        private int y;
        private int dir;

        public Node(int x, int y, int dir) {
            this.x = x;
            this.y = y;
            this.dir = dir;
        }
    }
}
