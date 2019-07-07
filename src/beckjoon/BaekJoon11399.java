package beckjoon;

import java.util.Scanner;

public class BaekJoon11399 {
    private static Scanner scanner = new Scanner(System.in);
    private static int N;
    private static int[] times;

    public static void main(String[] args) {
        N = scanner.nextInt();
        scanner.nextLine();
        String input = scanner.nextLine();
        times = new int[N];

        for (int i = 0; i < N; i++) {
            times[i] = Integer.parseInt(input.split(" ")[i]);
        }

        for (int i = 0; i < times.length; i++) {
            for (int j = i; j < times.length; j++) {
                int temp = 0;

                if (times[i] > times[j]) {
                    temp = times[i];
                    times[i] = times[j];
                    times[j] = temp;
                }
            }
        }

        int estimatedTime = 0;

        for (int i = 0; i < times.length; i++) {
            for (int j = 0; j <= i; j++) {
                estimatedTime += times[j];
            }
        }

        System.out.println(estimatedTime);
    }
}
