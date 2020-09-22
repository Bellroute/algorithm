package beckjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BaekJoon9576 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tries = Integer.parseInt(br.readLine());

        for (int i = 0; i < tries; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int answer = 0;

            boolean[] books = new boolean[N + 1];
            List<Applyment> applymentList = new ArrayList<>();

            for (int j = 0; j < M; j++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                applymentList.add(new Applyment(a, b));
            }

            Collections.sort(applymentList);

            for (int j = 0; j < applymentList.size(); j++) {
                int a = applymentList.get(j).a;
                int b = applymentList.get(j).b;

                for (int k = a; k <= b; k++) {
                    if (!books[k]) {
                        books[k] = true;
                        answer++;
                        break;
                    }
                }
            }

            sb.append(answer)
              .append("\n");
        }


        System.out.println(sb.toString());
    }

    static class Applyment implements Comparable<Applyment> {
        private int a;
        private int b;

        public Applyment(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public int compareTo(Applyment o) {
            return this.b - o.b;
        }
    }
}
