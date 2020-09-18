package beckjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon6549 {

    private static int[] histogram;
    private static int[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();

        while (true) {
            String line = in.readLine();
            StringTokenizer st = new StringTokenizer(line);
            int length = Integer.valueOf(st.nextToken());

            if (length == 0) {
                break;
            }

            histogram = new int[length + 1];


            for (int i = 1; i <= length; i++) {
                histogram[i] = Integer.valueOf(st.nextToken());
            }

            tree = new int[length * 4]; //?
            init(1, 1, length);

            stringBuilder.append(getMax(1, length, length))
                         .append("\n");
        }

        System.out.println(stringBuilder.toString());
    }

    private static void init(int node, int start, int end) {
        if (start == end) {
            tree[node] = start;
            return;
        }

        int mid = (start + end) / 2;
        init(node * 2, start, mid);
        init(node * 2 + 1, mid + 1, end);

        if (histogram[tree[node * 2]] <= histogram[tree[node * 2 + 1]]) {
            tree[node] = tree[node * 2];
        } else {
            tree[node] = tree[node * 2 + 1];
        }
    }

    private static int query(int node, int start, int end, int left, int right) {
        if (right < start || end < left) {
            return -1;
        }

        if (left <= start && end <= right) {
            return tree[node];
        }

        int mid = (start + end) / 2;
        int m1 = query(node * 2, start, mid, left, right);
        int m2 = query(node * 2 + 1, mid + 1, end, left, right);

        if (m1 == -1) {
            return m2;
        } else if (m2 == -1) {
            return m1;
        } else {
            if (histogram[m1] <= histogram[m2]) {
                return m1;
            } else {
                return m2;
            }
        }
    }

    private static long getMax(int start, int end, int length) {
        int m = query(1, 1, length, start, end);

        long area = (end - start + 1) * (long) histogram[m];

        if (start <= m - 1) {
            long temp = getMax(start, m - 1, length);
            area = Math.max(area, temp);
        }

        if (m + 1 <= end) {
            long temp = getMax(m + 1, end, length);
            area = Math.max(area, temp);
        }

        return area;
    }
}
