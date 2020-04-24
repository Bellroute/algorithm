package programmers.kakao.blindRecruitment2019;

public class FailureRate {

    public static void main(String[] args) {
        int N = 5;
        int[] stages = {2, 1, 2, 6, 2, 4, 3, 3};

        int[] answer = solution(N, stages);

        for (int i = 0; i < answer.length; i++) {
            System.out.println(answer[i]);
        }
    }

    public static int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        double[] counts = new double[N + 1];
        int length = stages.length;

        for (int i = 1; i <= N; i++) {
            int count = 0;

            for (int j = 0; j < stages.length; j++) {
                if (stages[j] == i) {
                    count++;
                }
            }

            if (length > 0) {
                counts[i] = (double) count / (double) length;
                length -= count;
            } else {
                counts[i] = 0;
            }
        }


        boolean[] visited = new boolean[N + 1];

        for (int i = 0; i < N; i++) {
            double max = -1;
            int index = 0;

            for (int j = 1; j <= N; j++) {
                if (visited[j]) continue;

                if (counts[j] > max) {
                    max = counts[j];
                    index = j;
                }
            }

            answer[i] = index;
            visited[index] = true;
        }

        return answer;
    }
}
