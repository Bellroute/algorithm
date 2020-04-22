package programmers.dynamicProgramming;

public class Tile {

    // 반복문을 이용한 방법
    public long solution(int N) {
        long[] function = new long[80];

        function[0] = 2;
        function[1] = 3;

        for (int i = 2; i < function.length; i++) {
            function[i] = function[i - 1] + function[i -2];
        }

        return function[N - 1] * 2;
    }

// 재귀를 이용한 방법
//    public long solution(int N) {
//        long answer = function(N) * 2;
//        return answer;
//    }
//
//    public long function(int n) {
//        if (n == 1) {
//            return 2;
//        }
//
//        if (n == 2) {
//            return 3;
//        }
//
//        return function(n - 1) + function(n - 2);
//    }
}
