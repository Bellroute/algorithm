package beckjoon;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class BaekJoon1158 {
    private static Scanner scanner = new Scanner(System.in);
    private static String input;

    public static void main(String[] args) {
        input = scanner.nextLine();
        int N = Integer.parseInt(input.split(" ")[0]);
        int K = Integer.parseInt(input.split(" ")[1]);

        List<Integer> list = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            list.add(i, i + 1);
        }

        System.out.print("<");

        int k = K;
        while (list.size() > 1) {
            if (k - 1 < 0) {
                k = list.size();
            }

            System.out.print(list.get(--k) + ", ");
            list.remove(k);
            k = (k + K) % list.size();
        }

        System.out.print(list.get(0));
        System.out.println(">");
    }
}