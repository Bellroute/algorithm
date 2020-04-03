package etc;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class NumberGame {

    public static int solve(int n, int[] card) {
        int[] sum = new int[n + 1];
        int[][] D = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            D[i][i] = card[i];
        }

        for (int i = 1; i <= n; i++) {
            sum[i] += sum[i - 1] + D[i][i];
        }

        int i = 1;
        int j = 2;

        for (int x = 2; x <= n; x++) {
            for (int y = x + 1; y <= n + 1; y++) {
                D[i][j] = sum[j] - sum[i - 1] - Math.min(D[i + 1][j], D[i][j - 1]);

                i++;
                j++;
            }

            i = 1;
            j = x + 1;
        }
        return D[1][n];
    }

    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(new File("/Users/bellroot/Desktop/131_numbers.txt"));
            int T = sc.nextInt();    // # of Main case

            long st = System.currentTimeMillis();

            for (int t = 0; t < T; t++) {

                int n = sc.nextInt();
                int[] card = new int[n + 1];
                for (int i = 1; i <= n; i++) {
                    card[i] = sc.nextInt();
                }

                System.out.println(solve(n, card));
            }

            long et = System.currentTimeMillis();
            System.out.println((et - st) + " ms");

            sc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
