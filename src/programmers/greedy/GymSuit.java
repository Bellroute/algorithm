package programmers.greedy;

import java.util.Arrays;

public class GymSuit {

    public static void main(String[] args) {
        int n = 5;
        int[] lost = {2, 4};
        int[] reserve = {1, 3, 5};

        System.out.println(solution(n, lost, reserve));
    }

    public static int solution(int n, int[] lost, int[] reserve) {
        int[] students = new int[n + 1];

        for (int i = 0; i < lost.length; i++) {
            students[lost[i]] = -1;
        }

        for (int i = 0; i < reserve.length; i++) {
            students[reserve[i]] += 1;
        }

        for (int i = 1; i <= n; i++) {
            if (students[i] == -1) {
                if (i > 1  && students[i - 1] == 1) {
                    students[i - 1] -= 1;
                    students[i] += 1;
                    continue;
                }

                if (i < n && students[i + 1] == 1) {
                    students[i + 1] -= 1;
                    students[i] += 1;
                }
            }
        }

        return (int) Arrays.stream(students).filter(student -> student >= 0).count() - 1;
    }
}
