package beckjoon;

import java.util.Scanner;

public class BaekJoon1541 {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String input = scanner.nextLine();
        int total = 0;

        String[] splitStrByMinus = input.split("-");

        for (int i = 0; i < splitStrByMinus.length; i++) {

            if (i == 0) {
                total += calculateAddExpression(splitStrByMinus[i]);
            } else {

                total -= calculateAddExpression(splitStrByMinus[i]);
            }
        }

        System.out.println(total);
    }

    private static int calculateAddExpression(String str) {
        int result = 0;

        for (int i = 0; i < str.split("\\+").length; i++) {
            result += Integer.parseInt(str.split("\\+")[i]);
        }

        return result;
    }
}
