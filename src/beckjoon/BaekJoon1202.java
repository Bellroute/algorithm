package beckjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BaekJoon1202 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Jewelry[] jewelries = new Jewelry[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            jewelries[i] = new Jewelry(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        int[] bags = new int[K];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            bags[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(bags);
        Arrays.sort(jewelries);


        PriorityQueue<Jewelry> priorityQueue = new PriorityQueue<>((o1, o2) -> o2.value - o1.value);
        long answer = 0;
        int index = 0;

        for (int i = 0; i < bags.length; i++) {
            while (index < N && jewelries[index].weight <= bags[i]) {
                priorityQueue.offer(jewelries[index]);
                index++;
            }

            if (!priorityQueue.isEmpty()) {
                answer += priorityQueue.poll().value;
            }
        }

        System.out.println(answer);
    }

    static class Jewelry implements Comparable<Jewelry>{
        private int weight;
        private int value;

        public Jewelry(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }

        @Override
        public int compareTo(Jewelry o) {
            return this.weight - o.weight;
        }
    }
}
