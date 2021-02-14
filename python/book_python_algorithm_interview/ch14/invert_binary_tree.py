# 리트코드 226. Invert Binary Tree

import collections

# Definition for a binary tree node.


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    # 내 풀이. dfs 이용
    def invertTree_mySolution(self, root: TreeNode) -> TreeNode:
        def dfs(node):
            if not node:
                return

            left = dfs(node.left)
            right = dfs(node.right)

            node.left = right
            node.right = left

            return node

        return dfs(root)

    # 책 풀이 1. 파이썬다운 방식
    def invertTree_python(self, root: TreeNode) -> TreeNode:
        if root:
            root.left, root.right = self.invertTree_python(
                root.right), self.invertTree_python(root.left)
            return root
        # return None (파이썬은 생략 가능)

    # 책 풀이 2. 반복 구조로 BFS
    # 앞서 재귀 풀이가 가장 말단 노드까지 내려가서 백트래킹하면서 스왑하는 상향 방식 풀이라면 (Bottom-Up)
    # 이 풀이는 부모 노드부터 스왑하면서 계속 아래로 내려가는 하향 방식 풀이다. (Top-Down)
    def invertTree_bfs(self, root: TreeNode) -> TreeNode:
        queue = collections.deque([root])

        while queue:
            node = queue.popleft()
            # 부모 노드로부터 하향식 스왑
            if node:
                node.left, node.right = node.right, node.left

                queue.append(node.left)
                queue.append(node.right)

        return root

    # 책 풀이 3. 반복 구조로 DFS
    def invertTree_dfs(self, root: TreeNode) -> TreeNode:
        stack = collections.deque([root])

        while stack:
            node = stack.pop()
            # 부모 노드부터 하향식 스왑
            if node:
                node.left, node.right = node.right, node.left

                stack.append(node.left)
                stack.append(node.right)
        return root

    # 책 풀이 4. 반복 구조로 DFS 후위 순회
    def invertTree(self, root: TreeNode) -> TreeNode:
        stack = collections.deque([root])

        while stack:
            node = stack.pop()

            if node:
                stack.append(node.left)
                stack.append(node.right)

                node.left, node.right = node.right, node.left

        return root
