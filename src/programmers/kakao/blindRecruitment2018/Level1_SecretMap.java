package programmers.kakao.blindRecruitment2018;

public class Level1_SecretMap {

    public static void main(String[] args) {
        String[] a = solution(6, new int[]{46, 33, 33 ,22, 31, 50}, new int[]{27 ,56, 19, 14, 14, 10});

        for (int i = 0; i < 6; i++) {
            System.out.println(a[i]);
        }
    }

    public static String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];

        for (int i = 0; i < n; i++) {
            answer[i] = Integer.toBinaryString(arr1[i] | arr2[i]);
        }

        for (int i = 0; i < answer.length; i++) {
            answer[i] = String.format("%" + n + "s", answer[i]);
            answer[i] = answer[i].replaceAll("1", "#");
            answer[i] = answer[i].replaceAll("0", " ");
        }



        return answer;
    }
}
