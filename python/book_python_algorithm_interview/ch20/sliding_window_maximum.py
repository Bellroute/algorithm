# 리트코드 239. Sliding Window Maximum

from typing import List
import collections


class Solution:
    # 풀이 1. 부르트 포스로 계산 -> 시간 초과
    def maxSlidingWindow_brouteforce(self, nums: List[int], k: int) -> List[int]:
        if not nums:
            return nums

        result = []
        for i in range(len(nums) - (k - 1)):
            result.append(max(nums[i:i + k]))

        return result

    # 풀이 2. 큐를 이용한 최적화 -> 시간 초과
    def maxSlidingWindow_queue(self, nums: List[int], k: int) -> List[int]:
        result = []
        window = collections.deque()
        current_max = float('-inf')
        for i, v in enumerate(nums):
            window.append(v)
            if i < k - 1:
                continue

            # 새로 추가된 값이 기존 최댓값보다 큰 경우 교체
            if current_max == float('-inf'):
                current_max = max(window)
            elif v > current_max:
                current_max = v

            result.append(current_max)

            # 최대값이 윈도우에서 빠지면 초기화
            if current_max == window.popleft():
                current_max = float('-inf')
        return result

    # 문제 테스트 케이스 변경으로 난이도가 올라가 책에서 제시하는 풀이는 시간 초과 발생

    # 풀이 3. deque를 이용한 풀이
    def maxSlidingWindow(self, nums: List[int], k: int) -> List[int]:
        result, deque = [], collections.deque()

        for i in range(len(nums)):
            # 슬라이드가 옮겨가서 기존 값을 제거해야하는 경우
            if deque and i - deque[0] == k:
                deque.popleft()

            # 현재 위치의 값이 deque에 마지막에 들어간 값과 비교해서 이보다 크면 큐의 오른쪽 값들을 지워 연산 갯수를 줄인다.
            while deque and nums[deque[-1]] <= nums[i]:
                deque.pop()

            deque.append(i)

            if i + 1 >= k:
                result.append(nums[deque[0]])

            return result
