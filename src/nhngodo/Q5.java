package nhngodo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Q5 {

    public static void main(String[] args) {
        System.out.println(solution(new int[] {5, 7, 7}));
        System.out.println(solution(new int[] {10,10,10,10}));
        System.out.println(solution(new int[] {1}));
        System.out.println(solution(new int[] {5,10,7,3,8}));
    }

    public static int solution(int[] votes){
        if (votes.length == 1) {
            return 0;
        }

        if (votes.length == 2) {
            return (votes[0] + votes[1]) / 2 + 1 - votes[0];
        }

        int candidate0 = votes[0];

        List<Integer> vote = new ArrayList<>();
        for (int i = 1; i < votes.length; i++) {
            vote.add(votes[i]);
        }

        Collections.sort(vote);

        int top = vote.get(vote.size() - 1);
        int count = 0;

        for (int i = 0; i < vote.size(); i++) {
            if (top == vote.get(i)) {
                count++;
            }
        }

        if (candidate0 > top) {
            return 0;
        }

        if (candidate0 == top) {
            return 1;
        }

        if (count > 1) {
            return count;
        }

        int goal = vote.get(vote.size() - 2);

        return goal + 1 - candidate0;
    }
}
