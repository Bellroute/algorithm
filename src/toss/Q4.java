package toss;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class Q4 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String[] banks = input.split(" ");

        for (int i = 0; i < banks.length; i++) {
            Set<String> set = new HashSet<>();
            Stack<String> stack = new Stack<>();

            for (int j = 0; j <= i; j++) {
                stack.push(banks[j]);
            }

            int count = 0;

            while (!stack.empty()) {
                String target = stack.pop();

                if (set.contains(target) || count >= 5) {
                    continue;
                }

                set.add(target);
                System.out.print(target + " ");
                count++;
            }
            System.out.println();
        }
    }


}
