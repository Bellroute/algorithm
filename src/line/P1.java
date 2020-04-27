package line;

public class P1 {
    private static int[] counter = new int[8];

    public static void main(String[] args) {
        String input1 = "Hello, world!";
        String input2 = "line [plus]";
        String input3 = "if (Count of eggs is 4.) {Buy milk.}";
        String input4 = ">_<";

        System.out.println(solution(input1));
        counter = new int[8];
        System.out.println(solution(input2));
        counter = new int[8];
        System.out.println(solution(input3));
        counter = new int[8];
        System.out.println(solution(input4));
    }

    public static int solution(String inputString) {
        int answer = 0;

        for (int i = 0; i < inputString.length(); i++) {
            switch (inputString.charAt(i)) {
                case '{':
                    counter[0] += 1;
                    continue;
                case '}':
                    if (counter[0] > counter[1]) {
                        counter[1] += 1;
                        continue;
                    } else {
                        return -1;
                    }
                case '(':
                    counter[2] += 1;
                    continue;
                case ')':
                    if (counter[2] > counter[3]) {
                        counter[3] += 1;
                        continue;
                    } else {
                        return -1;
                    }
                case '[':
                    counter[4] += 1;
                    continue;
                case ']':
                    if (counter[4] > counter[5]) {
                        counter[5] += 1;
                        continue;
                    } else {
                        return -1;
                    }
                case '<':
                    counter[6] += 1;
                    continue;
                case '>':
                    if (counter[6] > counter[7]) {
                        counter[7] += 1;
                    } else {
                        return -1;
                    }
            }
        }

        for (int i = 0; i < counter.length; i += 2) {

            if (counter[i] == 0 && counter[i + 1] == 0) {
                continue;
            }

            if (counter[i] == counter[i + 1]) {
                answer++;
            } else {
                return -1;
            }
        }


        return answer;
    }
}
