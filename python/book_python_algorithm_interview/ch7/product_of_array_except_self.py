# 리트코드 238. Product of Array Except Self

from typing import List


class Solution:
    # 풀이. 왼쪽 곱셈 결과에 오른쪽 값을 차례대로 곱셈
    # 문제 제약 상 나눗셈을 사용할 수 없게되어 있음
    # 현재 index의 왼쪽 원소들의 곱과 오른쪽 원소들의 곱을 구해 두 값을 곱하는 방법으로 구현해야함
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        output = []
        p = 1
        # 왼쪽 곱셈
        for i in range(len(nums)):
            output.append(p)
            p = p * nums[i]

        p = 1
        # 왼쪽 곱셈 결과에 오른쪽 값을 차례대로 곱셈
        for i in range(len(nums) - 1, 0 - 1, -1):  # nums를 거꾸로 탐색
            output[i] = output[i] * p  # 메모리 공간 절약을 위에 output에 바로 곱하여 값을 저장
            p = p * nums[i]

        return output
