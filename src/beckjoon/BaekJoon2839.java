package beckjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon2839 {
    private static int numberOf3kg;
    private static int numberOf5kg = 0;
    private static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        while (numberOf5kg * 5 <= N) {
            if ((N - numberOf5kg * 5) % 3 == 0) {
                numberOf3kg = (N - numberOf5kg * 5) / 3;

                min = Math.min(min, numberOf3kg + numberOf5kg);
            }

            numberOf5kg++;
        }

        if (min == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(min);
        }
    }
}
