# # 2021 KAKAO BLIND RECRUITMENT > 합승 택시 요금
from collections import defaultdict
import heapq


def solution(n, s, a, b, fares):
    def dijkstra(graph, start):
        distances = {node: float('inf') for node in graph}
        distances[start] = 0

        queue = []
        heapq.heappush(queue, [distances[start], start])

        while queue:
            current_distance, current_destination = heapq.heappop(queue)

            if distances[current_destination] < current_distance:
                continue

            for new_destination, new_distance in graph[current_destination].items():
                distance = current_distance + new_distance

                if distance < distances[new_destination]:
                    distances[new_destination] = distance
                    heapq.heappush(queue, [distance, new_destination])

        return distances

    answer = float('inf')
    graph = defaultdict(dict)

    for c, d, f in fares:
        graph[c][d] = f
        graph[d][c] = f

    dijkstra_a = dijkstra(graph, a)
    dijkstra_b = dijkstra(graph, b)
    dijkstra_s = dijkstra(graph, s)

    for i in graph:
        answer = min(answer, dijkstra_a[i] + dijkstra_b[i] + dijkstra_s[i])

    return answer
