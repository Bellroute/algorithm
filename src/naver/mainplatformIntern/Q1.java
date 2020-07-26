package naver.mainplatformIntern;

public class Q1 {

    private static boolean[] visited;

    public static void main(String[] args) {
        System.out.println(solution(new int[]{-1, 1, 3, 3, 3, 2, 3, 2, 1, 0}));
        System.out.println(solution(new int[]{0, 0, 0, 0, 0, 0, 0}));
    }

//    public static int solution(int[] A) {
//        int answer = 0;
//        visited = new boolean[A.length];
//
//        for (int i = 0; i < A.length - 2; i++) {
//            int count = 2;
//
//            if (visited[i]) {
//                continue;
//            }
//
//            visited[i] = true;
//            visited[i + 1] = true;
//
//            System.out.print(i + ": " + A[i] + " " + (i + 1) + ": " + A[i + 1] + " ");
//            for (int j = i + 2; j < A.length; j++) {
//                if (A[i] - A[i + 1] == A[j - 1] - A[j]) {
//                    System.out.print(j + ": " + A[j] + " ");
//                    visited[j - 1] = true;
//                    count++;
//                } else {
//                    break;
//                }
//            }
//            System.out.println();
//
//            if (count >= 3) {
//                answer += dp(count);
//            }
//        }
//
//        return answer;
//    }
//
//    public static int dp(int number) {
//        if (number <= 2) {
//            return 0;
//        }
//
//        if (number == 3) {
//            return 1;
//        }
//
//        return dp(number - 1) * 2 + 1 - dp(number - 2);
//    }

    public static int solution(int[] A) {
        int count = 0;

        for (int i = 0; i < A.length - 2; i++) {
            System.out.print(i + ": " + A[i] + " " + (i + 1) + ": " + A[i + 1] + " ");
            for (int j = i + 2; j < A.length; j++) {
                if (A[i] - A[i + 1] == A[j - 1] - A[j]) {
                    System.out.print(j + ": " + A[j] + " ");
                    count++;
                } else {
                    break;
                }
            }
            System.out.println();
        }

        return count;
    }
}
