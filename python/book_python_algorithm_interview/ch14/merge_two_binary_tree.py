# 리트코드 617. Merge Two Binary Trees

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    # 내 풀이. 재귀로 풀이
    def mergeTrees_mySolution(self, root1: TreeNode, root2: TreeNode) -> TreeNode:
        if not root1 and not root2:
            return
        if not root1:
            root1 = TreeNode()
        if not root2:
            root2 = TreeNode()

        root = TreeNode(root1.val + root2.val, self.mergeTrees_mySolution(root1.left,
                                                                          root2.left), self.mergeTrees_mySolution(root1.right, root2.right))
        return root

    # 책 풀이. 재귀 탐색
    def mergeTrees_recursive(self, root1: TreeNode, root2: TreeNode) -> TreeNode:
        if root1 and root2:
            node = TreeNode(root1.val + root2.val)
            node.left = self.mergeTrees_recursive(root1.left, root2.left)
            node.right = self.mergeTrees_recursive(root1.right, root2.right)

            return node
        else:
            # 내 풀이에서 조건문으로 분기하는 부분이 어색했는데 이렇게 처리하면 되는 거였음.
            # 어느 한 쪽에 노드가 존재하지 않으면 둘 중 존재하는 노드만 리턴.
            # 둘 다 없으면 None 리턴됨
            return root1 or root2

    # 책 풀이 2.
