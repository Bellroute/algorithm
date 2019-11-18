package beckjoon;

import java.util.Scanner;

public class BaekJoon2096 {
    private static Scanner scanner = new Scanner(System.in);
    private static int[][] map;
    private static int N;

    public static void main(String[] args) {
        N = scanner.nextInt();

        map = new int[N][3];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 3; j++) {
                map[i][j] = scanner.nextInt();
            }
        }

        int[][] max = new int[2][3];
        int[][] min = new int[2][3];

        for (int i = 0; i < 3; i++) {
            max[1][i] = map[0][i];
            min[1][i] = map[0][i];
        }

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < 3; j++) {
                max[0][j] = max[1][j];
                min[0][j] = min[1][j];
            }

            max[1][0] = Math.max(max[0][0], max[0][1]) + map[i][0];
            max[1][1] = Math.max(max[1][0] - map[i][0], max[0][2]) + map[i][1];
            max[1][2] = Math.max(max[0][1], max[0][2]) + map[i][2];

            min[1][0] = Math.min(min[0][0], min[0][1]) + map[i][0];
            min[1][1] = Math.min(min[1][0] - map[i][0], min[0][2]) + map[i][1];
            min[1][2] = Math.min(min[0][1], min[0][2]) + map[i][2];

        }

        System.out.println(Math.max(Math.max(max[1][0], max[1][1]), max[1][2]) + " " + Math.min(Math.min(min[1][0], min[1][1]), min[1][2]));
    }
}

//    public static void main(String[] args) {
//        N = scanner.nextInt();
//        scanner.nextLine();
//
//        map = new int[N][3];
//
//        for (int i = 0; i < N; i++) {
//            String[] input = scanner.nextLine().split(" ");
//
//            for (int j = 0; j < 3; j++) {
//                map[i][j] = Integer.parseInt(input[j]);
//            }
//        }
//
//        int[][] max = new int[N][3];
//        int[][] min = new int[N][3];
//
//        for (int i = 0; i < 3; i++) {
//            max[0][i] = map[0][i];
//            min[0][i] = map[0][i];
//        }
//
//        for (int i = 1; i < N; i++) {
//            max[i][0] = max[i - 1][0] + max(map[i][0], map[i][1]);
//            max[i][1] = max[i - 1][1] + max(max[i][0] - max[i - 1][0], map[i][2]);
//            max[i][2] = max[i - 1][2] + max(map[i][1], map[i][2]);
//
//            min[i][0] = min[i - 1][0] + min(map[i][0], map[i][1]);
//            min[i][1] = min[i - 1][1] + min(min[i][0] - min[i - 1][0], map[i][2]);
//            min[i][2] = min[i - 1][2] + min(map[i][1], map[i][2]);
//        }
//
//        System.out.println(max(max[N - 1][0], max[N - 1][1], max[N - 1][2]) + " " + min(min[N - 1][0], min[N - 1][1], min[N - 1][2]));
//    }


// 재귀함수로 풀었음 -> 메모리 초과
//    public static void main(String[] args) {
//        N = scanner.nextInt();
//        scanner.nextLine();
//
//        for (int i = 0; i < N; i++) {
//            String[] input = scanner.nextLine().split(" ");
//
//            for (int j = 0; j < 3; j++) {
//                map[i][j] = Integer.parseInt(input[j]);
//            }
//        }
//
//        int max = 0;
//
//        for (int i = 0; i < 3; i++) {
//            int result = getBiggerScore(0, i);
//
//            if (max < result) {
//                max = result;
//            }
//        }
//
//        int min = 999999;
//
//        for (int i = 0; i < 3; i++) {
//            int result = getSmallerScore(0, i);
//
//            if (min > result) {
//                min = result;
//            }
//        }
//
//        System.out.println(max + " " + min);
//    }

//    private static int getSmallerScore(int n, int i) {
//        int firstNumber;
//        int secondNumber;
//        int thirdNumber;
//        int result = map[n][i];
//
//        if (n >= N - 1) {
//            return map[n][i];
//        }
//
//        switch (i) {
//            case 0:
//                firstNumber = getSmallerScore(n + 1, 0);
//                secondNumber = getSmallerScore(n + 1, 1);
//
//                result += firstNumber < secondNumber ? firstNumber : secondNumber;
//                break;
//            case 1:
//                firstNumber = getSmallerScore(n + 1, 0);
//                secondNumber = getSmallerScore(n + 1, 1);
//                thirdNumber = getSmallerScore(n + 1, 2);
//
//                int biggerNumber = firstNumber < secondNumber ? firstNumber : secondNumber;
//                result += biggerNumber < thirdNumber ? biggerNumber : thirdNumber;
//                break;
//            case 2:
//                firstNumber = getSmallerScore(n + 1, 1);
//                secondNumber = getSmallerScore(n + 1, 2);
//
//                result += firstNumber < secondNumber ? firstNumber : secondNumber;
//                break;
//        }
//
//        return result;
//    }
//
//    private static int getBiggerScore(int n, int i) {
//        int firstNumber;
//        int secondNumber;
//        int thirdNumber;
//        int result = map[n][i];
//
//        if (n >= N - 1) {
//            return map[n][i];
//        }
//
//        switch (i) {
//            case 0:
//                firstNumber = getBiggerScore(n + 1, 0);
//                secondNumber = getBiggerScore(n + 1, 1);
//
//                result += firstNumber > secondNumber ? firstNumber : secondNumber;
//                break;
//            case 1:
//                firstNumber = getBiggerScore(n + 1, 0);
//                secondNumber = getBiggerScore(n + 1, 1);
//                thirdNumber = getBiggerScore(n + 1, 2);
//
//                int biggerNumber = firstNumber > secondNumber ? firstNumber : secondNumber;
//                result += biggerNumber > thirdNumber ? biggerNumber : thirdNumber;
//                break;
//            case 2:
//                firstNumber = getBiggerScore(n + 1, 1);
//                secondNumber = getBiggerScore(n + 1, 2);
//
//                result += firstNumber > secondNumber ? firstNumber : secondNumber;
//                break;
//        }
//
//        return result;
//    }
