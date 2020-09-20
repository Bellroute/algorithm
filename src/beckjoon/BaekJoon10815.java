package beckjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BaekJoon10815 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[] cards = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(cards);

        int M = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            sb.append(binarySearch(cards, Integer.parseInt(st.nextToken())))
              .append(" ");
        }

        System.out.println(sb.toString());
    }

    private static int binarySearch(int[] cards, int target) {
        int left = 0;
        int right = cards.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (cards[mid] < target) {
                left = mid + 1;
            } else if (cards[mid] > target) {
                right = mid - 1;
            } else {
                return 1;
            }
        }

        return 0;
    }
}
