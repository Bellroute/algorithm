package programmers.kakao.blindRecruitment2019;

public class BlockGame {

    private static int[][] map;
    private static int N;

    public static void main(String[] args) {
        int[][] board = {
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 4, 0, 0, 0},
                {0, 0, 0, 0, 0, 4, 4, 0, 0, 0},
                {0, 0, 0, 0, 3, 0, 4, 0, 0, 0},
                {0, 0, 0, 2, 3, 0, 0, 0, 5, 5},
                {1, 2, 2, 2, 3, 3, 0, 0, 0, 5},
                {1, 1, 1, 0, 0, 0, 0, 0, 0, 5}};

        System.out.println(solution(board));
    }

    public static int solution(int[][] board) {
        int answer = 0;
        map = board.clone();
        N = board.length;
        int cnt = -1;

        while (cnt != 0) {
            cnt = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (isIn3X2Area(i, j) && isAbleBlock(i, j, 3, 2)) {
                        cnt++;
                    } else if (isIn2X3Area(i, j) && isAbleBlock(i, j, 2, 3)) {
                        cnt++;
                    }
                }
            }

            answer += cnt;
        }

        return answer;
    }

    private static boolean isAbleBlock(int row, int col, int width, int height) {
        int blockNumber = -1;
        int count = 0;

        for (int i = 0; i < width; i++) {
            int x = row + i;
            for (int j = 0; j < height; j++) {
                int y = col + j;

                if (map[x][y] == 0) {
                    count++;

                    if (!isReachableToBlackBlock(x, y)) {
                        return false;
                    }

                    if (count > 2) {
                        return false;
                    }
                } else {

                    if (blockNumber != -1 && blockNumber != map[x][y]) {
                        return false;
                    }

                    blockNumber = map[x][y];
                }
            }
        }

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                map[row + i][col + j] = 0;
            }
        }

        return true;
    }

    private static boolean isReachableToBlackBlock(int x, int y) {

        for (int i = 0; i < x; i++) {
            if (map[i][y] != 0) {
                return false;
            }
        }

        return true;
    }

    private static boolean isIn3X2Area(int i, int j) {
        return i + 2 < N && j + 1 < N;
    }

    private static boolean isIn2X3Area(int i, int j) {
        return i + 1 < N && j + 2 < N;
    }
}
