package naver.mainplatformIntern;

public class Q3 {

    public int solution(int N) {
        int answer = 0;

        String number = String.valueOf(N);

        if (N >= 0) {
            answer = plusSolution(number);
            return answer;
        }

        answer = minusSolution(number);

        return answer;
    }

    private int plusSolution(String number) {
        StringBuilder stringBuilder = new StringBuilder(number);
        for (int i = 0; i < number.length(); i++) {
            if (number.charAt(i) > '5') {
                continue;
            }

            stringBuilder.insert(i, "5");
            break;
        }

        return Integer.valueOf(stringBuilder.toString());
    }

    private int minusSolution(String number) {
        StringBuilder stringBuilder = new StringBuilder(number);
        for (int i = 1; i < number.length(); i++) {
            if (number.charAt(i) < '5') {
                continue;
            }

            stringBuilder.insert(i, "5");
            break;
        }

        return Integer.valueOf(stringBuilder.toString());
    }
}
