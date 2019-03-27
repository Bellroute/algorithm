package beckjoon;

import java.util.Scanner;

public class BeckJoon1181 {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        String[] words = new String[N];

        for (int i = 0; i < words.length; i++) {
            words[i] = scanner.next();
        }

        // 삽입 정렬
        for (int i = 0; i < words.length; i++) {
            int count = i;
            while (count > 0) {
                if (words[count].length() < words[count - 1].length()) {
                    String temp = words[count];
                    words[count] = words[count - 1];
                    words[count - 1] = temp;

                    count--;
                } else if (words[count].length() == words[count - 1].length() && words[count].compareTo(words[count -1]) < 0) {
                        String temp = words[count];
                        words[count] = words[count - 1];
                        words[count - 1] = temp;

                        count--;
                } else {
                    break;
                }
            }
        }

        System.out.println(words[0]);
        for (int i = 1; i < words.length; i++) {
            if (!words[i].equals(words[i - 1])) {
                System.out.println(words[i]);
            }
        }
    }
}