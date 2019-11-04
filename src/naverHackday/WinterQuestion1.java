package naverHackday;

public class WinterQuestion1 {

    public static void main(String[] args) {
        int[] input = {1, 0, 8, 1, 0};

        System.out.println(solution(input));
    }

    public static int solution(int[] grade) {
        int answer = 0;

        for (int i = 0; i < grade.length - 1; i++) {
            for (int j = i + 1; j < grade.length; j++) {
                if (grade[i] > grade[j]) {
                    while (grade[i] != grade[j]) {
                        grade[i]--;
                        answer++;
                    }
                }
            }
        }

        return answer;
    }
}
