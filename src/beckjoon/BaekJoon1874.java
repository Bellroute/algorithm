package beckjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class BaekJoon1874 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] numbers = new int[N];

        for (int i = 0; i < N; i++) {
            numbers[i] = scanner.nextInt();
        }

        Stack<Integer> stack = new Stack<>();
        List<Character> results = new ArrayList<>();


        int count = 1;
        boolean isAble = true;

        for (int i = 0; i < N; i++) {
            int n = numbers[i];

            if (isAble) {
                while (count <= n) {
                    stack.add(count++);
                    results.add('+');
                }

                if (stack.empty()) {
                    isAble = false;
                } else {
                    while (!stack.empty() && stack.peek() >= n) {
                        stack.pop();
                        results.add('-');
                    }
                }
            }
        }

        if (isAble) {
            for (int i = 0; i < results.size(); i++) {
                System.out.println(results.get(i));
            }
        } else {
            System.out.println("NO");
        }
    }
}

//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int N = scanner.nextInt();
//        int[] numbers = new int[N];
//
//        for (int i = 0; i < N; i++) {
//            numbers[i] = scanner.nextInt();
//        }
//
//        Stack<Integer> stack = new Stack<>();
//        List<Character> results = new ArrayList<>();
//
//
//        int count = 0;
//
//        for (int i = 0; i < N; i++) {
//            int n = numbers[i];
//
//            if (stack.empty()) {
//                stack.push(++count);
//                results.add('+');
//            }
//
//            while (stack.peek() != n) {
//                if (stack.peek() <= n) {
//                    stack.push(++count);
//                    results.add('+');
//                    continue;
//                }
//
//                if (stack.peek() > n) {
//                    stack.pop();
//                    results.add('-');
//                }
//            }
//
//            if (stack.peek() == n) {
//                stack.pop();
//                results.add('-');
//            }
//        }
//
//        if (!stack.empty() || results.size() != N * 2) {
//            System.out.println("NO");
//        } else {
//            for (int i = 0; i < results.size(); i++) {
//                System.out.println(results.get(i));
//            }
//        }
//    }
