# 리트코드 641. Design Circular Deque

class ListNode:
    def __init__(self, val=None, prev=None, next=None):
        self.val = val
        self.prev = prev
        self.next = next


class MyCircularDeque:

    def __init__(self, k: int):
        self.max = k
        self.len = 0
        self.head = ListNode(None)
        self.tail = ListNode(None)
        self.head.next, self.tail.prev = self.tail, self.head

    def insertFront(self, value: int) -> bool:
        if self.len == self.max:
            return False
        self.len += 1
        self._add(self.head, ListNode(value))
        return True

    def insertLast(self, value: int) -> bool:
        if self.len == self.max:
            return False
        self.len += 1
        self._add(self.tail.prev, ListNode(value))
        return True

    def deleteFront(self) -> bool:
        if self.len == 0:
            return False
        self.len -= 1
        self._del(self.head)
        return True

    def deleteLast(self) -> bool:
        if self.len == 0:
            return False
        self.len -= 1
        self._del(self.tail.prev.prev)
        return True

    def getFront(self) -> int:
        return self.head.next.val if self.len else -1

    def getRear(self) -> int:
        return self.tail.prev.val if self.len else -1

    def isEmpty(self) -> bool:
        return self.len == 0

    def isFull(self) -> bool:
        return self.len == self.max

    def _add(self, node: ListNode, new: ListNode):
        n = node.next
        node.next = new
        new.prev, new.next = node, n
        n.prev = new

    def _del(self, node: ListNode):
        n = node.next.next
        node.next = n
        n.prev = node
