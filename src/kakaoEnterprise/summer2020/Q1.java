package kakaoEnterprise.summer2020;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class Q1 {
    private static final String LEVEL = "LEVEL";
    private static int levelCount = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        isContainNumber(input);
        isContainSmallLetter(input);
        isContainCapitalLetter(input);
        isContainSpecialCharacter(input);
        isSizeOver10(input);

        System.out.println(LEVEL + levelCount);
    }

    private static void isContainNumber(String input) {
        String pattern = "^\\S*[0-9]+\\S*$";

        if (Pattern.matches(pattern, input)) {
            levelCount++;
        }
    }

    private static void isContainSmallLetter(String input) {
        String pattern = "^\\S*[a-z]+\\S*$";

        if (Pattern.matches(pattern, input)) {
            levelCount++;
        }
    }

    private static void isContainCapitalLetter(String input) {
        String pattern = "^\\S*[A-Z]+\\S*$";

        if (Pattern.matches(pattern, input)) {
            levelCount++;
        }
    }

    private static void isContainSpecialCharacter(String input) {
        String pattern = "^\\S*\\W+\\S*$";

        if (Pattern.matches(pattern, input)) {
            levelCount++;
        }
    }

    private static void isSizeOver10(String input) {
        if (input.length() >= 10) {
            levelCount++;
        }
    }
}
