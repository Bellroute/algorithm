package programmers.kakao.blindRecruitment2020;

import java.util.LinkedList;
import java.util.List;

public class Level3_OuterWall {
    private static int result = Integer.MAX_VALUE;
    private int[] dist;
    private boolean[] visit;
    private LinkedList<Integer> circleWeak;
    private int weakSize;

    public int solution(int n, int[] weak, int[] dist) {
        int answer = 0;
        this.dist = dist;
        visit = new boolean[dist.length];
        weakSize = weak.length;
        circleWeak = new LinkedList<>();

        for (int i = 0; i < weakSize; i++) {
            circleWeak.add(weak[i]);
        }

        for (int i = 0; i < weakSize; i++) {
            circleWeak.add(weak[i] + n);
        }

        getPermutation(0, new LinkedList<>());


        if (result == Integer.MAX_VALUE) {
            answer = -1;
        } else {
            answer = result;
        }

        return answer;
    }

    private void getPermutation(int count, LinkedList<Integer> friends) {
        if (count == dist.length) {
            check(friends);
            return;
        }

        for (int i = 0; i < dist.length; i++) {
            if (!visit[i]) {
                visit[i] = true;
                friends.add(dist[i]);
                getPermutation(count + 1, friends);
                friends.removeLast();
                visit[i] = false;
            }
        }
    }

    private void check(List<Integer> friends) {

        for (int i = 0; i < weakSize; i++) {
            int index = 0;
            boolean mark = false;
            int start = circleWeak.get(i);

            for (int j = i; j < i + weakSize; j++) {
                if (friends.get(index) < (circleWeak.get(j) - start)) {
                    start = circleWeak.get(j);
                    index++;

                    if (index == friends.size()) {
                        mark = true;
                        break;
                    }
                }
            }

            if (!mark) {
                result = Math.min(result, index + 1);
            }
        }
    }
}
