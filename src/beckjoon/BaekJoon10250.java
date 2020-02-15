package beckjoon;

import java.util.Scanner;

public class BaekJoon10250 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();

        int[] H = new int[T];
        int[] W = new int[T];
        int[] N = new int[T];

        for (int i = 0; i < T; i++) {
            H[i] = scanner.nextInt();
            W[i] = scanner.nextInt();
            N[i] = scanner.nextInt();
        }

        for (int i = 0; i < T; i++) {
            StringBuilder result = new StringBuilder();

            int number = N[i] / H[i];
            int floor = N[i] % H[i];

            if (floor != 0) {
                result.append(floor);

                if (number + 1 < 10) {
                    result.append(0);
                }

                result.append(number + 1);
            } else {
                result.append(H[i]);

                if (number < 10) {
                    result.append(0);
                }

                result.append(number);
            }


            System.out.println(result.toString());
        }
    }
}
