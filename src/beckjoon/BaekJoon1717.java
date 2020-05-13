package beckjoon;

import java.util.Scanner;

public class BaekJoon1717 {

    private static int[] arr;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder answer = new StringBuilder();

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        arr = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            arr[i] = i;
        }

        for (int i = 0; i < m; i++) {
            int check = scanner.nextInt();

            int x = scanner.nextInt();
            int y = scanner.nextInt();

            if (check == 0) {
                if (x < y) {
                    union(y, x);
                } else {
                    union(x, y);
                }
            } else {
                if (find(x) != find(y)) {
                    answer.append("NO\n");
                } else {
                    answer.append("YES\n");
                }
            }
        }

        System.out.println(answer.toString().substring(0, answer.length() - 1));
    }

    private static int find(int num) {
        if (num == arr[num]) {
            return num;
        }

        int p = find(arr[num]);
        arr[num] = p;

        return p;
    }

    private static void union(int num1, int num2) {
        int x = find(num1);
        int y = find(num2);

        if (x != y) {
            arr[x] = y;
        }
    }
}
