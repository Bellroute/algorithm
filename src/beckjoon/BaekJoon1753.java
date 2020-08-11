package beckjoon;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BaekJoon1753 {
    private static final int INF = 100000000;
    private static ArrayList<Pair>[] list;
    private static int dist[];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int V = scanner.nextInt();
        int E = scanner.nextInt();
        int K = scanner.nextInt();

        list = new ArrayList[V + 1];
        dist = new int[V + 1];

        for (int i = 1; i <= V; i++) {
            dist[i] = INF;
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            list[scanner.nextInt()].add(new Pair(scanner.nextInt(), scanner.nextInt()));
        }

        dijkstra(K);

        for (int i = 1; i <= V; i++) {
            if (dist[i] == INF)
                System.out.println("INF");
            else
                System.out.println(dist[i]);
        }
    }

    private static void dijkstra(int start) {
        PriorityQueue<Pair> priorityQueue = new PriorityQueue<>();

        dist[start] = 0;
        priorityQueue.offer(new Pair(start, dist[start]));

        while (!priorityQueue.isEmpty()) {
            Pair pair = priorityQueue.poll();
            int current = pair.index;
            int distance = pair.distance;

            if (dist[current] < distance) continue;

            for (int i = 0; i < list[current].size(); i++) {
                int next = list[current].get(i).index;
                int nextDistance = distance + list[current].get(i).distance;

                if (nextDistance < dist[next]) {
                    dist[next] = nextDistance;
                    priorityQueue.offer(new Pair(next, nextDistance));
                }
            }
        }
    }

    private static class Pair implements Comparable<Pair> {

        private int index;
        private int distance;

        public Pair(int index, int distance) {
            this.index = index;
            this.distance = distance;
        }

        @Override
        public int compareTo(Pair o) {

            if (o.distance < this.distance) {
                return 1;
            }

            return -1;
        }
    }
}
