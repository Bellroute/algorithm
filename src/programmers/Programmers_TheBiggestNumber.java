package programmers;

import java.util.Arrays;

public class Programmers_TheBiggestNumber {

    public String solution(int[] numbers) {
        String[] arr = new String[numbers.length];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(arr, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));

        String answer = "";

        for (int i = 0; i < arr.length; i++) {
            answer += arr[i];
        }

        if (arr[0].equals("0")) {
            answer = "0";
        }

        return answer;
    }
}
