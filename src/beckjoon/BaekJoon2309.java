package beckjoon;

import java.util.Scanner;

public class BaekJoon2309 {
    private static Scanner scanner = new Scanner(System.in);
    private static int[] dwarfs = new int[9];

    public static void main(String[] args) {

        for (int i = 0; i < dwarfs.length; i++) {
            dwarfs[i] = scanner.nextInt();
        }

        int totalHight = 0;
        for (int dwarf : dwarfs) {
            totalHight += dwarf;
        }

        for (int i = 0; i < dwarfs.length; i++) {
            for (int j = i; j < dwarfs.length; j++) {
                int temp = 999;

                if (dwarfs[i] > dwarfs[j]) {
                    temp = dwarfs[i];
                    dwarfs[i] = dwarfs[j];
                    dwarfs[j] = temp;
                }
            }
        }

        int exceptDwarf1Index = 100;
        int exceptDwarf2Index = 100;
        for (int i = 0; i < dwarfs.length; i++) {
            for (int j = i + 1; j <= dwarfs.length - 1; j++) {
                int exceptedDwafsHight = dwarfs[i] + dwarfs[j];

                if (totalHight - exceptedDwafsHight == 100) {
                    exceptDwarf1Index = i;
                    exceptDwarf2Index = j;
                    break;
                }
            }
        }

        for (int i = 0; i < dwarfs.length; i++) {
            if (i == exceptDwarf1Index || i == exceptDwarf2Index) {
                continue;
            }

            System.out.println(dwarfs[i]);
        }
    }
}
