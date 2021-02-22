# 리트코드 938. Range Sum of BST

import collections

# Definition for a binary tree node.


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    # 내 풀이. 재귀
    def rangeSumBST_mySolution(self, root: TreeNode, low: int, high: int) -> int:
        if not root:
            return 0

        sum = 0

        if root.val >= low and root.val <= high:
            sum += root.val
            sum += self.rangeSumBST_mySolution(root.left, low, high)
            sum += self.rangeSumBST_mySolution(root.right, low, high)
        elif root.val < low:
            sum += self.rangeSumBST_mySolution(root.right, low, high)
        elif root.val > high:
            sum += self.rangeSumBST_mySolution(root.left, low, high)

        return sum

    # 책 풀이 1. 재귀 구조 DFS로 브루트 포스 탐색
    def rangeSumBST_brouteforce(self, root: TreeNode, low: int, high: int) -> int:
        if not root:
            return 0

        return (root.val if low <= root.val <= high else 0) + self.rangeSumBST_brouteforce(root.left, low, high) + self.rangeSumBST_brouteforce(root.right, L, R)

    # 책 풀이 2. DFS 가지치기로 필요한 노드 탐색
    # 내 풀이와 가장 가까운 풀이 방법.
    def rangeSumBST_branchcut(self, root: TreeNode, low: int, high: int) -> int:
        def dfs(node: TreeNode):
            if not node:
                return 0

            if node.val < low:
                return dfs(node.right)
            elif node.val > high:
                return dfs(node.left)
            return node.val + dfs(node.left) + dfs(node.right)

        return dfs(root)

    # 책 풀이 3. 반복 구조 DFS로 필요한 노드 탐색
    # 대부분의 재귀 풀이는 반복으로 변경 가능하다.
    def rangeSumBST_repeat(self, root: TreeNode, low: int, high: int) -> int:
        stack, sum = [root], 0
        # 스택 이용 필요한 노드 DFS 반복
        while stack:
            node = stack.pop()
            if node:
                if node.val > low:
                    stack.append(node.left)
                if node.val < high:
                    stack.append(node.right)
                if low <= node.val <= high:
                    sum += node.val
        return sum

    # 책 풀이 4. 반복 구조 BFS로 필요한 노드 탐색
    # 책에서 간단히 구현하느라 리스트로 큐를 구현했지만 여기서는 성능을 높이기 위해 deque를 사용함.
    def rangeSumBST(self, root: TreeNode, low: int, high: int) -> int:
        queue, sum = collections.deque([root]), 0
        # 큐 연산을 이용해 반복 구조로 BFS로 필요한 노드 탐색
        while queue:
            node = queue.popleft()
            if node:
                if node.val > low:
                    queue.append(node.left)
                if node.val < high:
                    queue.append(node.right)
                if low <= node.val <= high:
                    sum += node.val
        return sum
