package toss;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q5 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        String[] kim = input.split(" ");

        input = br.readLine();
        String[] lee = input.split(" ");

        StringBuilder stringBuilder = new StringBuilder();

        int difference = 0;

        for (int i = 0; i < kim.length; i++) {
            difference += Integer.parseInt(kim[i]) - Integer.parseInt(lee[i]);

            if (difference > 0) {
                stringBuilder.append(difference)
                             .append(" ");

                difference = 0;
                continue;
            }

            stringBuilder.append(0)
                         .append(" ");
        }

        System.out.println(stringBuilder.toString());
    }
}