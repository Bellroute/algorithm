import java.util.Scanner;

public class BeckJoon2292 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();

        if (input != 1) {
            input = (input - 1) / 6 + 1;

            int n = 1;

            while (n * (n - 1) != input * 2) {
                n++;
            }

            System.out.println(n);

        } else {
            System.out.println(0);
        }


    }
}
