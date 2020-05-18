package programmers.heap;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class MoreSpicy {

    public int solution(int[] scoville, int K) {
        int answer = 0;

        Queue<Integer> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(o -> o));

        for (int food : scoville) {
            priorityQueue.offer(food);
        }

        while (priorityQueue.size() >= 2) {
            int min = priorityQueue.poll();

            if (min < K) {
                priorityQueue.offer(min + (priorityQueue.poll() * 2));
                answer++;
            } else {
                break;
            }
        }

        if (priorityQueue.size() == 1 && priorityQueue.poll() < K) {
            return -1;
        }

        return answer;
    }

}
