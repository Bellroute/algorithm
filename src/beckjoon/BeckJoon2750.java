package beckjoon;

import java.util.Scanner;

public class BeckJoon2750 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        int[] numbers = new int[count];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = scanner.nextInt();
        }

        // 선택 정렬
        for (int j = 0; j < numbers.length; j++) {
            int max = numbers[0];
            int maxindex = 0;
            for (int i = 1; i < numbers.length - j; i++) {
                if (numbers[i] > max) {
                    max = numbers[i];
                    maxindex = i;
                }
            }
            numbers[maxindex] = numbers[numbers.length - 1 - j];
            numbers[numbers.length - 1 - j] = max;
        }

        for (int i = 0; i < numbers.length; i++) {
            System.out.println(numbers[i]);
        }
    }
}
