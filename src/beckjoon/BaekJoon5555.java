package beckjoon;

import java.util.Scanner;

public class BaekJoon5555 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String str = scanner.nextLine();
        int N = scanner.nextInt();

        scanner.nextLine();

        String[] rings = new String[N];

        int count = 0;

        for (int i = 0; i < N; i++) {
            rings[i] = scanner.nextLine();
        }

        for (int i = 0; i < N; i++) {
            if(isContain(str, rings[i])) {
                count++;
            }
        }

        System.out.println(count);
    }

    private static boolean isContain(String str, String ring) {
        ring += ring.substring(0, str.length() - 1);

        return ring.contains(str);
    }
}
