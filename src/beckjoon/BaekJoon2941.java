package beckjoon;

import java.util.Scanner;

public class BaekJoon2941 {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String input = scanner.next();
        int count = 0;

        while (input.length() != 0) {
            count++;

            if (input.length() == 1) {
                input = input.substring(1);
                continue;
            }

            switch (input.charAt(0)) {
                case 'c':
                    if (input.charAt(1) == '=' || input.charAt(1) == '-') {
                        input = input.substring(2);
                    } else {
                        input = input.substring(1);
                    }
                    break;
                case 'd':
                    if (input.charAt(1) == '-') {
                        input = input.substring(2);
                    } else if (input.length() >= 3 && input.substring(1, 3).equals("z=")) {
                        input = input.substring(3);
                    } else {
                        input = input.substring(1);
                    }
                    break;
                case 'l':
                    if (input.charAt(1) == 'j') {
                        input = input.substring(2);
                    } else {
                        input = input.substring(1);
                    }
                    break;
                case 'n':
                    if (input.charAt(1) == 'j') {
                        input = input.substring(2);
                    } else {
                        input = input.substring(1);
                    }
                    break;
                case 's':
                    if (input.charAt(1) == '=') {
                        input = input.substring(2);
                    } else {
                        input = input.substring(1);
                    }
                    break;
                case 'z':
                    if (input.charAt(1) == '=') {
                        input = input.substring(2);
                    } else {
                        input = input.substring(1);
                    }
                    break;
                default:
                    input = input.substring(1);
                    break;
            }
        }
        System.out.println(count);
    }
}
