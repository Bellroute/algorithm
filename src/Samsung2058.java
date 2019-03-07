import java.util.Scanner;

public class Samsung2058 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();

        int sum = 0;

        while (input != 0) {
            sum += input % 10;
            input = input / 10;
        }

        System.out.println(sum);
    }
}
