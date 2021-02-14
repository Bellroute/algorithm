# 리트코드 687. Longest Univalue Path

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    # 내 풀이
    # 리트코트 543 문제의 응용 버전 문제
    # 기본적인 로직은 동일하지만 조건을 하나 더 추가해야함
    # 자식 노드와 현재 노드의 val이 동일하지 않으면, 현재 노드가 단말 노드와 같이 취급해서 현재 노드부터 다시 길이를 체크하도록 한다.
    # 자식 노드와 현재 노드의 val이 동일하지 않으면 단말 노드 때와 같이 -1을 리턴한다.
    longest: int = 0

    def longestUnivaluePath_mySolution(self, root: TreeNode) -> int:
        def dfs(node):
            if not node:
                return -1

            left = dfs(node.left)
            right = dfs(node.right)

            if node.left and node.left.val != node.val:
                left = -1
            if node.right and node.right.val != node.val:
                right = -1

            self.longest = max(self.longest, left + right + 2)
            return max(left, right) + 1

        dfs(root)
        return self.longest

    # 책 풀이. 상태값 거리 계산 DFS
    result: int = 0

    def longestUnivaluePath(self, root: TreeNode) -> int:
        def dfs(node: TreeNode):
            if node is None:
                return 0

            # 존재하지 않는 노드까지 DFS 재귀 탐색
            left = dfs(node.left)
            right = dfs(node.right)

            # 현재 노드가 자식 노드와 동일한 경우 거리 1 증가
            if node.left and node.left.val == node.val:
                left += 1
            else:
                left = 0

            if node.right and node.right.val == node.val:
                right += 1
            else:
                right = 0

            # 왼쪽과 오른쪽 자식 노드 간 거리의 합 최댓값이 결과
            self.result = max(self.result, left + right)
            # 자식 노드 상태값 중 큰 값 리턴
            return max(left, right)

        dfs(root)
        return self.result
