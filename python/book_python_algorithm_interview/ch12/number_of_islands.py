# 리트코드 200. Number Of Islands

from typing import List
import collections


class Solution:

    x_move = [1, 0, -1, 0]
    y_move = [0, 1, 0, -1]

    # 내 풀이. bfs를 이용하여 풀이하였음.
    def numIslands_mySolution(self, grid: List[List[str]]) -> int:
        m = len(grid)
        n = len(grid[0])
        visited = [[False for _ in range(n)] for _ in range(m)]
        result = 0

        for i in range(m):
            for j in range(n):
                if not visited[i][j] and grid[i][j] == "1":
                    result += 1
                    queue = collections.deque()
                    queue.append((i, j))
                    visited[i][j] = True

                    while queue:
                        now = queue.popleft()

                        for k in range(4):
                            x = now[0] + self.x_move[k]
                            y = now[1] + self.y_move[k]

                            if x < 0 or y < 0 or x >= m or y >= n:
                                continue

                            if not visited[x][y] and grid[x][y] == "1":
                                visited[x][y] = True
                                queue.append((x, y))

        return result

    # 책 풀이. dfs로 그래프 탐색
    def numIslands(self, grid: List[List[str]]) -> int:
        def dfs(i, j):
            # 더 이상 땅이 아닌 경우 종료
            if i < 0 or i >= len(grid) or \
                j < 0 or j >= len(grid[0]) or \
                    grid[i][j] != '1':
                return

            # 방문한 곳 처리.
            # 내 풀이처럼 방문 경로를 저장하는 visited 행렬을 추가하게 되면 공간 복잡도가 O(n)이 된다.
            # 현재의 행렬에 경로를 표시해두는 것으로도 충분하다.
            grid[i][j] = 0

            # 동서남묵 탐색
            dfs(i + 1, j)
            dfs(i - 1, j)
            dfs(i, j + 1)
            dfs(i, j - 1)

        count = 0
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] == '1':
                    dfs(i, j)
                    # 모든 육지 탐색 후 카운트 1 증가
                    count += 1

        return count
