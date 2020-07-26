
package naver.mainplatformIntern;

import java.util.Set;
import java.util.TreeSet;

public class Q2 {

    public static void main(String[] args) {
        System.out.println(solution("azABaabza"));
        System.out.println(solution("TacoCat"));
        System.out.println(solution("AcZCbaBz"));
        System.out.println(solution("abcdefghijklmnopqrstuvwxyz"));
    }

    public static int solution(String S) {
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < S.length() - 1; i++) {
            for (int j = i + 1; j <= S.length(); j++) {

                if (j - i == 1) {
                    continue;
                }

                if (j - i > min) {
                    break;
                }

                if (isSatisfied(S.substring(i, j))) {
                    min = Math.min(min, j - i);
                }
            }
        }

        if (min == Integer.MAX_VALUE) {
            return -1;
        }

        return min;
    }

    private static boolean isSatisfied(String slicedString) {
        Set<Character> lowerLetters = new TreeSet<>();
        Set<Character> upperLetters = new TreeSet<>();

        for (int i = 0; i < slicedString.length(); i++) {
            char c = slicedString.charAt(i);

            if (c >= 'a' && c <= 'z') {
                lowerLetters.add(c);
            } else {
                upperLetters.add(c);
            }
        }

        if (lowerLetters.size() != upperLetters.size()) {
            return false;
        }


        for (char c : lowerLetters) {
            char tmp = (char) ('A' + c - 'a');
            if (!upperLetters.contains(tmp)) {
                return false;
            }
        }

        return true;

    }
}

