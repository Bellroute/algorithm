# 리트코드 240. Search a 2D Matrix II

from typing import List


class Solution:
    # 내 풀이. 첫 열을 기준으로 타겟과 비교하여 이진 탐색으로 탐색이 유효한 크기로 줄인 뒤, 행마다 이진 탐색 진행
    # 첫 행부터 차례대로 완전 탐색을 하는 것과 비교했을 때 크게 효율적이진 않았음.
    def searchMatrix_mySolution(self, matrix: List[List[int]], target: int) -> bool:
        left, right = 0, len(matrix) - 1

        while left <= right:
            mid = left + (right - left) // 2
            if matrix[mid][0] < target:
                left = mid + 1
            elif matrix[mid][0] > target:
                right = mid - 1
            else:
                return True

        matrix = matrix[:left]
        for nums in matrix:
            left, right = 0, len(nums) - 1

            while left <= right:
                mid = left + (right - left) // 2
                if nums[mid] < target:
                    left = mid + 1
                elif nums[mid] > target:
                    right = mid - 1
                else:
                    return True

        return False

    # 책 풀이 1. 첫 행의 맨 뒤에서 탐색
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        # 예외 처리
        if not matrix:
            return False

        # 첫 행의 맨 뒤
        row = 0
        col = len(matrix[0]) - 1

        while row <= len(matrix) - 1 and col >= 0:
            if target == matrix[row][col]:
                return True
            # 타겟이 작으면 왼쪽으로 이동
            elif target < matrix[row][col]:
                col -= 1
            # 타겟이 크면 아래로 이동
            elif target > matrix[row][col]:
                row += 1
        return False

    # 책 풀이 2. 파이썬다운 방식
    def searchMatrix_python(self, matrix: List[List[int]], target: int) -> bool:
        return any(target in row for row in matrix)
