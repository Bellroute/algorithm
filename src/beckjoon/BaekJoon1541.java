package beckjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BaekJoon1541 {
    private static Scanner scanner = new Scanner(System.in);
    private static List<String> splits = new ArrayList<>();

    public static void main(String[] args) {
        String input = scanner.nextLine();
        int sum = 0;

        for (int i = 0; i < input.split("-").length; i++) {
            splits.add(input.split("-")[i]);
        }

        if (splits.get(0).equals("")) {
            splits.set(1, "-" + splits.get(1));
        }

        for (int i = 0; i < splits.size(); i++) {
            if (splits.get(i).equals("")) {
                continue;
            }

            if (splits.get(i).contains("+")) {
                if (i == 0) {
                    sum += adder(splits.get(i));
                } else {
                    sum -= adder(splits.get(i));
                }
            } else {
                if (i == 0) {
                    sum += Integer.parseInt(splits.get(i));
                } else {
                    sum -= Integer.parseInt(splits.get(i));
                }
            }
        }

        System.out.println(sum);
    }

    private static int adder(String str) {
        int result = 0;

        for (int i = 0; i < str.split("\\+").length; i++) {
            result += Integer.parseInt(str.split("\\+")[i]);
        }

        return result;
    }
}
