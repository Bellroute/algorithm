package programmers.kakao.blindRecruitment2019;

import java.util.ArrayList;
import java.util.HashSet;

public class Level2_CandidateKey {

    private static int numberOfColumn;
    private static int numberOfRow;
    private static String[][] table;
    private static ArrayList<Integer> keyList = new ArrayList<>();

    public static void main(String[] args) {
        String[][] relation = {
                {"100", "ryan", "music", "2"},
                {"200", "apeach", "math", "2"},
                {"300", "tube", "computer", "3"},
                {"400", "con", "computer", "4"},
                {"500", "muzi", "music", "3"},
                {"600", "apeach", "music", "2"}
        };

        System.out.println(solution(relation));

//        keyList.forEach(System.out::println);
    }

    public static int solution(String[][] relation) {
        numberOfColumn = relation[0].length;
        numberOfRow = relation.length;
        table = relation;

        int answer = 0;

        for (int bitMask = 0; bitMask < (1 << numberOfColumn); bitMask++) {
            if (isSubKey(bitMask)) {
                continue;
            }

            if (isUnique(bitMask)) {
                answer++;
                keyList.add(bitMask);
            }
        }

        return answer;
    }

    private static boolean isSubKey(int bitMask) {
        for (Integer subKey : keyList) {
            if ((bitMask & subKey) >= subKey) {
                return true;
            }
        }

        return false;
    }

    private static boolean isUnique(int bitMask) {
        HashSet<String> checkKeySet = new HashSet<>();
        StringBuilder stringBuilder = new StringBuilder();

        if (bitMask == 0) return false;

        for (int i = 0; i < numberOfRow; i++) {
            stringBuilder.setLength(0);

            for (int j = 0; j < numberOfColumn; j++) {

                if ((bitMask & (1 << j)) != 0) {
                    stringBuilder.append(table[i][j]);
                }
            }

            String key = stringBuilder.toString();
//            System.out.println(key);

            if (!checkKeySet.contains(key)) {
                checkKeySet.add(key);
            } else {
                return false;
            }
        }

        return true;
    }

}
