package beckjoon;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class BaekJoon10866 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Deque<Integer> deque = new ArrayDeque<>();
        int N = scanner.nextInt();
        String[] commands = new String[N];
        scanner.nextLine();

        for (int i = 0; i < N; i++) {
            commands[i] = scanner.nextLine();
        }

        for (int i = 0; i < N; i++) {
            String command = commands[i];
            switch (command.split(" ")[0]) {
                case "push_front":
                    deque.addFirst(Integer.parseInt(command.split(" ")[1]));
                    break;
                case "push_back":
                    deque.addLast(Integer.parseInt(command.split(" ")[1]));
                    break;
                case "pop_front":
                    if (deque.isEmpty()) {
                        System.out.println(-1);
                    } else {
                        System.out.println(deque.pollFirst());
                    }
                    break;
                case "pop_back":
                    if (deque.isEmpty()) {
                        System.out.println(-1);
                    } else {
                        System.out.println(deque.pollLast());
                    }
                    break;
                case "size":
                    System.out.println(deque.size());
                    break;
                case "empty":
                    if (deque.isEmpty()) {
                        System.out.println(1);
                    } else {
                        System.out.println(0);
                    }
                    break;
                case "front":
                    if (deque.isEmpty()) {
                        System.out.println(-1);
                    } else {
                        System.out.println(deque.peekFirst());
                    }
                    break;
                case "back":
                    if (deque.isEmpty()) {
                        System.out.println(-1);
                    } else {
                        System.out.println(deque.peekLast());
                    }
                    break;
            }
        }
    }
}