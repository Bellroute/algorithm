package programmers.kakao.blindRecruitment2018;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class Level1_SecretMap {

    private static final String WALL = "#";
    private static final String BLANK = " ";

    @Test
    public void test() {
        assertEquals(new String[]{"#####", "# # #", "### #", "#  ##", "#####"}, solution(5, new int[]{9, 20, 28, 18, 11}, new int[]{30, 1, 21, 17, 28}));
        assertEquals(new String[]{"######", "###  #", "##  ##", " #### ", " #####", "### # "}, solution(6, new int[]{46, 33, 33, 22, 31, 50}, new int[]{27, 56, 19, 14, 14, 10}));
    }

    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];

        for (int i = 0; i < n; i++) {
            StringBuilder stringBuilder = new StringBuilder();
            int overlappedElement = (arr1[i] | arr2[i]);

            for (int j = n - 1; j >= 0; j--) {
                if ((overlappedElement & (1 << j)) != 0) {
                    stringBuilder.append(WALL);
                    continue;
                }

                stringBuilder.append(BLANK);
            }

            System.out.println(stringBuilder.toString());
            answer[i] = stringBuilder.toString();
        }

        return answer;
    }

//    public static void main(String[] args) {
//        String[] a = solution(6, new int[]{46, 33, 33 ,22, 31, 50}, new int[]{27 ,56, 19, 14, 14, 10});
//
//        for (int i = 0; i < 6; i++) {
//            System.out.println(a[i]);
//        }
//    }
//
//    public static String[] solution(int n, int[] arr1, int[] arr2) {
//        String[] answer = new String[n];
//
//        for (int i = 0; i < n; i++) {
//            answer[i] = Integer.toBinaryString(arr1[i] | arr2[i]);
//        }
//
//        for (int i = 0; i < answer.length; i++) {
//            answer[i] = String.format("%" + n + "s", answer[i]);
//            answer[i] = answer[i].replaceAll("1", "#");
//            answer[i] = answer[i].replaceAll("0", " ");
//        }
//
//
//
//        return answer;
//    }
}
