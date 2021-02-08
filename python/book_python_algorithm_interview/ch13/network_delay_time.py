# 리트코드 743. Network Delay Time

from typing import List
import collections
import heapq


class Solution:
    # 내 풀이 - 시간 초과
    def networkDelayTime_mySolution(self, times: List[List[int]], n: int, k: int) -> int:
        graph = collections.defaultdict(list)
        for u, v, w in times:
            graph[u].append((u, v, w))

        queue = collections.deque()
        weights = [101 for _ in range(n + 1)]

        for next in graph[k]:
            queue.append(next)
        weights[k] = 0

        while queue:
            now = queue.popleft()
            u = now[0]
            v = now[1]
            w = now[2]
            weights[v] = min(weights[v], weights[u] + w)

            for next in graph[v]:
                queue.append(next)

        if 101 in weights[1:]:
            return -1

        return max(weights[1:])

    # 첵 풀이. 다익스트라 알고리즘 구현
    def networkDelayTime(self, times: List[List[int]], n: int, k: int) -> int:
        graph = collections.defaultdict(list)
        # 그래프 인접 리스트 구성
        for u, v, w in times:
            graph[u].append((v, w))

        # 큐 변수: [(소요시간, 정점)]
        Q = [(0, k)]
        dist = collections.defaultdict(int)

        # 우선순위 큐 최솟값 기준으로 정점까지 최단 경로 삽입
        while Q:
            time, node = heapq.heappop(Q)
            if node not in dist:
                dist[node] = time
                for v, w in graph[node]:
                    alt = time + w
                    heapq.heappush(Q, (alt, v))

        # 모든 노드의 최단 경로 존재 여부 판별
        if len(dist) == n:
            return max(dist.values())
        return -1
