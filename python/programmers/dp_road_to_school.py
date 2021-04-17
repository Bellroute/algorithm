# 코딩테스트 연습 > 동적계획법(Dynamic Programming) > 등굣길

def solution(m, n, puddles):
    map = [[0 for _ in range(m)] for _ in range(n)]
    map[0][0] = 1

    for y, x in puddles:
        map[x - 1][y - 1] = -1

    for i in range(n):
        for j in range(m):
            if map[i][j] == -1:
                map[i][j] = 0
                continue

            if i > 0:
                map[i][j] += map[i - 1][j] % 1000000007
            if j > 0:
                map[i][j] += map[i][j - 1] % 1000000007

    return map[n - 1][m - 1] % 1000000007
