package beckjoon;

public class test {
    public static void main(String[] args) {
        String str = "123456";

        for (int i = 1; i <= str.length() / 2; i++) {

            System.out.println(str.substring(str.length() - i));
            System.out.println(str.substring(str.length() - 2 * i, str.length() - i));
        }
    }
}
