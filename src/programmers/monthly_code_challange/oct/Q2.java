package programmers.monthly_code_challange.oct;

import java.util.LinkedList;
import java.util.Queue;

public class Q2 {

    public static void main(String[] args) {
        int[] answer = solution(new int[][]{{1, 1, 1, 1, 1, 1, 1, 1}, {0, 1, 1, 1, 1, 1, 1, 1}, {0, 0, 0, 0, 1, 1, 1, 1}, {0, 1, 0, 0, 1, 1, 1, 1}, {0, 0, 0, 0, 0, 0, 1, 1}, {0, 0, 0, 0, 0, 0, 0, 1}, {0, 0, 0, 0, 1, 0, 0, 1}, {0, 0, 0, 0, 1, 1, 1, 1}});
        System.out.println(answer[0] + " " + answer[1]);
    }

    public static int[] solution(int[][] arr) {
        int[] answer = {0, 0};
        int n = arr.length;

        int num = arr[0][0];
        boolean flag = false;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] != num) {
                    flag = true;
                    break;
                }
            }
        }

        if (!flag) {
            answer[num]++;
            return answer;
        }

        Queue<int[][]> queue = new LinkedList<>();

        int[][] map1 = new int[n / 2][n / 2];
        int[][] map2 = new int[n / 2][n / 2];
        int[][] map3 = new int[n / 2][n / 2];
        int[][] map4 = new int[n / 2][n / 2];

        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < n / 2; j++) {
                map1[i][j] = arr[i][j];
                map2[i][j] = arr[i][n / 2 + j];
                map3[i][j] = arr[n / 2 + i][j];
                map4[i][j] = arr[n / 2 + i][n / 2 + j];
            }
        }

        queue.offer(map1);
        queue.offer(map2);
        queue.offer(map3);
        queue.offer(map4);


        while (!queue.isEmpty()) {
            int[][] map = queue.poll();
            int number = map[0][0];

            if (map.length == 1) {
                answer[number]++;
                continue;
            }

            flag = false;

            for (int i = 0; i < map.length; i++) {
                for (int j = 0; j < map.length; j++) {
                    if (map[i][j] != number) {
                        flag = true;
                        break;
                    }
                }
            }

            if (flag) {
                int length = map.length / 2;

                map1 = new int[length][length];
                map2 = new int[length][length];
                map3 = new int[length][length];
                map4 = new int[length][length];

                for (int k = 0; k < length; k++) {
                    for (int l = 0; l < length; l++) {
                        map1[k][l] = map[k][l];
                        map2[k][l] = map[k][length + l];
                        map3[k][l] = map[length + k][l];
                        map4[k][l] = map[length + k][length + l];
                    }
                }

                queue.offer(map1);
                queue.offer(map2);
                queue.offer(map3);
                queue.offer(map4);
            } else {
                answer[number]++;
            }
        }

        return answer;
    }
}
