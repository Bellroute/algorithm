package programmers.kakao.blindRecruitment2019;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Level2_CandidateKey {

    private int rowSize;
    private int colSize;
    List<Integer> candidates = new ArrayList<>();
    private String[][] db;

    public int solution(String[][] relation) {
        rowSize = relation.length;
        colSize = relation[0].length;
        db = relation;

        for (int i = 0; i < (1 << colSize); i++) {
            if (!isUnique(i)) {
                continue;
            }

            if (!isMinimum(i)) {
                continue;
            }

            candidates.add(i);
        }

        return candidates.size();
    }

    private boolean isMinimum(int set) {
        for (int candidateKey : candidates) {
            if ((set & candidateKey) == candidateKey) { // & 비트 연산은 둘 다 1일 경우에 1을 리턴, set & key == key라면 set은 key를 포함하고 있다는 말이 됨.
                return false;
            }
        }

        return true;
    }

    private boolean isUnique(int set) {
        Set<String> candidateSet = new HashSet<>();

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < colSize; i++) {
            if (((set >> i) & 1) == 1) {
                list.add(i);
            }
        }

        for (int i = 0; i < rowSize; i++) {
            StringBuilder stringBuilder = new StringBuilder();

            for (int j = 0; j < list.size(); j++) {
                stringBuilder.append(db[i][list.get(j)]);
            }

            if (candidateSet.contains(stringBuilder.toString())) {
                return false;
            }

            candidateSet.add(stringBuilder.toString());
        }

        return true;
    }


}
