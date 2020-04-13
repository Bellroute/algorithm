package programmers.brouteforce;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MockExam {

    private static int[] supo1 = {1, 2, 3, 4, 5};
    private static int[] supo2 = {2, 1, 2, 3, 2, 4, 2, 5};
    private static int[] supo3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

    public static void main(String[] args) {
        int[] answers = {1, 2, 3, 4, 5};

        int[] answer = solution(answers);

        Arrays.stream(answer).forEach(System.out::println);
    }

    public static int[] solution(int[] answers) {
        int[] counts = new int[3];

        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == supo1[i % supo1.length]) {
                counts[0]++;
            }

            if (answers[i] == supo2[i % supo2.length]) {
                counts[1]++;
            }

            if (answers[i] == supo3[i % supo3.length]) {
                counts[2]++;
            }
        }

        int max = Math.max(Math.max(counts[0], counts[1]), counts[2]);

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < counts.length; i++) {
            if (counts[i] == max) {
                list.add(i + 1);
            }
        }

        int[] answer = new int[list.size()];

        for (int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}
