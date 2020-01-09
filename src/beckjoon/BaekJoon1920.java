package beckjoon;

import java.util.Arrays;
import java.util.Scanner;

public class BaekJoon1920 {
    static int[] A;
    static int[] Ms;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        A = new int[N];

        for (int i = 0; i < N; i++) {
            A[i] = scanner.nextInt();
        }

        Arrays.sort(A);

        int M = scanner.nextInt();
        Ms = new int[M];


        for (int i = 0; i < M; i++) {
            Ms[i] = scanner.nextInt();
        }

        for (int i = 0; i < M; i++) {
            System.out.println(binarySearch(A, 0, N - 1, Ms[i]));
        }
    }

    private static int binarySearch(int[] a, int first, int end, int target) {
        int mid = (first + end) / 2;

        if (target > a[a.length - 1] || target < a[0]) {
            return 0;
        }

        if (first > end) {
            return 0;
        } else {
            if (a[mid] > target) {
                return binarySearch(a, first, mid - 1, target);
            } else if (a[mid] < target) {
                return binarySearch(a, mid + 1, end, target);
            } else {
                return 1;
            }
        }
    }
}
