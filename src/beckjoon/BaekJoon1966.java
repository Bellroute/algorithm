package beckjoon;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class BaekJoon1966 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int trial = scanner.nextInt();
        int[] results = new int[trial];
        scanner.nextLine();

        for (int i = 0; i < trial; i++) {
            String input = scanner.nextLine();
            int N = Integer.parseInt(input.split(" ")[0]);
            int target = Integer.parseInt(input.split(" ")[1]);
            int count = 0;

            input = scanner.nextLine();

            LinkedList<Integer> queue = new LinkedList<>();
            LinkedList<Integer> sortedQueue = new LinkedList<>();
            int[] sortedNumbers = new int[N];

            for (int j = 0; j < N; j++) {
                queue.offer(Integer.parseInt(input.split(" ")[j]));
                sortedNumbers[j] = Integer.parseInt(input.split(" ")[j]);
            }

            Arrays.sort(sortedNumbers);

            for (int j = 0; j < N; j++) {
                sortedQueue.offer(sortedNumbers[N - j - 1]);
            }

            while (!sortedQueue.isEmpty()) {
                int importance = sortedQueue.poll();

                while (queue.peekFirst() != importance) {
                    int document = queue.poll();
                    queue.offer(document);

                    if (--target < 0) {
                        target = queue.size() - 1;
                    }
                }

                queue.poll();
                count++;

                if (--target < 0) {
                    results[i] = count;
                    break;
                }
            }
        }

        for (int i = 0; i < trial; i++) {
            System.out.println(results[i]);
        }
    }
}
