package programmers.kakao.blindRecruitment2019;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Level1_FailureRate {

    public static void main(String[] args) {
        int[] a = solution(5, new int[]{2, 1, 2, 6, 2, 4, 3, 3});
        int[] b = solution(4, new int[]{4, 4, 4, 4, 4});

        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]);
        }

        System.out.println();

        for (int i = 0; i < b.length; i++) {
            System.out.print(b[i]);
        }
    }

    public static class Stage implements Comparable<Stage> {
        private int step;
        private float failureRate;

        public Stage(int step, float failureRate) {
            this.step = step;
            this.failureRate = failureRate;
        }

        @Override
        public int compareTo(Stage o) {
            if (this.failureRate < o.failureRate) {
                return 1;
            } else if (this.failureRate > o.failureRate) {
                return -1;
            } else {
                return 0;
            }
        }
    }

    public static int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        float[] rates = new float[N];


        for (int i = 1; i <= N; i++) {
            int reachedPlayers = 0;
            int failedPlayers = 0;

            for (int j = 0; j < stages.length; j++) {
                if (stages[j] >= i) {
                    reachedPlayers++;
                }

                if (stages[j] == i) {
                    failedPlayers++;
                }
            }

            if (reachedPlayers == 0) {
                rates[i - 1] = 0;
            } else {
                float failureRate = (float) failedPlayers / (float) reachedPlayers;
                rates[i - 1] = failureRate;
            }
        }

        List<Stage> stageList = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            stageList.add(new Stage(i + 1, rates[i]));
        }

        Collections.sort(stageList);

        for (int i = 0; i < N; i++) {
            answer[i] = stageList.get(i).step;
        }

        return answer;
    }
}
