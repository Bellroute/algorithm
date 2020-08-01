package toss;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

import static java.lang.Integer.valueOf;

public class Q2 {

    private static final int NUMBER_OF_LOTTO = 6;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        String[] numbers = input.split(" ");

        if (numbers.length != NUMBER_OF_LOTTO) {
            System.out.println(1);
            System.out.println(false);
            return;
        }

        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < numbers.length; i++) {
            int target = valueOf(numbers[i]);

            if (target < MIN_NUMBER || target > MAX_NUMBER) {
                System.out.println(false);
                return;
            }

            if (set.stream().anyMatch(number -> number > target)) {
                System.out.println(3);
                System.out.println(false);
                return;
            }

            set.add(target);
        }

        if (set.size() != NUMBER_OF_LOTTO) {
            System.out.println(4);
            System.out.println(false);
            return;
        }

        System.out.println(true);
    }
}
