package programmers.kakao.blindRecruitment2019;

import org.junit.Test;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class Level4_FoodBroadcastLive {

    @Test
    public void test() {
        assertEquals(1, solution(new int[]{3, 1, 2}, 5));
        assertEquals(6, solution(new int[]{3, 1, 1, 1, 2, 4, 3}, 12));

    }

    public int solution(int[] food_times, long k) {
        int n = food_times.length;
        List<Food> list = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            list.add(new Food(food_times[i], i + 1));
        }

        list.sort(Comparator.comparingInt(o -> o.time));

        int pretime = 0;
        int i = 0;
        for(Food food : list) {
            long time = food.time - pretime;

            if (time != 0) {
                long spend = n * time;

                if (spend <= k) {
                    k -= spend;
                    pretime = food.time;
                } else {
                    k %= n;
                    list.subList(i, food_times.length).sort(Comparator.comparingInt(o -> o.index));

                    return list.get(i + (int) k).index;
                }
            }
            n--;
            i++;
        }

        return -1;
    }

    class Food {
        int time;
        int index;

        @Override
        public String toString() {
            return "Food{" +
                    "time=" + time +
                    ", index=" + index +
                    '}';
        }

        public Food(int time, int index) {
            this.time = time;
            this.index = index;
        }
    }
}
