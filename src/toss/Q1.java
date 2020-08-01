package toss;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q1 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        if (input.charAt(input.length() - 1) == '1') {
            System.out.println(false);
            return;
        }

        for (int i = 0; i < input.length() - 1; i++) {
            if (input.charAt(i) != '1' && input.charAt(i) != '2') {
                System.out.println(false);
                return;
            }

            if (input.charAt(i) == '1' && input.charAt(i + 1) == '1') {
                System.out.println(false);
                return;
            }
        }

        System.out.println(true);
    }
}
