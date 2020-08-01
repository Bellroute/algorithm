package toss;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Q3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        String[] numbers = input.split(" ");
        Map<String, Integer> cache = new HashMap();

        for (String number : numbers){
            if (cache.keySet().contains(number)) {
                System.out.print(cache.get(number) + " ");
                continue;
            }

//            int result = Function.compute(Integer.valueOf(number));
//            cache.put(number, result);
//            System.out.print(result + " ");
        }
    }
}
