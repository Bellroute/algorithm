# 리트코드 167. Two wum II - Input array is sorted

from typing import List
import bisect


class Solution:
    # 풀이 1. 투 포인터
    # 시간 복잡도 O(n)
    def twoSum_two_pointer(self, numbers: List[int], target: int) -> List[int]:
        left, right = 0, len(numbers) - 1
        while not left == right:
            if numbers[left] + numbers[right] < target:
                left += 1
            elif numbers[left] + numbers[right] > target:
                right -= 1
            else:
                return left + 1, right + 1

    # 풀이 2. 이진 검색
    # 시간 복잡도 O(nlogn)
    def twoSum_binary_search(self, numbers: List[int], target: int) -> List[int]:
        for i, num in enumerate(numbers):
            left, right = i + 1, len(numbers) - 1
            expected = target - num
            # 이진 검색으로 나머지 값 판별
            while left <= right:
                mid = left + (right - left) // 2
                if numbers[mid] < expected:
                    left = mid + 1
                elif numbers[mid] > expected:
                    right = mid - 1
                else:
                    return i + 1, mid + 1

    # 풀이 3. bisect 모듈 + 슬라이싱
    # bisect 모듈을 사용해서 코드가 간결해졌지만 20배 이상 느려졌음
    # 슬라이싱을 과도하게 사용한 탓인 것 같다.
    def twoSum_bisect(self, numbers: List[int], target: int) -> List[int]:
        for i, num in enumerate(numbers):
            expected = target - num
            index = bisect.bisect_left(numbers[i + 1:], expected)
            if index < len(numbers[i + 1:]) and numbers[index + i + 1] == expected:
                return i + 1, index + i + 2

    # 풀이 4. bisect 모듈 + 슬라이싱 최소화
    # 슬라이싱을 최소화하여 풀이3에 비해 2배 빨라졌다.
    # 그러나 여전히 투포인터에 비해는 느리다.
    def twoSum_bisect_slicing_optimize(self, numbers: List[int], target: int) -> List[int]:
        for i, num in enumerate(numbers):
            expected = target - num
            nums = numbers[i + 1:]
            index = bisect.bisect_left(nums, expected)
            if index < len(nums) and numbers[index + i + 1] == expected:
                return i + 1, index + i + 2

    # 풀이 5. bisect 모듈 + 슬라이싱 제거
    # bisect 모듈의 기능을 더 활용해보자.
    # bisect.bisect_left(a, x, lo=0, hi=len(a)) -> 영역을 제한하는 lo, hi 파라미터를 이용
    def twoSum(self, numbers: List[int], target: int) -> List[int]:
        for i, num in enumerate(numbers):
            expected = target - num
            index = bisect.bisect_left(numbers, expected, i + 1)
            if index < len(numbers) and numbers[index] == expected:
                return i + 1, index + 1
