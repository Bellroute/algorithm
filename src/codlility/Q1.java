package codlility;

public class Q1 {

    public static void main(String[] args) {
        System.out.println(solution("ababba"));
    }

    public static int solution(String S) {
        if (S.contains("aaa")) {
            return -1;
        }

        S = S.replace("aa", "A");

        int count = 0;

        if (S.charAt(0) == 'a') {
            count++;
        } else if (S.charAt(0) != 'A') {
            count += 2;
        }

        for (int i = 1; i < S.length(); i++) {
            if (S.charAt(i) == 'A') {
                continue;
            }

            if (S.charAt(i) == 'a') {
                count++;
                S = S.substring(0, i) + 'A' + S.substring(i + 1);
                continue;
            }

            if (S.charAt(i) != 'A' && S.charAt(i) != 'a') {
                if (S.charAt(i - 1) != 'a' && S.charAt(i - 1) != 'A') {
                    count += 2;
                }
            }
        }

        if (S.charAt(S.length() - 1) == 'a') {
            count++;
        } else if (S.charAt(S.length() - 1) != 'A') {
            count += 2;
        }

        return count;
    }
}
