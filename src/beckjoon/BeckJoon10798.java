package beckjoon;

import java.util.Scanner;

public class BeckJoon10798 {
    private static Scanner scanner = new Scanner(System.in);
    private static char[][] box = new char[7][17];
    private static String[] inputs = new String[7];
    private static int max = 0;

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            inputs[i] = scanner.next();
            if (max < inputs[i].length()) {
                max = inputs[i].length();
            }
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < inputs[i].length(); j++) {
                box[i][j] = inputs[i].charAt(j);
            }
        }

        for (int k = 0; k < max; k++) {
            for (int j = 0; j < 5; j++) {
                if (inputs[j].length() > k) {
                    System.out.print(box[j][k]);
                }
            }
        }
    }
}
