package programmers.naver.recurit2020;

public class Q1 {

    public static void main(String[] args) {
        System.out.println(solution("acbbcdc", "abc"));
    }

    public static String solution(String m, String k) {
        StringBuilder answer = new StringBuilder();

        int index = 0;

        for (int i = 0; i < m.length(); i++) {
            if (index == k.length()) {
                answer.append(m.substring(i));
                break;
            }

            if (m.charAt(i) == k.charAt(index)) {
                index++;

                continue;
            }

            answer.append(m.charAt(i));
        }

        return answer.toString();
    }
}
