package programmers.monthly_code_challange.oct;

public class Q4 {

    public long solution(String s) {
        long answer = 0;

        for (int i = 0; i < s.length() - 1; i++) {
            for (int j = i; j < s.length(); j++) {
                if (s.charAt(i) != s.charAt(j)) {
                    System.out.println(s.substring(i, j));
                    answer += j - i;
                } else {
                    answer += j - i - 1;
                }
            }
        }

        return answer;
    }
}
