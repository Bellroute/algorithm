# 리트코드 310. Minimum Height Trees

from typing import List
import collections
import sys


class Solution:
    # 내 풀이 - 시간초과
    def findMinHeightTrees_mySolution(self, n: int, edges: List[List[int]]) -> List[int]:
        if len(edges) == 0:
            return [0]

        if len(edges) == 1:
            return edges[0]

        graph = collections.defaultdict(list)

        for a, b in edges:
            graph[a].append(b)
            graph[b].append(a)

        candidates = []
        for edge in graph:
            if len(graph[edge]) == 1:
                continue
            candidates.append(edge)

        if len(candidates) == 1:
            return candidates

        min_height = sys.maxsize + 1
        visited = [False for _ in range(n)]
        result = []

        def dfs(count, root):
            if len(graph[root]) == 1:
                return count

            max_length = count

            for edge in graph[root]:
                if visited[edge]:
                    continue
                visited[edge] = True
                max_length = max(max_length, dfs(count + 1, edge))
                visited[edge] = False

            return max_length

        for root in candidates:
            visited[root] = True
            count = dfs(0, root)

            if count < min_height:
                result = [root]
                min_height = count
            elif count == min_height:
                result.append(root)
            visited[root] = False

        return result

    # 책 풀이. 단계별 리프 노드 제거
    # 내 풀이에서는 리프노드만을 걸러낸 뒤 dfs 탐색을 통해 최소 높이를 찾아다녔다.
    # 여기서는 리프 노드를 제거한 트리에서 다시 리프 노드를 걸러내 마지막까지 남아있는 노드들을 답으로 리턴한다.
    def findMinHeightTrees(self, n: int, edges: List[List[int]]) -> List[int]:
        if n <= 1:
            return [0]

        # 양방향 그래프 구성
        graph = collections.defaultdict(list)
        for i, j in edges:
            graph[i].append(j)
            graph[j].append(i)

        # 첫 번째 리프 노드 추가
        leaves = []
        for i in range(n + 1):
            if len(graph[i]) == 1:
                leaves.append(i)

        # 루트 노드만 남을 때까지 반복 제거
        while n > 2:
            n -= len(leaves)
            new_leaves = []
            for leaf in leaves:
                neighbor = graph[leaf].pop()
                graph[neighbor].remove(leaf)

                if len(graph[neighbor]) == 1:
                    new_leaves.append(neighbor)

            leaves = new_leaves

        return leaves
