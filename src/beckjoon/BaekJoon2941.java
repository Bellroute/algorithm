package beckjoon;

import java.util.Scanner;

public class BaekJoon2941 {
    private static Scanner scanner = new Scanner(System.in);
    private static String[] croatiaAlphabets = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};

    public static void main(String[] args) {
        String input = scanner.next();

        for (int i = 0; i < croatiaAlphabets.length; i++) {
            input = input.replace(croatiaAlphabets[i], "0");
        }

        System.out.println(input.length());
    }
}
