package beckjoon;

import java.util.Scanner;

public class BaekJoon2606 {
    private static int[][] networks;
    private static boolean[] isVisited;
    private static int numberOfComputer;
    private static int count = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        numberOfComputer = scanner.nextInt();
        int numberOfPair = scanner.nextInt();

        networks = new int[numberOfComputer + 1][numberOfComputer + 1];
        isVisited = new boolean[numberOfComputer + 1];

        for (int i = 0; i < numberOfPair; i++) {
            int start = scanner.nextInt();
            int end = scanner.nextInt();

            networks[start][end] = 1;
            networks[end][start] = 1;
        }

        dfs(1);

        System.out.println(count);
    }

    private static void dfs(int depth) {
        isVisited[depth] = true;

        for (int i = 1; i <= numberOfComputer; i++) {
            if (networks[depth][i] == 1 && !isVisited[i]) {
                count++;
                dfs(i);
            }
        }
    }
}
