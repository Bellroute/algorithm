package beckjoon;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BaekJoon2580 {
    private static final int SUDOKU_SIZE = 9;
    private static List<Point> targets;
    private static int[][] sudoku = new int[SUDOKU_SIZE][SUDOKU_SIZE];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        targets = new ArrayList<>();

        for (int i = 0; i < SUDOKU_SIZE; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < SUDOKU_SIZE; j++) {
                sudoku[i][j] = Integer.parseInt(input[j]);

                if (sudoku[i][j] == 0) {
                    targets.add(new Point(i, j));
                }
            }

        }

        findAnswer(0);
    }

    private static void findAnswer(int count) throws IOException {
        if (count == targets.size()) {
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            for (int i = 0; i < SUDOKU_SIZE; i++) {
                StringBuilder output = new StringBuilder();

                for (int j = 0; j < SUDOKU_SIZE; j++) {
                    output.append(sudoku[i][j]).append(" ");
                }

                bw.write(output.toString().trim() + "\n");
            }

            bw.flush();
            bw.close();
            System.exit(0);
        }

        for (int j = 1; j <= 9; j++) {
            int row = targets.get(count).x;
            int column = targets.get(count).y;

            if (isAbleInRow(j, row) && isAbleInColumn(j, column) && isAbleInCircle(j, row, column)) {
                sudoku[row][column] = j;
                findAnswer(count + 1);
                sudoku[row][column] = 0;
            }
        }
    }

    private static boolean isAbleInRow(int number, int row) {
        for (int i = 0; i < SUDOKU_SIZE; i++) {
            if (number == sudoku[row][i]) return false;
        }

        return true;
    }

    private static boolean isAbleInColumn(int number, int column) {
        for (int i = 0; i < SUDOKU_SIZE; i++) {
            if (number == sudoku[i][column]) return false;
        }

        return true;
    }

    private static boolean isAbleInCircle(int number, int row, int column) {
        int x_start = getStartSpot(row);
        int y_start = getStartSpot(column);

        for (int i = x_start; i < x_start + 3; i++) {
            for (int j = y_start; j < y_start + 3; j++) {
                if (number == sudoku[i][j]) return false;
            }
        }

        return true;
    }

    private static int getStartSpot(int number) {
        int spot = 0;

        switch (number / 3) {
            case 0:
                spot = 0;
                break;
            case 1:
                spot = 3;
                break;
            case 2:
                spot = 6;
                break;
        }

        return spot;
    }


    static class Point {
        private int x;
        private int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }
}
