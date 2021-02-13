# 리트코드 543. Diameter of Binary Tree

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    longest: int = 0
    # 책 풀이. 상태값 누적 트리 DFS
    # 가장 말단 노드까지 탐색한 다음 부모로 거슬러 올라가면서 각각의 거리를 계산해 상태값을 업데이트하면서 누적해 나간다.
    # 상태값은 리프 노드에서 현재 노드까지 거리다.
    # 왼쪽 자식 노드-현재 노드 상태값과 오른쪽 자식노드-현재 노드 상태값을 비교해 큰 값에 1을 더한 값이 현재 노드의 상태값이 된다.
    # 최종 거리는 longest에 저장한다.
    # 거리는 왼쪽 자식 노드에서 현재 노드까지의 거리와 오른쪽 자식 노드의 리프 노드에서 현재 노드까지의 거리의 합에 2를 더한 값이다.
    # 2를 더하는 이유는 말단 노드 밑에 가상의 노드 값을 -1로 두어서 말단 노드의 좌, 우 자식 노드 상태값의 합이 -2이가 되기 때문에 0으로 만들어주기 위함.
    # 상태값과 거리를 조금 구분할 필요가 있는 듯 하다.
    # 거리는 현재 노드가 root라고 할 때 좌,우 자식 노드를 모두 방문한 결과의 거리이고,
    # 상태값은 리프 노드에서부터 현재 노드까지 오는데 최대 몇 레벨을 거쳐서 왔는지에 대한 값인듯하다.
    # 즉, 왼쪽 자식 노드의 상태값과 오른쪽 자식 노드의 상태값을 합한 값에 +2한 값이 현재 노드가 root이면 걸리는 최종 최장 길이가 된다.

    def diameterOfBinaryTree(self, root: TreeNode) -> int:
        def dfs(node):
            if not node:
                return -1
            # 왼쪽, 오른쪽의 각 리프 노드까지 탐색
            left = dfs(node.left)
            right = dfs(node.right)

            # 가장 긴 경로
            self.longest = max(self.longest, left + right + 2)
            # 상태값
            return max(left, right) + 1

        dfs(root)
        return self.longest
