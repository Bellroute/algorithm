package beckjoon;

import java.util.Scanner;

public class BeckJoon2775 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int test = scanner.nextInt();

        for (int i = 0; i < test; i++) {
            int floor = scanner.nextInt();
            int room = scanner.nextInt();

            System.out.println(getMembers(floor, room));
        }
    }

    private static int getMembers(int floor, int room) {
        int sum = 0;

        for (int i = 1; i <= room; i++) {
            if (floor > 0) {
                sum += getMembers(floor - 1, i);
            } else {
                sum = i;
            }
        }

        return sum;
    }
}
