package nhngodo;

import java.util.Arrays;

public class Q1 {
    public int solution(int[] goods){
        Arrays.sort(goods);

        int result = 0;
        int temp = 0;

        for (int i = 0; i < goods.length; i++) {
            if (goods[i] < 50) {
                temp += goods[i];

                continue;
            }

            result += goods[i] - 10;
        }

        result += temp;

        if (temp >= 50) {
            result -= 10;
        }

        return result;
    }
}
