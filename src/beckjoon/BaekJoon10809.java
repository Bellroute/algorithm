package beckjoon;

import java.util.Scanner;

public class BaekJoon10809 {
    private static Scanner scanner = new Scanner(System.in);
    private static char[] inputArray;
    private static char[] alpabat = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    private static int[] output = new int[26];

    public static void main(String[] args) {
        String input = scanner.nextLine();
        inputArray = new char[input.length()];

        for (int i = 0; i < output.length; i++) {
            output[i] = -1;
        }

        for (int i = 0; i < inputArray.length; i++) {
            inputArray[i] = input.charAt(i);
        }

        for (int i = 0; i < alpabat.length; i++) {
            for (int j = 0; j < inputArray.length; j++) {
                if (alpabat[i] == inputArray[j] && output[i] == -1) {
                    output[i] = j;
                }
            }
        }

        for (int i = 0; i < output.length; i++) {
            System.out.print(output[i] + " ");
        }
    }
}
