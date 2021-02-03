# 리트코드 78. Subsets

from typing import List


class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        result = []
        length = len(nums)

        def dfs(path, index):
            result.append(path[:])

            for i in range(index, length):
                dfs(path + [nums[i]], i + 1)

        dfs([], 0)
        return result
