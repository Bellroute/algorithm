package beckjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon13305 {

    private static int N;
    private static long[] distances;
    private static long[] prices;
    private static long answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        distances = new long[N - 1];
        prices = new long[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < distances.length; i++) {
            distances[i] = Long.parseLong(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < prices.length; i++) {
            prices[i] = Long.parseLong(st.nextToken());
            
            if (i > 0 && prices[i] > prices[i - 1]) {
                prices[i] = prices[i - 1];
            }
        }

        for (int i = 0; i < N - 1; i++) {
            answer += prices[i] * distances[i];
        }

        System.out.println(answer);
    }
}
