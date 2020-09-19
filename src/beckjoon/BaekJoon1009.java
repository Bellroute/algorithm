package beckjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon1009 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();
        int tries = Integer.parseInt(br.readLine());

        for (int i = 0; i < tries; i++) {
            String line = br.readLine();
            StringTokenizer st = new StringTokenizer(line);

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int number = 1;

            for (int j = 0; j < b; j++) {
                number *= a;
                number %= 10;
            }

            if (number == 0) {
                stringBuilder.append(10)
                             .append("\n");

                continue;
            }

            stringBuilder.append(number)
                         .append("\n");
        }

        System.out.println(stringBuilder.toString());
    }
}

