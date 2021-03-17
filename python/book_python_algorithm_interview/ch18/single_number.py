# 리트코드 136. Single Number

from typing import List
import collections


class Solution:
    # 풀이. XOR 풀이
    def singleNumber(self, nums: List[int]) -> int:
        result = 0
        for num in nums:
            result ^= num

        return result
