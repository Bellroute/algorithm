package toss;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q6 {

    private static int row;
    private static int column;
    private static int[][] map;
    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, 1, -1};
    private static int result = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String[] rows = input.split(";");


        row = rows.length;
        column = rows[0].split(" ").length;

        map = new int[row][column];

        for (int i = 0; i < row; i++) {
            String[] elements = rows[i].split(" ");

            for (int j = 0; j < column; j++) {
                map[i][j] = Integer.parseInt(elements[j]);
            }
        }

        search();

        System.out.println(result);
    }

    private static void search() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (map[i][j] == 0) {
                    for (int k = 0; k < 4; k++) {
                        int new_x = i + dx[k];
                        int new_y = j + dy[k];

                        if (isAbleArea(new_x, new_y)) {

                            if (map[new_x][new_y] == 1) {
                                result++;
                            }
                        }
                    }
                }
            }
        }
    }

    private static boolean isAbleArea(int x, int y) {
        return x >= 0 && x < row && y >= 0 && y < column;
    }
}
