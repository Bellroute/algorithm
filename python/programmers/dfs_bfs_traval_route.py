# 프로그래머스 코딩 테스트 연습 > 깊이/너비 우선 탐색(DFS/BFS) > 여행 경로

import collections

answer = []
flights = collections.defaultdict(list)


def solution(tickets):
    for ticket in sorted(tickets):
        flights[ticket[0]].append(ticket[1])

    dfs('ICN')

    return answer[::-1]


def dfs(now):
    while flights[now]:
        next = flights[now].pop(0)
        dfs(next)
    answer.append(now)
