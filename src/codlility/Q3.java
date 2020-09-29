package codlility;

import java.util.Arrays;

public class Q3 {

    public int solution(int[] A) {
        int N = A.length;
        Arrays.sort(A);

        int count = 0;

        for (int i = 0; i < N; i++) {
            int number = i + 1;

            if (A[i] != number) {
                count += Math.abs(A[i] - number);
            }

            if (count > 1000000000) {
                return -1;
            }
        }

        return count;
    }
}
