# 리트코드 704. Binary Search

from typing import List
import bisect


class Solution:
    # 내 풀이 == 책 풀이 2. 반복 풀이
    def search_mySolution(self, nums: List[int], target: int) -> int:
        left, right = 0, len(nums) - 1

        while left <= right:
            mid = (left + right) // 2

            if nums[mid] < target:
                left = mid + 1
            elif nums[mid] > target:
                right = mid - 1
            else:
                return mid

        return -1

    # 책 풀이 1. 재귀 풀이
    def search_recursive(self, nums: List[int], target: int) -> int:
        def binary_search(left, right):
            if left <= right:
                mid = (left + right) // 2

                if nums[mid] < target:
                    return binary_search(mid + 1, right)
                elif nums[mid] > target:
                    return binary_search(left, mid - 1)
                else:
                    return mid
            else:
                return -1

        return binary_search(0, len(nums) - 1)

    # 책 풀이 3. 이진 검색 모듈
    def search(self, nums: List[int], target: int) -> int:
        index = bisect.bisect_left(nums, target)

        if index < len(nums) and nums[index] == target:
            return index
        else:
            return -1

    # 책 풀이 4. 이진 검색을 사용하지 않는 index 풀이
    # 존재하지 않는 값인 경우 에러가 발생하므로, ValueError를 예외 처리한다.
    def search_without_binary_search(self, nums: List[int], target: int) -> int:
        try:
            return nums.index(target)
        except ValueError:
            return -1
