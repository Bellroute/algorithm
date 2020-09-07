package programmers.kakao.blindRecruitment2018;

import java.util.ArrayList;
import java.util.List;

public class Level2_Friends4Blocks {

    private int answer = 0;
    private char[][] map;
    private int m;
    private int n;
    private int[] x_move = {0, 1, 0, 1};
    private int[] y_move = {0, 0, 1, 1};

    public int solution(int m, int n, String[] board) {
        this.m = m;
        this.n = n;
        map = new char[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = board[i].charAt(j);
            }
        }

        while (true) {
            List<int[]> list = new ArrayList<>();

            for (int i = 0; i < m - 1; i++) {
                for (int j = 0; j < n - 1; j++) {
                    if (!isBlank(i, j) && is4Blocks(i, j)) {
                        list.add(new int[]{i, j});
                    }
                }
            }

            if (list.size() == 0) {
                break;
            }

            for (int[] point : list) {
                int x = point[0];
                int y = point[1];


                for (int k = 0; k < 4; k++) {
                    int newX = x + x_move[k];
                    int newY = y + y_move[k];

                    if (map[newX][newY] != '0') {
                        answer++;
                        map[newX][newY] = '0';
                    }
                }
            }

            updateMap();

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(map[i][j]);
                }
                System.out.println();
            }
            System.out.println();
        }

        return answer;
    }

    private void updateMap() {
        for (int i = 0; i < n; i++) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int j = 0; j < m; j++) {
                stringBuilder.append(map[j][i]);
            }

            String result = stringBuilder.toString().replace("0", "");

            int length = m - result.length();
            for (int j = 0; j < length; j++) {
                map[j][i] = '0';
            }

            for (int j = length; j < m; j++) {
                map[j][i] = result.charAt(j - length);
            }
        }
    }

    private boolean isBlank(int i, int j) {
        return map[i][j] == '0';
    }

    private boolean is4Blocks(int x, int y) {
        char block = map[x][y];

        for (int k = 1; k < 4; k++) {
            int newX = x + x_move[k];
            int newY = y + y_move[k];

            if (map[newX][newY] != block) {
                return false;
            }
        }

        return true;
    }


//    private static boolean[][] visited;
//
//    public static void main(String[] args) {
//        System.out.println(solution(4, 5, new String[]{"CCBDE", "AAADE", "AAABF", "CCBBF" }));
//    }
//
//    public static int solution(int m, int n, String[] board) {
//        int answer = 0;
//
//        char[][] map = new char[m][n];
//        visited = new boolean[m][n];
//
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                map[i][j] = board[i].charAt(j);
//            }
//        }
//
//        startGame(map);
//
//        for (int i = 0; i < visited.length; i++) {
//            for (int j = 0; j < visited[i].length; j++) {
//                if (map[i][j] == '0') {
//                    answer++;
//                }
//            }
//        }
//
//        return answer;
//    }
//
//    private static void startGame(char[][] map) {
//        boolean hasScore = false;
//
//        for (int i = 0; i < map.length; i++) {
//            for (int j = 0; j < map[i].length; j++) {
//                System.out.print(map[i][j]);
//            }
//            System.out.println();
//        }
//        System.out.println();
//
//        for (int i = 0; i < map.length; i++) {
//            for (int j = 0; j < map[i].length; j++) {
//                if (i + 1 < map.length && map[i][j] != '0' && j + 1 < map[i].length && map[i][j] == map[i + 1][j] && map[i][j] == map[i][j + 1] && map[i][j] == map[i + 1][j + 1]) {
//                    visited[i][j] = true;
//                    visited[i + 1][j] = true;
//                    visited[i][j + 1] = true;
//                    visited[i + 1][j + 1] = true;
//
//                    hasScore = true;
//                }
//            }
//        }
//
//        for (int i = 0; i < visited.length; i++) {
//            for (int j = 0; j < visited[i].length; j++) {
//                if (visited[i][j]) {
//                    map[i][j] = '0';
//                }
//            }
//        }
//
//        map = deleteBlanks(map);
//
//        if (hasScore) {
//            startGame(map);
//        }
//    }
//
//    private static char[][] deleteBlanks(char[][] map) {
//        for (int j = 0; j < map[0].length; j++) {
//            char[] column = new char[map.length];
//
//            for (int i = 0; i < map.length; i++) {
//                column[i] = map[i][j];
//            }
//
//            column = sortColumn(column);
//
//            for (int i = 0; i < map.length; i++) {
//                if (column[i] == '0') {
//                    visited[i][j] = true;
//                } else {
//                    visited[i][j] = false;
//                }
//
//                map[i][j] = column[i];
//            }
//        }
//
//        return map;
//    }
//
//    private static char[] sortColumn(char[] column) {
//        StringBuilder newColumn = new StringBuilder();
//
//        for (int i = 0; i < column.length; i++) {
//            if (column[i] == '0') {
//                newColumn.append(column[i]);
//            }
//        }
//
//        for (int i = 0; i < column.length; i++) {
//            if (column[i] != '0') {
//                newColumn.append(column[i]);
//            }
//        }
//
//        for (int i = 0; i < newColumn.length(); i++) {
//            column[i] = newColumn.toString().charAt(i);
//        }
//
//        return column;
//    }

}
