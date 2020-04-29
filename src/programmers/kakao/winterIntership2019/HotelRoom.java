package programmers.kakao.winterIntership2019;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class HotelRoom {

    private static Map<Long, Long> hashMap = new HashMap<>();

    public static void main(String[] args) {
        long[] answer = solution(10, new long[]{1, 3, 4, 1, 3, 1});
        Arrays.stream(answer).forEach(System.out::print);
    }

    public static long[] solution(long k, long[] room_number) {
        long[] answer = new long[room_number.length];

        for (int i = 0; i < room_number.length; i++) {
            answer[i] = find(room_number[i]);
        }

        return answer;
    }

    private static long find(long room) {
        if (hashMap.keySet().contains(room)) {
            hashMap.put(room, find(hashMap.get(room)));
        } else {
            hashMap.put(room, room + 1);

            return room;
        }

        return hashMap.get(room);
    }
}
