package beckjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon1010 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String line = br.readLine();
            StringTokenizer st = new StringTokenizer(line);

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            sb.append(dp(N, M))
              .append("\n");
        }

        System.out.println(sb.toString());
    }

    private static int dp(int n, int m) {
        if (n == m) {
            return 1;
        }

        if (n == 1) {
            return m;
        }

        int answer = 0;

        for (int i = n - 1; i < m; i++) {
            answer += dp(n - 1, i);
        }

        return answer;
    }
}
