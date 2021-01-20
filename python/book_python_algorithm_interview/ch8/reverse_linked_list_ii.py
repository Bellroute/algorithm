# 리트코드 92. Reverse Linked List II

class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class Solution:
    # 내 풀이
    def reverseBetween_mySolution(self, head: ListNode, m: int, n: int) -> ListNode:
        root = start = ListNode()
        root.next = head

        for i in range(m - 1):
            start = start.next

        end = start.next

        node, prev = start.next, None
        for i in range(n - m + 1):
            next, node.next = node.next, prev
            node, prev = next, node

        start.next = prev
        end.next = node

        return root.next

    def reverseBetween(self, head: ListNode, m: int, n: int) -> ListNode:
        if not head or m == n:
            return head

        root = start = ListNode()
        root.next = head

        # start, end 지정
        for _ in range(m - 1):
            start = start.next
        end = start.next

        # 반복하면서 노드 차례대로 뒤집기
        for _ in range(n - m):
            tmp, start.next, end.next = start.next, end.next, end.next.next
            start.next.next = tmp

        return root.next
