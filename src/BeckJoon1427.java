import java.util.Scanner;

public class BeckJoon1427 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        int[] numbers = new int[input.split("").length];
        for (int i = 0; i < input.split("").length; i++) {
            numbers[i] = Integer.parseInt(input.split("")[i]);
        }

        // 버블 정렬
        for (int i = numbers.length - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (numbers[j] < numbers[j + 1]) {
                    int temp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = temp;
                }
            }
        }

        for (int number : numbers) {
            System.out.print(number);
        }
    }
}
