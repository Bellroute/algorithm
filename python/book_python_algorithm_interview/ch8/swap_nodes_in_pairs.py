# 리트코드 24. Swap Nodes in Pairs


# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class Solution:
    # 풀이 1. 값만 교환
    def swapPairs_value(self, head: ListNode) -> ListNode:
        node = head
        while node and node.next:
            node.val, node.next.val = node.next.val, node.val
            node = node.next.next

        return head

    # 풀이 2. 반복 구조로 스왑
    def swapPairs_repeat(self, head: ListNode) -> ListNode:
        root = prev = ListNode()
        prev.next = head

        # prev - head - tail - tail.next => prev - tail - head - tail.next
        while head and head.next:
            # tail이 head를 가리키도록 할당
            tail = head.next
            head.next = tail.next
            tail.next = head

            # prev가 tail을 가리키도록 할당
            prev.next = tail

            # 다음번 비교를 위해 이동
            head = head.next  # 원래 tail.next로 이동
            prev = prev.next.next  # prev.next는 tail, prev.next.next는 head. 즉, head.next의 이전 노드로 이동

        return root.next

    # 풀이 3. 재귀 구조로 스왑
    # 반복 풀이와 달리 포인터 역할을 하는 변수가 하나만 있어도 충분함.
    # 더미 노드를 만들 필요가 없어 공간 복잡도가 낮음
    def swapPairs_recursive(self, head: ListNode) -> ListNode:
        if head and head.next:
            p = head.next
            # 스왑된 값 리턴 받음
            head.next = self.swapPairs_recursive(p.next)
            p.next = head
            return p
        return head
