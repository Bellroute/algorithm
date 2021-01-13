# 리트코드 561. Array Partition I

from typing import List


class Solution:
    # 풀이 1.오름차순 풀이
    def arrayPairSum_ascendingOrder(self, nums: List[int]) -> int:
        sum = 0
        pair = []
        nums.sort()

        for n in nums:
            # 앞에서부터 오름차순으로 페이를 만들어서 합 계산
            pair.append(n)
            if len(pair) == 2:
                sum += min(pair)
                pair = []

        return sum

    # 풀이 2.짝수 번째 값 계산
    def arrayPairSum_evenIndex(self, nums: List[int]) -> int:
        sum = 0
        nums.sort()

        for i, n in enumerate(nums):  # for문의 step을 2로 두어 짝수만 돌게 해도 될듯
            # 짝수 번째 값의 합 계산
            if i % 2 == 0:
                sum += n

        return sum

    # 풀이 3.파이썬다운 방식
    def arrayPairSum(self, nums: List[int]) -> int:
        return sum(sorted(nums)[::2])  # [::2]는 짝수 번째만 슬라이싱
