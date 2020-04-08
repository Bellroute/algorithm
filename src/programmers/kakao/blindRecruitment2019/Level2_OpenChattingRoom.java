package programmers.kakao.blindRecruitment2019;

import java.util.Arrays;
import java.util.HashMap;

public class Level2_OpenChattingRoom {

    public static void main(String[] args) {
        String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan"};
        String[] answers = solution(record);

        for (String answer : answers) {
            System.out.println(answer);
        }
    }

    public static String[] solution(String[] record) {
        HashMap<String, String> memberInfo = new HashMap<>();

        int length = (int) Arrays.stream(record).filter(rec -> !rec.split(" ")[0].equals("Change")).count();

        String[] answer = new String[length];

        for (String str : record) {
            if (str.split(" ").length > 2) {
                memberInfo.put(str.split(" ")[1], str.split(" ")[2]);
            }
        }

        int index = 0;

        for (String str : record) {
            StringBuilder stringBuilder = new StringBuilder();

            if (str.split(" ")[0].equals("Enter")) {
                stringBuilder.append(memberInfo.get(str.split(" ")[1]))
                             .append("님이 들어왔습니다.");

                answer[index] = stringBuilder.toString();
                index++;
            } else if (str.split(" ")[0].equals("Leave")) {
                stringBuilder.append(memberInfo.get(str.split(" ")[1]))
                             .append("님이 나갔습니다.");
                answer[index] = stringBuilder.toString();
                index++;
            }
        }

        return answer;
    }
}
