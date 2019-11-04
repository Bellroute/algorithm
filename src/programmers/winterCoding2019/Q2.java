package programmers.winterCoding2019;

public class Q2 {
    public int[] solution(int n) {
        int[] answer = countFolding(n);

        return answer;
    }

    private int[] countFolding(int trial) {
        if (trial == 1) {
            return new int[]{0};
        }

        int[] prevCount = countFolding(trial - 1);
        int[] result = new int[prevCount.length * 2 + 1];

        for (int i = 0; i < prevCount.length; i++) {
            result[i] = prevCount[i];
        }

        result[prevCount.length] = 0;

        for (int i = prevCount.length + 1; i < result.length; i++) {
            int j = i - prevCount.length;
            result[i] = changeCompliment(prevCount[prevCount.length - j]);
        }

        return result;
    }

    private int changeCompliment(int number) {
        if (number == 0) {
            return 1;
        }

        return 0;
    }
}
