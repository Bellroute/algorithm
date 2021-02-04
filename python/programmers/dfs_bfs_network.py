# 프로그래머스 코딩 테스트 연습 > 깊이/너비 우선 탐색(DFS/BFS) > 네트워크

import collections

answer = 0
networks = []


def solution(n, computers):
    global networks
    networks = computers
    for i in range(n):
        if (networks[i][i] == 1):
            global answer
            answer += 1
            networks[i][i] = 0
            dfs(i)

    return answer


def dfs(now):
    networks[now][now] == 0

    for i, value in enumerate(networks[now]):
        if value == 1:
            networks[now][i] = 0
            dfs(i)
