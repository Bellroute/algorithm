package beckjoon;

import java.util.Scanner;

public class Baekjoon5622 {
    private static Scanner scanner = new Scanner(System.in);
    private static char[] input;

    public static void main(String[] args) {
        String word = scanner.nextLine();
        input = new char[word.length()];

        for (int i = 0; i < word.length(); i++) {
            input[i] = word.toCharArray()[i];
        }

        int time = 0;
        for (int i = 0; i < input.length; i++) {
            time += returnDial(input[i]) + 1;
        }

        System.out.println(time);
    }

    private static int returnDial(char alpabet) {
        if ((int) alpabet >= 65 && (int) alpabet < 68) {
            return 2;
        }

        if ((int) alpabet >= 68 && (int) alpabet < 71) {
            return 3;
        }

        if ((int) alpabet >= 71 && (int) alpabet < 74) {
            return 4;
        }

        if ((int) alpabet >= 74 && (int) alpabet < 77) {
            return 5;
        }

        if ((int) alpabet >= 77 && (int) alpabet < 80) {
            return 6;
        }

        if ((int) alpabet >= 80 && (int) alpabet < 84) {
            return 7;
        }

        if ((int) alpabet >= 84 && (int) alpabet < 87) {
            return 8;
        }

        if ((int) alpabet >= 87 && (int) alpabet <= 90) {
            return 9;
        }


        return 0;
    }
}
