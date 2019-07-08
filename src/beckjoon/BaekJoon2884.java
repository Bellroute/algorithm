package beckjoon;

import java.util.Scanner;

public class BaekJoon2884 {
    private static Scanner scanner = new Scanner(System.in);
    private static String input;

    public static void main(String[] args) {
        input = scanner.nextLine();
        int H = Integer.parseInt(input.split(" ")[0]);
        int M = Integer.parseInt(input.split(" ")[1]);

        int minute = H * 60 + M;
        H = (minute - 45) / 60;
        M = (minute - 45) % 60;

        if (minute - 45 < 0) {
            H = 23;
            M = M + 60;
        }

        System.out.println(H + " " + M);
    }
}
