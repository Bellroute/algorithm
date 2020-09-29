package codlility;

import java.util.Arrays;

public class Q2 {

    public static void main(String[] args) {
        int[] answer = solution(new String[]{"abc", "bca", "dbe"});
        System.out.println(answer[0] + " " + answer[1] + " " + answer[2]);
    }

    public static int[] solution(String[] S) {
        int[] result = new int[3];
        int N = S.length;
        int M = S[0].length();

        for (int i = 0; i < M; i++) {
            int[] alphabets = new int[26];
            Arrays.fill(alphabets, -1);

            for (int j = 0; j < N; j++) {
                char alphabet = S[j].charAt(i);

                if (alphabets[alphabet - 97] != -1) {
                    result[0] = alphabets[alphabet - 97];
                    result[1] = j;
                    result[2] = i;

                    return result;
                }

                alphabets[alphabet - 97] = j;
            }
        }

        return new int[]{};
    }
}
