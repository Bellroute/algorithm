package programmers.kakao.blindRecruitment2020;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Level1_StringCompression {

    @Test
    public void test() {
        assertEquals(7, solution("aabbaccc"));
        assertEquals(9, solution("ababcdcdababcdcd"));
        assertEquals(8, solution("abcabcdede"));
        assertEquals(14, solution("abcabcabcabcdededededede"));
        assertEquals(17, solution("xababcdcdababcdcd"));
        assertEquals(1, solution("a"));
    }

    public int solution(String s) {
        int answer = Integer.MAX_VALUE;
        int length = s.length();
        int tries = length / 2;

        if (s.length() == 1) {
            return 1;
        }

        for (int i = 1; i <= tries; i++) {
            String result = compress(s, i);
            answer = Math.min(answer, result.length());
        }

        return answer;
    }

    private String compress(String s, int unit) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < s.length(); i += unit) {
            int count = 1;

            if (i + unit > s.length()) {
                result.append(s.substring(i));
                break;
            }

            String prev = s.substring(i, i + unit);

            for (int j = i + unit; j < s.length(); j += unit) {
                if (j + unit > s.length()) {
                    break;
                }

                String post = s.substring(j, j + unit);

                if (prev.equals(post)) {
                    count++;
                    i += unit;
                } else {
                    break;
                }
            }

            if (count == 1) {
                result.append(prev);
                continue;
            }

            result.append(count);
            result.append(prev);
        }


        return result.toString();
    }


//    public static void main(String[] args) {
//        System.out.println("answer: " + solution("aabbaccc"));
//        System.out.println("answer: " + solution("ababcdcdababcdcd"));
//        System.out.println("answer: " + solution("abcabcdede"));
//        System.out.println("answer: " + solution("abcabcabcabcdededededede"));
//        System.out.println("answer: " + solution("xababcdcdababcdcd"));
//    }
//
//    public static int solution(String s) {
//        int answer = s.length();
//        int tries = s.length() / 2;
//
//        if (s.length() == 1) {
//            return 1;
//        }
//
//        for (int i = 1; i <= tries; i++) {
//            String result = compress(s, i);
//            if (answer > result.length()) {
//                answer = result.length();
//            }
//        }
//
//        return answer;
//    }
//
//    private static String compress(String s, int unit) {
//        StringBuilder result = new StringBuilder();
//
//        for (int i = 0; i < s.length(); i += unit) {
//            int count = 1;
//
//            if (i + unit > s.length() ) {
//                result.append(s.substring(i));
//                break;
//            }
//
//            String prev = s.substring(i, i + unit);
//
//            for (int j = i + unit; j < s.length(); j += unit) {
//                if (j + unit > s.length() ) {
//                    break;
//                }
//
//                String post = s.substring(j, j + unit);
//
//                if (prev.equals(post)) {
//                    count++;
//                    i += unit;
//                } else {
//                    break;
//                }
//            }
//
//            if (count == 1) {
//                result.append(prev);
//                continue;
//            }
//
//            result.append(count);
//            result.append(prev);
//        }
//
//        return result.toString();
//    }
}
