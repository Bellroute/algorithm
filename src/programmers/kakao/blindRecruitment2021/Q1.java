package programmers.kakao.blindRecruitment2021;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Q1 {

    @Test
    public void test() {
//        assertEquals("bat.y.abcdefghi", solution("...!@BaT#*..y.abcdefghijklm"));
        assertEquals("aaa", solution("~!@#$%^&*()=+[{]}:?,<>/"));

    }

    public String solution(String new_id) {
        String answer = "";

        answer = new_id.toLowerCase();
        answer = removeExcludedCharacters(answer);
        answer = answer.replaceAll("\\.{2,}", ".");

        if (answer.length() != 0 && answer.charAt(0) == '.') {
            answer = answer.substring(1);
        }

        if (answer.length() != 0 && answer.charAt(answer.length() - 1) == '.') {
            answer = answer.substring(0, answer.length() - 1);
        }

        System.out.println(answer);

        if (answer.isEmpty()) {
            answer = "a";
        }

        if (answer.length() >= 16) {
            answer = answer.substring(0, 15);

            if (answer.charAt(answer.length() - 1) == '.') {
                answer = answer.substring(0, answer.length() - 1);
            }
        }

        while (answer.length() < 3) {
            answer += answer.charAt(answer.length() - 1);
        }

        return answer;
    }

    private String removeExcludedCharacters(String new_id) {
        char[] characters = new char[new_id.length()];
        int index = 0;

        for (int i = 0; i < new_id.length(); i++) {
            char character = new_id.charAt(i);

            if (character >= 48 && character <= 57) {
                continue;
            }

            if (character >= 97 && character <= 122) {
                continue;
            }

            if (character == '-' || character == '_' || character == '.') {
                continue;
            }

            characters[index++] = character;
        }

        for (int i = 0; i < index; i++) {
            new_id = new_id.replace(String.valueOf(characters[i]), "");
        }

        return new_id;
    }
}


// 대 -> 소
// 제외 문자 제거
// .. -> .
// . 앞 뒤로 제거
// 빈 문자열 a
// 16이상이면 15자까지. 만약 끝에 .이면 제거
// 길이가 2 이하면 3될때까지 마지막 문자 추가