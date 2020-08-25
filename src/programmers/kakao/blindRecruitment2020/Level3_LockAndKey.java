package programmers.kakao.blindRecruitment2020;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Level3_LockAndKey {
    private int keyLength;
    private int lockLength;

    @Test
    public void test() {
        assertEquals(true, solution(new int[][]{{0, 0, 0}, {1, 0, 0}, {0, 1, 1}}, new int[][]{{1, 1, 1}, {1, 1, 0}, {1, 0, 1}}));
    }

    public boolean solution(int[][] key, int[][] lock) {
        keyLength = key.length;
        lockLength = lock.length;

        int[][] paddingLock = getPadding(lock);
        int[][] spinKey = spin(key);

        for (int i = 0; i < 4; i++) {
            for (int x = 0; x < paddingLock.length - (keyLength - 1); x++) {
                for (int y = 0; y < paddingLock.length - (keyLength - 1); y++) {
                    paddingLock = getPadding(lock);

                    for (int k = 0; k < keyLength; k++) {
                        for (int l = 0; l < keyLength; l++) {
                            paddingLock[x + k][y + l] += spinKey[k][l];
                        }
                    }

                    if (isMatched(paddingLock)) {
                        return true;
                    }
                }
            }

            spinKey = spin(spinKey);
        }

        return false;
    }

    private int[][] getPadding(int[][] lock) {
        int paddingLength = lockLength + 2 * (keyLength - 1);
        int[][] paddingLock = new int[paddingLength][paddingLength];

        for (int i = 0; i < lockLength; i++) {
            for (int j = 0; j < lockLength; j++) {
                paddingLock[keyLength - 1 + i][keyLength - 1 + j] = lock[i][j];
            }
        }

        return paddingLock;
    }

    private int[][] spin(int[][] key) {
        int n = key.length;
        int[][] spinKey = new int[n][n];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                spinKey[n - i - 1][j] = key[j][i];
            }
        }


        return spinKey;
    }

    private boolean isMatched(int[][] lock) {
        for (int i = keyLength - 1; i < lockLength + (keyLength - 1); i++) {
            for (int j = keyLength - 1; j < lockLength + (keyLength - 1); j++) {
                if (lock[i][j] != 1) {
                    return false;
                }
            }
        }

        return true;
    }
}
