package naverHackday.summer2020;

public class Test3 {

    public static void main(String[] args) {
        System.out.println(solution(3, 8, 4));
    }

    public static int solution(int n, int m, int k) {
        if (!isAble(n, m, k)) {
            return 0;
        }

        int skiSlope = getCase((n / 2) + (n % 2), k);
        int boardSlope = getCase(n / 2, k);

        return skiSlope * boardSlope * 2 % 1000000007;
    }

    private static int getCase(int n, int k) {
        int count = 1;

        if (n == 1) {
            return 1;
        }

        for (int i = 0; i < n; i++) {
            count *= (k - n) - i;
        }

        return count + 1;
    }

    private static boolean isAble(int n, int m, int k) {
        return n <= m && m <= n * k;
    }
}
