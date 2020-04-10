package programmers.hash;

import java.util.HashMap;

public class UnCompletion {

    public static void main(String[] args) {
        String[] participant = {"leo", "kiki", "eden"};
        String[] completion = {"kiki", "eden"};

        System.out.println(solution(participant, completion));
    }

    public static String solution(String[] participant, String[] completion) {
        String answer = "";

        HashMap<String, Integer> list = new HashMap();

        for (int i = 0; i < participant.length; i++) {
            if(list.keySet().contains(participant[i])) {
                list.put(participant[i], list.get(participant[i]) + 1);
            } else {
                list.put(participant[i], 1);

            }
        }

        for (int i = 0; i < completion.length; i++) {
            list.put(completion[i], list.get(completion[i]) - 1);
        }

        for (int i = 0; i < participant.length; i++) {
            if (list.get(participant[i]) != 0) {
                answer = participant[i];
            }
        }

        return answer;
    }
}
