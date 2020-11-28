package nhngodo;

import java.util.ArrayList;
import java.util.List;

public class Q4 {

    private final String VALID = "VALID";
    private final String INVALID = "INVALID";

    public String solution(String cardNumber){
        int length = cardNumber.length();
        List<Integer> numbers;

        if (length % 2 == 0) {
            numbers = getEvenCaseNumbers(length, cardNumber);
        } else {
            numbers = getOddCaseNumbers(length, cardNumber);
        }

        numbers.stream().forEach(System.out::println);

        if (addAll(numbers) % 10 != 0) {
            return INVALID;
        }

        return VALID;
    }

    private int addAll(List<Integer> numbers) {
        int result = 0;

        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) >= 10) {
                result += numbers.get(i) /10;
                result += numbers.get(i) % 10;

                continue;
            }

            result += numbers.get(i);
        }

        return result;
    }

    private List<Integer> getOddCaseNumbers(int length, String cardNumber) {
        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < length; i++) {
            int number = cardNumber.charAt(i) - '0';

            if (number == 0) {
                continue;
            }

            if (i % 2 != 0) {
                numbers.add(number * 2);
                continue;
            }

            numbers.add(number);
        }

        return numbers;
    }

    private List<Integer> getEvenCaseNumbers(int length, String cardNumber) {
        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < length; i++) {
            int number = cardNumber.charAt(i) - '0';

            if (number == 0) {
                continue;
            }

            if (i % 2 == 0) {
                numbers.add(number * 2);
                continue;
            }

            numbers.add(number);
        }

        return numbers;
    }
}
