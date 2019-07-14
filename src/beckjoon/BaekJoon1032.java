package beckjoon;

import java.util.Scanner;

public class BaekJoon1032 {
    private static Scanner scanner = new Scanner(System.in);
    private static String[] inputs = new String[50];

    public static void main(String[] args) {
        int count = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < count; i++) {
            inputs[i] = scanner.nextLine();
        }

        int index = 0;

        for (int i = 0; i < inputs[0].length(); i++) {
            String alphabet = inputs[0].split("")[i];
            boolean checker = true;

            for (int j = 1; j < count; j++) {
                if (!alphabet.equals(inputs[j].split("")[i])) {
                    checker = false;
                }
            }

            if (checker == true) {
                System.out.print(inputs[0].split("")[i]);
            } else {
                System.out.print("?");
            }
        }
    }
}
