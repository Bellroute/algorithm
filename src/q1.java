import java.util.LinkedList;
import java.util.Queue;

public class q1 {

    private static final int CACHE_HIT = 1;
    private static final int CACHE_MISS = 5;

    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        Queue<String> cacheStorage = new LinkedList<>();

        for (String city :cities) {
            System.out.println(city);
            if (cacheStorage.contains(city)) {
                Queue<String> newStorage = new LinkedList<>();

                while (!cacheStorage.isEmpty()) {
                    String now = cacheStorage.poll();
                    if (now.equals(city)) {
                        continue;
                    }

                    newStorage.offer(now);
                }

                newStorage.offer(city);
                cacheStorage = newStorage;
                answer += CACHE_HIT;
                continue;
            }

            answer += CACHE_MISS;
            if (cacheSize == 0) {
                cacheStorage.poll();
            }

            cacheStorage.offer(city);
        }

        cacheStorage.forEach(System.out::print);

        return answer;
    }
}
