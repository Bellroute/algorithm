# 프로그래머스 코딩테스트 연습 > 그래프 > 가장 먼 노드

import heapq
import collections


def solution(n, edge):
    answer = 0
    graph = collections.defaultdict(list)
    for a, b in edge:
        graph[a].append(b)
        graph[b].append(a)

    dist = collections.defaultdict(int)
    Q = [(0, 1)]

    while Q:
        length, node = heapq.heappop(Q)

        if node not in dist:
            dist[node] = length + 1
            for next in graph[node]:
                heapq.heappush(Q, (dist[node], next))

    max_dist = max(dist.values())
    for i in dist:
        if dist[i] == max_dist:
            answer += 1

    return answer
