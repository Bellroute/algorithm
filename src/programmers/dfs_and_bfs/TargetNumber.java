package programmers.dfs_and_bfs;

import java.util.Arrays;

public class TargetNumber {

    private static int answer = 0;

    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5};
        int target = 9;

        System.out.println(solution(numbers, target));
    }

    public static int solution(int[] numbers, int target) {

        if (Arrays.stream(numbers).sum() < target) {
            return 0;
        }

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = -numbers[i];
            dfs(numbers, target, i);
            numbers[i] = -numbers[i];
        }

        return answer;
    }

    private static void dfs(int[] numbers, int target, int index) {

        if (Arrays.stream(numbers).sum() == target) {
            answer++;
        } else if (Arrays.stream(numbers).sum() >= target) {
            for (int i = index + 1; i < numbers.length; i++) {
                numbers[i] = -numbers[i];
                dfs(numbers, target, i);
                numbers[i] = -numbers[i];
            }
        }
    }
}
