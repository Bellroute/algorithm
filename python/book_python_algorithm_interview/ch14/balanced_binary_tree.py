# 리트코드 110. Balanced Binary Tree

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    # 내 풀이
    def isBalanced_mySolution(self, root: TreeNode) -> bool:
        def get_height(root):
            if not root:
                return 0

            return max(get_height(root.left), get_height(root.right)) + 1

        if not root:
            return True

        left = get_height(root.left)
        right = get_height(root.right)

        if abs(left - right) > 1:
            return False

        if self.isBalanced(root.left) and self.isBalanced(root.right):
            return True
        else:
            return False

    # 책 풀이. 재귀 구조로 높이 차이 계산
    def isBalanced(self, root: TreeNode) -> bool:
        def check(root):
            if not root:
                return 0

            left = check(root.left)
            right = check(root.right)
            # 높이 차이가 나는 경우 -1, 이외에는 높이에 따s라 1 증가
            if left == -1 or right == -1 or abs(left - right) > 1:
                return -1
            return max(left, right) + 1

        return check(root) != -1
