# 트리 순회
# 트리 순회란 그래프 순회의 한 형태로 트리 자료구조에서 각 노드를 정확히 한 번 방문하는 과정을 말한다.


class Node:
    def __init__(self, val, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


root = Node('F',
            Node('B',
                 Node('A'),
                 Node('D',
                      Node('C'), Node('E'))
                 ),
            Node('G',
                 None,
                 Node('I', Node('H'))
                 )
            )


# 전위 순회(Pre-Order)
# Now - Left - Right
def preorder(node):
    if node is None:
        return
    print(node.val)
    preorder(node.left)
    preorder(node.right)


# 중위 순회(In-Order)
# Left - Now - Right
def inorder(node):
    if node is None:
        return
    inorder(node.left)
    print(node.val)
    inorder(node.right)


# 후위 순회(Post-Order)
# Left - Right - Now
def postorder(node):
    if node is None:
        return
    postorder(node.left)
    postorder(node.right)
    print(node.val)
