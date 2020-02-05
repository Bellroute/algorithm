package beckjoon;

import java.util.Scanner;

public class BaekJoon9663 {
    private static int count;
    private static int N;
    private static int[] positions;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();
        count = 0;

        for (int i = 1; i <= N; i++) {
            positions = new int[16];
            positions[1] = i;
            dfs(1);
        }

        System.out.println(count);
    }

    private static void dfs(int depth) {
        if (depth == N) {
            count++;
        } else {
            for (int i = 1; i <= N; i++) {
                if (isPossible(i, depth + 1)) {
                    positions[depth + 1]  = i;
                    dfs(depth + 1);
                }
            }
        }
    }

    private static boolean isPossible(int number, int depth) {
        for (int i = 1; i < depth; i++) {
            if (positions[i] == number) {
                return false;
            }

            if (Math.abs(positions[i] - number) == Math.abs(i - depth)) {
                return false;
            }
        }

        return true;
    }
}
