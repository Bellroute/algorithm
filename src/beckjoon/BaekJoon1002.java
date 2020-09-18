package beckjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon1002 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tries = Integer.parseInt(br.readLine());

        for (int i = 0; i < tries; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int count = 0;

            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int r1 = Integer.parseInt(st.nextToken());

            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());

            double dist = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
            int sum = r1 + r2;
            int dif = Math.abs(r1 - r2);

            if (dist == 0 && dif == 0) {
                sb.append("-1\n");
            } else if (dist < dif || dist > sum) {
                sb.append("0\n");
            } else if (dist == dif || dist == sum) {
                sb.append("1\n");
            } else {
                sb.append("2\n");
            }
        }

        System.out.println(sb.toString());
    }
}
