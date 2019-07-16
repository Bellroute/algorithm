package beckjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BaekJoon1697 {
    private static Scanner scanner = new Scanner(System.in);
    private static boolean[] visited = new boolean[1000001];
    private static int[] visit = new int[1000001];

    public static void main(String[] args) {
        String input = scanner.nextLine();
        int N = Integer.parseInt(input.split(" ")[0]);
        int K = Integer.parseInt(input.split(" ")[1]);

        bfs(N, K);
    }

    private static void bfs(int number, int goal) {
        Queue<Integer> queue = new LinkedList<>();
        visit[number] = 1;
        queue.add(number);

        while (!queue.isEmpty()) {
            int num = queue.poll();

            if (num == goal) {
                break;
            }

            if (num - 1 >= 0 && !visited[num - 1]) {
                visit[num - 1] = visit[num] + 1;
                visited[num - 1] = true;
                queue.add(num - 1);
            }

            if (num + 1 <= 1000000 && !visited[num + 1]) {
                visit[num + 1] = visit[num] + 1;
                visited[num + 1] = true;
                queue.add(num + 1);
            }

            if (num * 2 <= 1000000 && !visited[num * 2]) {
                visit[num * 2] = visit[num] + 1;
                visited[num * 2] = true;
                queue.add(num * 2);
            }
        }

        System.out.println(visit[goal] - 1);
    }
}

