package beckjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BaekJoon1715 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            priorityQueue.offer(Integer.parseInt(br.readLine()));
        }

        int answer = 0;

        while (!priorityQueue.isEmpty()) {
            int sum = priorityQueue.poll();

            if (priorityQueue.isEmpty()) {
                break;
            }

            sum += priorityQueue.poll();
            priorityQueue.offer(sum);
            answer += sum;
        }

        System.out.println(answer);
    }
}
