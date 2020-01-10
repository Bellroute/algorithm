package beckjoon;

import java.util.Arrays;
import java.util.Scanner;

public class BaekJoon1026 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int[] A = new int[N];
        int[] B = new int[N];

        for (int i = 0; i < N; i++) {
            A[i] = scanner.nextInt();
        }

        int[] visited = new int[N];

        for (int i = 0; i < N; i++) {
            B[i] = scanner.nextInt();
            visited[i] = 0;
        }

        Arrays.sort(A);

        int[] sortedB = B.clone();
        Arrays.sort(sortedB);

        int[] sortedA = new int[N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (B[i] == sortedB[j] && visited[j] == 0) {
                    sortedA[i] = A[N - 1 - j];
                    visited[j] = 1;
                    break;
                }
            }
        }

        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += sortedA[i] * B[i];
        }

        System.out.println(sum);
    }
}

// 조건 무시하고 B를 정렬해서 푼 경우
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//
//        int N = scanner.nextInt();
//        int[] A = new int[N];
//        int[] B = new int[N];
//
//        for (int i = 0; i < N; i++) {
//            A[i] = scanner.nextInt();
//        }
//
//        for (int i = 0; i < N; i++) {
//            B[i] = scanner.nextInt();
//        }
//
//        Arrays.sort(A);
//        Arrays.sort(B);
//
//        int sum = 0;
//        for (int i = 0; i < N; i++) {
//            sum += A[i] * B[N - 1 - i];
//        }
//
//        System.out.println(sum);
//    }