package programmers.kakao.blindRecruitment2018;

public class Level2_NNotation {

    public static void main(String[] args) {
        System.out.println(solution(2, 4, 2, 1));
    }

    public static String solution(int n, int t, int m, int p) {
        StringBuilder answer = new StringBuilder();

        int length =  t * m;
        String[] numbers = getNumbers(n, length);

        int index = p - 1;
        for (int i = 0; i < t; i++) {
            answer.append(numbers[index]);
            index += m;
        }

        return answer.toString();
    }

    private static String[] getNumbers(int n, int length) {
        String[] result = new String[length];

        int index = 1;
        int count = 1;
        result[0] = "0";

        while (index < length) {
            StringBuilder stringBuilder = new StringBuilder();
            int number = count;

            while (number != 0) {
                if (number % n > 9) {
                    stringBuilder.append((char)(55 + (number % n)));
                } else {
                    stringBuilder.append(number % n);
                }

                number /= n;
            }

            String resultNumber = stringBuilder.reverse().toString();

            for (int i = 0; i < resultNumber.length(); i++) {
                if (index + i == length) {
                    break;
                }

                result[index + i] = String.valueOf(resultNumber.charAt(i));
            }

            index += resultNumber.length();
            count++;
        }

        return result;
    }
}
