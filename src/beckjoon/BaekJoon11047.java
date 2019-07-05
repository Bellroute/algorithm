package beckjoon;

import java.util.Scanner;

public class BaekJoon11047 {
    private static Scanner scanner = new Scanner(System.in);
    private static int[] coins;
    private static int N;
    private static int K;
    private static int count = 0;

    public static void main(String[] args) {
        String input = scanner.nextLine();
        N = Integer.parseInt(input.split(" ")[0]);
        K = Integer.parseInt(input.split(" ")[1]);

        coins = new int[N];

        for (int i = 0; i < N; i++) {
            coins[i] = scanner.nextInt();
        }


        int upperIndex = 0;

        for (int i = 0; i < N; i++) {
            if (K < coins[i]) {
                upperIndex = i - 1;
                break;
            }

            upperIndex = N - 1;
        }

        int money = 0;

        for (int i = upperIndex; i >= 0; i--) {
            int num = 0;

            while (K - money >= coins[i] * num) {
                num++;
            }

            money += coins[i] * (num - 1);
            count += (num -1);

            if (money == K) {
                break;
            }
        }

        System.out.println(count);
    }
}

