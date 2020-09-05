package programmers.kakao.blindRecruitment2018;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

import static org.junit.Assert.assertEquals;

public class Level2_Cache {

    private static final int CACHE_HIT = 1;
    private static final int MISS_HIT = 5;

    @Test
    public void test() {
        assertEquals(50, solution(3, new String[] {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"}));
        assertEquals(21, solution(3, new String[] {"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"}));
    }

    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        Queue<String> cacheQueue = new LinkedList<>();

        if (cacheSize == 0) {
            return cities.length * MISS_HIT;
        }

        for (int i = 0; i < cities.length; i++) {
            String city = cities[i].toLowerCase();

            if (cacheQueue.contains(city)) {
                cacheQueue.remove(city);
                cacheQueue.offer(city);
                answer += CACHE_HIT;

                continue;
            }

            if (cacheQueue.size() == cacheSize) {
                cacheQueue.poll();
            }

            cacheQueue.offer(city);
            answer += MISS_HIT;
        }

        return answer;
    }

//    public static void main(String[] args) {
//        System.out.println(solution(3, new String[] {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"}));
//        System.out.println(solution(3, new String[] {"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"}));
//        System.out.println(solution(2, new String[] {"Jeju", "Pangyo", "NewYork", "newyork"}));
//    }
//
//    public static int solution(int cacheSize, String[] cities) {
//        int answer = 0;
//        Queue<String> queue = new LinkedList<>();
//
//        if (cacheSize == 0) {
//            return 5 * cities.length;
//        }
//
//        for (int i = 0; i < cities.length; i++) {
//            cities[i] = cities[i].toLowerCase();
//            if (queue.contains(cities[i])) {
//                queue.remove(cities[i]);
//                queue.offer(cities[i]);
//                answer += 1;
//            } else {
//                if (queue.size() < cacheSize) {
//                    queue.offer(cities[i]);
//
//                } else {
//                    queue.poll();
//                    queue.offer(cities[i]);
//                }
//                answer += 5;
//            }
//        }
//
//        return answer;
//    }
}
