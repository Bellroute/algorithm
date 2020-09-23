package beckjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BaekJoon1826 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Station> stations = new PriorityQueue<>(Comparator.comparingInt(o -> o.dist));
        int sum = 0;

        for (int i = 1; i < N + 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int dist = Integer.parseInt(st.nextToken());
            int fuel = Integer.parseInt(st.nextToken());
            stations.offer(new Station(dist, fuel));

            sum += fuel;
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int L = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        if (sum + P < L) {
            System.out.println(-1);
            return;
        }

        int currentDist = 0;
        int reachableDist = P;
        int currentFuel = P;

        int answer = 0;

        PriorityQueue<Station> reachableStations = new PriorityQueue<>((o1, o2) -> o2.fuel - o1.fuel);

        while (reachableDist < L) {

            while (!stations.isEmpty() && stations.peek().dist <= reachableDist) {
                reachableStations.offer(stations.poll());
            }

            if (reachableStations.isEmpty()) {
                answer = - 1;
                break;
            }

            Station nextStation = reachableStations.poll();
            answer++;

            if (currentDist > nextStation.dist) {
                reachableDist += nextStation.fuel;
                currentFuel += nextStation.fuel;
            } else {
                int usedFuel = nextStation.dist - currentDist;
                currentDist = nextStation.dist;
                currentFuel = currentFuel + nextStation.fuel - usedFuel;
                reachableDist = currentDist + currentFuel;
            }
        }

        System.out.println(answer);
    }

    static class Station {
        private int dist;
        private int fuel;

        public Station(int dist, int fuel) {
            this.dist = dist;
            this.fuel = fuel;
        }
    }
}
