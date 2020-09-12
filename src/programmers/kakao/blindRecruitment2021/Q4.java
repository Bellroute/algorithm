package programmers.kakao.blindRecruitment2021;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class Q4 {

    private int n;
    private int[][] map;

    @Test
    public void test() {
        assertEquals(82,
                solution(6, 4, 6, 2,
                        new int[][]{{4, 1, 10}, {3, 5, 24}, {5, 6, 2}, {3, 1, 41}, {5, 1, 24}, {4, 6, 50}, {2, 4, 66}, {2, 3, 22}, {1, 6, 25}}));

        assertEquals(14,
                solution(7, 3, 4, 1,
                        new int[][]{{5, 7, 9}, {4, 6, 4}, {3, 6, 1}, {3, 2, 3}, {2, 1, 6}}));

        assertEquals(18,
                solution(6, 4, 5, 6,
                        new int[][]{{2, 6, 6}, {6, 3, 7}, {4, 6, 7}, {6, 5, 11}, {2, 5, 12}, {5, 3, 20}, {2, 4, 8}, {4, 3, 9}}));
    }

    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = Integer.MAX_VALUE;
        this.n = n;
        map = new int[n][n];

        for (int i = 0; i < fares.length; i++) {
            int pin1 = fares[i][0] - 1;
            int pin2 = fares[i][1] - 1;
            int value = fares[i][2];

            map[pin1][pin2] = value;
            map[pin2][pin1] = value;
        }

        int[] s_dijkstra = makeDaijkstra(s - 1);
        int[] a_dijkstra = makeDaijkstra(a - 1);
        int[] b_dijkstra = makeDaijkstra(b - 1);

        for (int i = 0; i < n; i++) {
            answer = Math.min(answer, s_dijkstra[i] + a_dijkstra[i] + b_dijkstra[i]);
        }

        return answer;
    }

    private int[] makeDaijkstra(int start) {
        int[] distance = new int[n];
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            distance[i] = Integer.MAX_VALUE;
        }

        distance[start] = 0;
        visited[start] = true;

        for (int i = 0; i < n; i++) {
            if (!visited[i] && map[start][i] != 0) {
                distance[i] = map[start][i];
            }
        }

        for (int i = 0; i < n - 1; i++) {
            int min = Integer.MAX_VALUE;
            int minIndex = 0;

            for (int j = 0; j < n; j++) {
                if (!visited[j] && distance[j] != Integer.MAX_VALUE) {
                    if (min > distance[j]) {
                        minIndex = j;
                        min = distance[j];
                    }
                }
            }

            visited[minIndex] = true;

            for (int j = 0; j < n; j++) {
                if (!visited[j] && map[minIndex][j] != 0) {
                    distance[j] = Math.min(distance[j], distance[minIndex] + map[minIndex][j]);
                }
            }
        }

        Arrays.stream(distance).forEach(System.out::println);
        System.out.println();

        return distance;
    }
}
