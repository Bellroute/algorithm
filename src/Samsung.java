import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Samsung {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        String numbers = scanner.nextLine();
        String[] splitNumbers = numbers.split(" ");

        List<Integer> list = new ArrayList<>();

        for (String number : splitNumbers) {
           list.add(Integer.parseInt(number));
        }

        Collections.sort(list);
        int center = n / 2;

        System.out.println(list.get(center));
    }
}
