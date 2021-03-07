# 리트코드 973. K Closest Points to Origin

from typing import List
import heapq


class Solution:
    # 내 풀이. 파이썬 내장 함수를 이용한 정렬
    def kClosest_mySolution(self, points: List[List[int]], k: int) -> List[List[int]]:
        def get_length(x, y):
            return x * x + y * y

        result = []
        for point in points:
            result.append([get_length(point[0], point[1]), point])

        result.sort(key=lambda x: x[0])
        return list(map(lambda x: x[1], result))[:k]

    # 책 풀이. 유클리드 거리의 우선순위 큐 순서
    def kClosest(self, points: List[List[int]], k: int) -> List[List[int]]:
        heap = []
        for (x, y) in points:
            dist = x ** 2 + y ** 2
            heapq.heappush(heap, (dist, x, y))

        result = []
        for _ in range(k):
            (dist, x, y) = heapq.heappop(heap)
            result.append((x, y))
        return result


s = Solution()
print(s.kClosest([[3, 3], [5, -1], [-2, 4]], 2))
