# 리트코드 297. Serialize and Deserialize Binary Tree

import collections

# Definition for a binary tree node.


class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Codec:

    # 내 풀이
    def serialize_mySolution(self, root):
        if not root:
            return ''

        queue = collections.deque([root])
        result = []

        # bfs 방식으로 왼쪽 노드 -> 오른쪽 노드 순으로 순회
        while queue:
            node = queue.popleft()

            if node:
                result.append(str(node.val))
                queue.append(node.left)
                queue.append(node.right)
            else:
                result.append('null')
        return ' '.join(result)

    def deserialize_mySolution(self, data):
        if len(data) == 0:
            return []

        data = data.split()
        for i, value in enumerate(data):
            data[i] = TreeNode(value)

        for i in range(1, len(data) + 1):
            # 왼쪽 자식 노드는 본인 인덱스 값 * 2
            if i * 2 <= len(data):
                data[i - 1].left = data[(i * 2) - 1]
            # 오른쪽 자식 노드는 본인 인덱스 값 * 2 + 1
            if i * 2 + 1 <= len(data):
                data[i - 1].right = data[(i * 2 + 1) - 1]

        return data[0]

    # 책 풀이
    # 역직렬화 시에 빠른 런너와 같은 방식으로 왼쪽, 오른쪽 자식 노드를 분리하여 처리하는 신박한 방법!
    def serialize(self, root: TreeNode) -> str:
        queue = collections.deque([root])
        result = ['#']
        # 트리 bfs 직렬화
        while queue:
            node = queue.popleft()
            if node:
                queue.append(node.left)
                queue.append(node.right)

                result.append(str(node.val))
            else:
                result.append('#')  # null 처리

        return ' '.join(result)

    def deserialize(self, data: str) -> TreeNode:
        # 예외 처리
        if data == '# #':
            return None

        nodes = data.split()

        root = TreeNode(int(nodes[1]))
        queue = collections.deque([root])
        index = 2

        # 빠른 런너처럼 자식 노드 결과를 먼저 확인 후 큐 삽입
        while queue:
            node = queue.popleft()
            # 왼쪽 자식 노드가 null이 아닌 경우
            if nodes[index] is not '#':
                node.left = TreeNode(int(nodes[index]))
                queue.append(node.left)
            index += 1

            # 오른쪽 자식 노드가 null이 아닌 경우
            if nodes[index] is not '#':
                node.right = TreeNode(int(nodes[index]))
                queue.append(node.right)
            index += 1

        return root


# Your Codec object will be instantiated and called as such:
# ser = Codec()
# deser = Codec()
# ans = deser.deserialize(ser.serialize(root))
