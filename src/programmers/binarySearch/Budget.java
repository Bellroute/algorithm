package programmers.binarySearch;

public class Budget {
    private static int answer = 0;
    private static int total;

    public static void main(String[] args) {
        int[] budgets = {120, 110, 140, 150};
        int M = 485;

        System.out.println(solution(budgets, M));
    }

    public static int solution(int[] budgets, int M) {
        total = M;
        int max = 0;

        for (int budget : budgets) {
            max = Math.max(max, budget);
        }

        if (isUnder(budgets, M)) {
            return max;
        }

        binarySearch(budgets, 0, max);

        return answer;
    }

    private static void binarySearch(int[] budgets, int min, int max) {
        int start = min;
        int end = max;

        while (start <= end) {
            int mid = (start + end) / 2;
            long sum = 0;

            for (int budget : budgets) {
                if (budget > mid) {
                    sum += mid;
                } else {
                    sum += budget;
                }
            }

            if (sum < total) {
                start = mid + 1;
            } else if (sum > total){
                end = mid - 1;
            } else {
                answer = mid;
                return;
            }
        }

        answer = end;
    }

    private static boolean isUnder(int[] budgets, int M) {
        long sum = 0;

        for (int budget : budgets) {
            sum += budget;
        }

        return sum <= M;
    }
}
