package beckjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon1049 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int packages_min = 1001;
        int singles_min = 1001;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int pack = Integer.parseInt(st.nextToken());
            int single = Integer.parseInt(st.nextToken());

            if (pack < packages_min) {
                packages_min = pack;
            }

            if (single < singles_min) {
                singles_min = single;
            }
        }

        int answer = 0;
        while (N != 0) {
            if (N <= 6) {
                answer += Math.min(packages_min, singles_min * N);
                break;
            }

            if (packages_min > singles_min * 6) {
                answer += singles_min * N;
                break;
            } else {
                answer += packages_min * (N / 6);
                N %= 6;
            }
        }

        System.out.println(answer);
    }
}
