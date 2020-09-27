package programmers.naver.recurit2020;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Q2 {


    public static int[] solution(int[][] blocks) {

        int len = blocks.length;
        int[][] datas = new int[len][len];
        List<Integer> indexs = new ArrayList<>();

        for (int i = 0; i < len; i++) {
            datas[i][blocks[i][0]] = blocks[i][1];
            indexs.add(blocks[i][0]);
        }

        for (int i = 1; i < len; i++) {

            int tmp = indexs.get(i);

            //왼쪽
            for (int j = tmp; j >= 1; j--) {
                datas[i][j - 1] = datas[i - 1][j - 1] - datas[i][j];
            }

            //오른쪽
            for (int j = tmp; j < i; j++) {
                datas[i][j + 1] = datas[i - 1][j] - datas[i][j];
            }
        }

        List<Integer> answer = new LinkedList<>();
        for (int i = 0; i < len; i++) {
            for (int j = 0; j <= i; j++) {
                answer.add(datas[i][j]);
            }
        }

        int[] answerArr = new int[answer.size()];
        for (int i = 0; i < answer.size(); i++) {
            answerArr[i] = answer.get(i);
        }
        return answerArr;
    }
}
