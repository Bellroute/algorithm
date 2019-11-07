package programmers.kakao.blindRecruitment2018;


import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;


public class Level1_DartGame {
    @Test
    public void test() {
        assertEquals(37, solution("1S2D*3T"));
        assertEquals(9, solution("1D2S#10S"));
        assertEquals(3, solution("1D2S0T"));
        assertEquals(23, solution("1S*2T*3S"));
        assertEquals(5, solution("1D#2S*3S"));
        assertEquals(-4, solution("1T2D3D#"));
        assertEquals(59, solution("1D2S3T*"));
        assertEquals(10, solution("1S*1D*1T*"));
        assertEquals(12, solution("1S10S1T"));
    }

    private class Round {
        private int score;
        private int area;
        private int option;
        private int total;

        private Round(String result) {
            for (int i = 0; i < result.length(); i++) {
                if (Character.isAlphabetic(result.charAt(i))) {
                    this.score = Integer.parseInt(result.substring(0, i));
                    this.area = result.charAt(i);

                    if (i != result.length() - 1) {
                        this.option = result.charAt(result.length() - 1);
                    }
                }
            }

            calculateTotal();
        }

        private void calculateTotal() {
            switch (area) {
                case 'S':
                    this.total = applyOption(score);
                    break;
                case 'D':
                    this.total = applyOption(getDouble(score));
                    break;
                case 'T':
                    this.total = applyOption(getTriple(score));
                    break;
            }
        }

        private int applyOption(int score) {
            if (option == '*') {
                return score * 2;
            } else if (option == '#') {
                return score * -1;
            }

            return score;
        }
    }

    public int solution(String dartResult) {
        int answer = 0;

        StringBuilder slicingPoint = new StringBuilder();

        for (int i = 0; i < dartResult.length(); i++) {
            if (i > 1 && Character.isDigit(dartResult.charAt(i)) && !Character.isDigit(dartResult.charAt(i - 1))) {
                slicingPoint.append(i);
            }
        }

        List<Round> roundList = new ArrayList<>();
        roundList.add(new Round(dartResult.substring(0, slicingPoint.charAt(0) - 48)));
        roundList.add(new Round(dartResult.substring(slicingPoint.charAt(0) - 48, slicingPoint.charAt(1) - 48)));
        roundList.add(new Round(dartResult.substring(slicingPoint.charAt(1) - 48)));

        for (int i = 0; i < roundList.size(); i++) {
            if (i > 0 && roundList.get(i).option == '*') {
                roundList.get(i - 1).total *= 2;
            }
        }

        for (Round round : roundList) {
            answer += round.total;
        }

        return answer;
    }

    private int getDouble(int score) {
        return (int) Math.pow(score, 2);
    }

    private int getTriple(int score) {
        return (int) Math.pow(score, 3);
    }
}
