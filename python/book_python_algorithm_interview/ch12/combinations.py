# 리트코드 77. Combinations

from typing import List
import itertools


class Solution:
    def combine(self, n: int, k: int) -> List[List[int]]:
        results = []

        def dfs(elements, index, count):
            if count == k:
                results.append(elements[:])
                return

            for i in range(index, n + 1):
                elements.append(i)
                dfs(elements, i + 1, count + 1)
                elements.pop()

        dfs([], 1, 0)

        return results

    def combine_itertools(self, n: int, k: int) -> List[List[int]]:
        return list(itertools.combinations(range(1, n + 1), k))
