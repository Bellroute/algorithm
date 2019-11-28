package beckjoon;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class BaekJoon1946 {
    private static Scanner scanner = new Scanner(System.in);
    private static int T;
    private static int[] tries = new int[20];
    private static int N;

    public static void main(String[] args) {
        int count;
        T = scanner.nextInt();

        for (int i = 0; i < T; i++) {
            N = scanner.nextInt();

            int[][] scores = new int[N][2];
            count = 1;

            for (int j = 0; j < N; j++) {
                for (int k = 0; k < 2; k++) {
                    scores[j][k] = scanner.nextInt();
                }
            }

            Arrays.sort(scores, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return Integer.compare(o1[0], o2[0]);
                }
            });

            int line = scores[0][1];

            for (int j = 0; j < N; j++) {
                if (scores[j][1] < line) {
                    count++;
                    line = scores[j][1];
                }
            }

            tries[i] = count;
        }

        for (int i = 0; i < T; i++) {
            System.out.println(tries[i]);
        }
    }
}

//    public static void main(String[] args) {
//        int count;
//        T = scanner.nextInt();
//
//        for (int i = 0; i < T; i++) {
//            N = scanner.nextInt();
//            scanner.nextLine();
//
//            count = 0;
//
//            for (int j = 0; j < N; j++) {
//                String input = scanner.nextLine();
//                for (int k = 0; k < 2; k++) {
//                    scores[j][k] = Integer.parseInt(input.split(" ")[k]);
//                }
//            }
//
//            int winnerOf1 = 0;
//            int winnerOf2 = 0;
//
//            for (int j = 0; j < N; j++) {
//                if (scores[j][0] == 1) {
//                    winnerOf1 = j;
//                }
//
//                if (scores[j][1] == 1) {
//                    winnerOf2 = j;
//                }
//            }
//
//            for (int j = 0; j < N; j++) {
//                if (scores[j][0] <= scores[winnerOf2][0] && scores[j][1] <= scores[winnerOf1][1]) {
//                    count++;
//                }
//            }
//
//            tries[i] = count;
//        }
//
//        for (int i = 0; i < T; i++) {
//            System.out.println(tries[i]);
//        }
//    }
