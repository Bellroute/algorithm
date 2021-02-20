# 리트코드 108. Convert Sorted Array to Binary Search Tree

from typing import List

# Definition for a binary tree node.


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    # 내 풀이
    def sortedArrayToBST_mySolution(self, nums: List[int]) -> TreeNode:
        def dfs(left, right):
            if left > right:
                return

            mid = (left + right) / 2
            node = TreeNode(nums[mid])

            node.left = dfs(left, mid - 1)
            node.right = dfs(mid + 1, right)

            return node

        left = 0
        right = len(nums) - 1

        root = dfs(left, right)
        return root

    # 책 풀이. 정렬된 배열의 이진 탐색 트리 변환
    def sortedArrayToBST(self, nums: List[int]) -> TreeNode:
        if not nums:
            return None

        mid = len(nums) // 2

        # 분할 정복으로 이진 검색 결과 트리 구성
        node = TreeNode(nums[mid])
        node.left = self.sortedArrayToBST(nums[:mid])
        node.right = self.sortedArrayToBST(nums[mid + 1:])

        return node
