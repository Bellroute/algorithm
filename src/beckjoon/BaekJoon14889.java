package beckjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon14889 {
    private static int N;
    private static int min = 100;
    private static int[][] stats;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); //선언
        String s = bf.readLine();

        N = Integer.parseInt(s);
        stats = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            String[] input = bf.readLine().split(" ");

            for (int j = 0; j < N; j++) {
                stats[i][j + 1] = Integer.parseInt(input[j]);
            }
        }

        for (int i = 1; i <= N; i++) {
            int[] team = new int[N / 2];
            team[0] = i;
            backtracking(1, team, i);
        }

        System.out.println(min);
    }

    private static void backtracking(int n, int[] team, int depth) {
        if (n == N / 2) {
            int[] otherTeam = setOtherTime(team);

            int total = calculateStats(team);
            int otherTotal = calculateStats(otherTeam);

            int result = Math.abs(total - otherTotal);

            if (result < min) {
                min = result;
            }

        } else {
            depth++;

            for (int i = depth; i <= N; i++) {
                team[n] = i;
                backtracking(n + 1, team, i);
            }
        }
    }

    private static int[] setOtherTime(int[] team) {
        int[] otherTime = new int[team.length];

        int index = 0;

        for (int j = 1; j <= N; j++) {
            boolean isContain = false;

             for (int i = 0; i < team.length; i++) {
               if (j == team[i]) {
                   isContain = true;
               }
            }

            if (!isContain) {
                otherTime[index++] = j;
            }
        }

        return otherTime;
    }

    private static int calculateStats(int[] team) {
        int sum = 0;
        for (int i = 0; i < team.length; i++) {
            for (int j = 0; j < team.length; j++) {
                if (i != j) {
                    sum += stats[team[i]][team[j]];
                }
            }
        }

        return sum;
    }
}
