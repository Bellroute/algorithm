package beckjoon;

import java.util.Scanner;

public class BeakJoon2941 {
    private static Scanner scanner = new Scanner(System.in);
    private static String input;
    private static char[] box = new char[102];
    private static int count = 0;

    public static void main(String[] args) {
        input = scanner.next();

        for (int i = 0; i < input.length(); i++) {
            box[i] = input.charAt(i);
        }

        for (int i = 1; i < input.length(); i++) {
            if (box[i] == '=') {
                if (box[i - 1] == 'c' || box[i - 1] == 's') {
                    count++;
                }

                if (box[i - 1] == 'z') {
                    if (box[i - 2] == 'd') {
                        count += 2;
                    } else {
                        count++;
                    }
                }
            }

            if (box[i] == '-' && (box[i - 1] == 'c' || box[i - 1] == 'd')) {
                count++;
            }

            if (box[i] == 'j' && (box[i - 1] == 'l' || box[i - 1] == 'n')) {
                count++;
            }
        }

        System.out.println(input.length() - count);
    }
}
