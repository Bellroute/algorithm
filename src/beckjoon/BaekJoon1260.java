package beckjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BaekJoon1260 {
    private static Scanner scanner = new Scanner(System.in);
    private static int[][] map = new int[1002][1002];
    private static int[] dfsChecker = new int[1002];
    private static int[] bfsChecker = new int[1002];
    private static String[] infoOfM = new String[10000];
    private static int N;
    private static StringBuffer dfsResult = new StringBuffer();
    private static StringBuffer bfsResult = new StringBuffer();

    public static void main(String[] args) {
        String input = scanner.nextLine();
        N = Integer.parseInt(input.split(" ")[0]);
        int M = Integer.parseInt(input.split(" ")[1]);
        int V = Integer.parseInt(input.split(" ")[2]);

        for (int i = 0; i < M; i++) {
            infoOfM[i] = scanner.nextLine();
        }

        for (int i = 0; i < M; i++) {
            map[Integer.parseInt(infoOfM[i].split(" ")[0])][Integer.parseInt(infoOfM[i].split(" ")[1])] = 1;
            map[Integer.parseInt(infoOfM[i].split(" ")[1])][Integer.parseInt(infoOfM[i].split(" ")[0])] = 1;
        }

        dfs(V);
        bfs(V);

        System.out.println(dfsResult.toString());
        System.out.println(bfsResult.toString());
    }

    private static void dfs(int number) {
        if (dfsChecker[number] != 0) {
            return;
        }

        dfsResult.append(number).append(" ");
        dfsChecker[number]++;

        for (int i = 1; i <= N; i++) {
            if (map[number][i] == 1) {
                dfs(i);
            }
        }
    }

    private static void bfs(int number) {
        Queue<Integer> queue = new LinkedList<>();
        bfsResult.append(number);

        queue.offer(number);

        while (!queue.isEmpty()) {
            int num = queue.poll();
            bfsChecker[num]++;

            for (int i = 1; i <= N; i++) {
                if (map[num][i] == 1 && bfsChecker[i] == 0) {
                    queue.offer(i);
                    bfsChecker[i]++;
                    bfsResult.append(" ")
                            .append(i);
                }
            }
        }
    }
}
