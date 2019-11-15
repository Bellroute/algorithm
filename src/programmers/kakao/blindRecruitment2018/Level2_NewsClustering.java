package programmers.kakao.blindRecruitment2018;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class Level2_NewsClustering {

    @Test
    public void test() {
        assertEquals(16384, solution("FRANCE", "french"));
        assertEquals(65536, solution("handshake", "shake hands"));
        assertEquals(43690, solution("aa1+aa2", "AAAA12"));
        assertEquals(65536, solution("E=M*C^2", "e=m*c^2"));
    }

    @Test
    public void 문자열_두글자씩_끊어서_다중집합원소_만들기() {
        String str = "FRANCE";

        assertEquals(5, makeMultiSet(str).size());
    }

    @Test
    public void 문자열_두글자씩_끊을_때_특수문자_숫자_공백_버림() {
        String str_blank = "abc def";
        String str_digit = "abc1def";
        String str_specialCharacter = "abc+def";
        String str_complex = "abc+ 1def";

        String[] expected = {"AB", "BC", "DE", "EF" };

        assertEquals(expected.length, makeMultiSet(str_blank).size());
        assertEquals(expected.length, makeMultiSet(str_digit).size());
        assertEquals(expected.length, makeMultiSet(str_specialCharacter).size());
        assertEquals(expected.length, makeMultiSet(str_complex).size());
    }

    @Test
    public void 비교_시_대소문자_무시() {
        String str = "FRANCE";

        assertEquals(makeMultiSet(str.toLowerCase()), makeMultiSet(str));
    }

    @Test
    public void 교집합_갯수() {
        List<String> A = Arrays.asList("1", "2", "3", "4");
        List<String> B = Arrays.asList("1", "2", "5", "6");
        List<String> C = Arrays.asList("1", "1", "2", "2", "3");
        List<String> D = Arrays.asList("1", "2", "2", "4", "5");
        List<String> E = Arrays.asList("1", "2", "4", "5");

        assertEquals(2, countIntersection(A, B));
        assertEquals(3, countIntersection(C, D));
        assertEquals(2, countIntersection(E, C));
    }


    @Test
    public void 합집합() {
        List<String> A = Arrays.asList("1", "2", "3", "4");
        List<String> B = Arrays.asList("1", "2", "5", "6");
        List<String> C = Arrays.asList("1", "1", "2", "2", "3");
        List<String> D = Arrays.asList("1", "2", "2", "4", "5");

//        assertEquals(6, countUnion(A, B));
        assertEquals(7, countUnion(D, C));
    }

    @Test
    public void 자카드_유사도() {

    }

    @Test
    public void 유사도에_65536_곱한_뒤_소수점_버림() {

    }

    public int solution(String str1, String str2) {
        int answer = 0;
        return answer;
    }

    private List<String> makeMultiSet(String str) {
        List<String> multiSet = new ArrayList<>();

        for (int i = 1; i < str.length(); i++) {
            if (Character.isAlphabetic(str.charAt(i - 1)) && Character.isAlphabetic(str.charAt(i))) {
                multiSet.add(str.substring(i - 1, i + 1).toUpperCase());
            }
        }

        return multiSet;
    }


    private int countIntersection(List<String> list1, List<String> list2) {
        List<String> intersectionSet = new ArrayList<>();

        for (String str : list2) {
            if (list1.contains(str)) {
                list1.remove(str);
            }


        }

        return intersectionSet.size();
    }

    private int countUnion(List<String> a, List<String> b) {
        int count = 0;

        return count;
    }
}
