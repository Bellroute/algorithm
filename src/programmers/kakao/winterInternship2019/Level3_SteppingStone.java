package programmers.kakao.winterInternship2019;

public class Level3_SteppingStone {
    private int limit;
    private int answer;

    public int solution(int[] stones, int k) {
        limit = k;
        int max = Integer.MIN_VALUE;

        for (int stone : stones) {
            max = Math.max(max, stone);
        }

        binarySearch(stones, 0, max);

        return answer;
    }

    private void binarySearch(int[] stones, int start, int end) {
        while (start <= end) {
            int mid = (start + end) / 2;
            int[] cloneStones = setStones(stones.clone(), mid);

            if (isPossible(cloneStones)) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        answer = start;
    }

    private boolean isPossible(int[] stones) {
        int count = 0;

        for (int i = 0; i < stones.length; i++) {
            if (stones[i] == 0) {
                count++;
            } else {
                count = 0;
                continue;
            }

            if (count == limit) {
                return false;
            }
        }

        return true;
    }

    private int[] setStones(int[] stones, int value) {

        for (int i = 0; i < stones.length; i++) {
            if (stones[i] <= value) {
                stones[i] = 0;
            }
        }

        return stones;
    }
}
