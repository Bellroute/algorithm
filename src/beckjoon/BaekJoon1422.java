package beckjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BaekJoon1422 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                String str_o1 = String.valueOf(o1);
                String str_o2 = String.valueOf(o2);

                if (str_o1.length() == str_o2.length()) {
                    return Integer.compare(o2, o1);
                }

                return str_o2.concat(str_o1).compareTo(str_o1.concat(str_o2));


//                int length = Math.max(str_o1.length(), str_o2.length());
//
//                for (int i = 0; i < length; i++) {
//                    int num_o1 = str_o1.charAt(i % str_o1.length());
//                    int num_o2 = str_o2.charAt(i % str_o2.length());
//
//                    if (num_o1 == num_o2) {
//                        continue;
//                    }
//
//                    return Integer.compare(num_o2, num_o1);
//                }
//
//                return 0;
            }
        });

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < K; i++) {
            Integer input = Integer.parseInt(br.readLine());

            priorityQueue.offer(input);

            if (max < input) {
                max = input;
            }
        }

        if (N > K) {
            for (int i = 0; i < N - K; i++) {
                priorityQueue.offer(max);
            }
        }

        StringBuilder sb = new StringBuilder();

        while (!priorityQueue.isEmpty()) {
            sb.append(priorityQueue.poll());
        }

        System.out.println(sb.toString());
    }
}
