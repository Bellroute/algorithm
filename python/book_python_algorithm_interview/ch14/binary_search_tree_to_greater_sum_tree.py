# 리트코드 1038. Binary Search Tree to Greater Sum Tree

from typing import List

# Definition for a binary tree node.


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def bstToGst(self, root: TreeNode) -> TreeNode:
        if not root:
            return

        root.right = self.bstToGst(root.right)
        root.val += root.right.val
        root.left.val += root.val
        root.left = self.bstToGst(root.left)

        return root
