package beckjoon;

public class BaekJoon4673 {
    private static int[] checker = new int[10001];

    public static void main(String[] args) {
        for (int n = 1; n <= 10000; n++) {
            int dn = n;
            for (int i = 0; i < String.valueOf(n).length(); i++) {
                dn += Integer.parseInt(String.valueOf(n).split("")[i]);
            }

            if (dn <= 10000) {
                checker[dn]++;
            }
        }

        for (int i = 1; i <= 10000; i++) {
            if (checker[i] == 0) {
                System.out.println(i);
            }
        }
    }
}
