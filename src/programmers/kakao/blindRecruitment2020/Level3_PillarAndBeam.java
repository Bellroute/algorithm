package programmers.kakao.blindRecruitment2020;

import java.util.ArrayList;
import java.util.List;

public class Level3_PillarAndBeam {

    private int n;
    private boolean[][] pillars;
    private boolean[][] beams;
    private static final int PILLAR = 0;
    private static final int BEAM = 1;
    private static final int DELETE = 0;
    private static final int INSERT = 1;

    public int[][] solution(int n, int[][] build_frame) {
        int[][] answer = {};
        this.n = n;

        pillars = new boolean[n + 4][n + 4];
        beams = new boolean[n + 4][n + 4];

        for (int i = 0; i < build_frame.length; i++) {
            int x = build_frame[i][0] + 2;
            int y = build_frame[i][1] + 2;
            int a = build_frame[i][2];
            int b = build_frame[i][3];

            if (b == INSERT) {
                if (a == PILLAR && isAbleToInsertPillar(x, y)) {
                    pillars[x][y] = true;
                }

                if (a == BEAM && isAbleToInsertBeam(x, y)) {
                    beams[x][y] = true;
                }

                continue;
            }

            if (b == DELETE) {
                tryDelete(x, y, a);
            }
        }

        List<int[]> result = new ArrayList<>();

        for (int i = 2; i <= n + 2; i++) {
            for (int j = 2; j <= n + 2; j++) {

                if (pillars[i][j]) {
                    result.add(new int[]{i - 2, j - 2, 0});
                }

                if (beams[i][j]) {
                    result.add(new int[]{i - 2, j - 2, 1});
                }
            }
        }

        result.sort((o1, o2) -> {
            if (o1[0] == o2[0]) {
                if (o1[1] == o2[1]) {

                    return o1[2] - o2[2];
                }

                return o1[1] - o2[1];
            }

            return o1[0] - o2[0];
        });

        answer = new int[result.size()][3];

        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }

        return answer;
    }

    private void tryDelete(int x, int y, int a) {
        if (a == PILLAR) {
            pillars[x][y] = false;
        } else {
            beams[x][y] = false;
        }

        if (isAbleToDelete()) {
            return;
        }

        if (a == PILLAR) {
            pillars[x][y] = true;
        } else {
            beams[x][y] = false;
        }
    }

    private boolean isAbleToDelete() {
        for (int i = 2; i <= n + 2; i++) {
            for (int j = 0; j <= n + 2; j++) {
                if (pillars[i][j] && !isAbleToInsertPillar(i, j)) {
                    return false;
                }

                if (beams[i][j] && !isAbleToInsertBeam(i, j)) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean isAbleToInsertBeam(int x, int y) {
        return pillars[x][y - 1] || pillars[x + 1][y - 1] || (beams[x - 1][y] && beams[x + 1][y]);
    }

    private boolean isAbleToInsertPillar(int x, int y) {
        return y == 2 || pillars[x][y - 1] || beams[x][y] || beams[x - 1][y];
    }

}
