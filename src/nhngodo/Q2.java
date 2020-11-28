package nhngodo;

public class Q2 {

    private static final int NOW = 100;
    private static int min;
    private static int[] usable;

    public static void main(String[] args) {
        solution(99999, new int[] {0, 2, 3, 4, 5, 6, 7, 8, 9});
    }

    public static int solution(int page, int[] broken){

        min = Math.abs(page - NOW);
        usable = new int[10 - broken.length];

        int index = 0;

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < broken.length; j++) {
                if (i == broken[j]) {
                    break;
                }
            }

            usable[index] = i;
            index++;

            if (index == usable.length) {
                break;
            }
        }

        int length = (int) (Math.log10(page) + 1);

        for (int i = 1; i <= length + 1; i++) {
            for (int j = 0; j < usable.length; j++) {
                dfs(i, usable[j]);
            }
        }

        return min;
    }

    private static void dfs(int length, int now) {
        int nowLength = (int) (Math.log10(now) + 1);

        if (length == nowLength) {
            if (now == NOW) {
                return;
            }

            System.out.println(now);

            min = Math.min(min, Math.abs(now - NOW) + length);
            return;
        }

        for (int i = 0; i < usable.length; i++) {
            int movement = now * 10 + usable[i] + (int) (Math.log10(now) + 1);

            if (movement > min) {
                continue;
            }

            dfs(length, now);
        }
    }
}
