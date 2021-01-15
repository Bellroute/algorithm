# 리트코드 234. Palindrome Linked List

from typing import List, Deque
import collections

# Definition for singly-linked list.


class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class Solution:
    # 풀이 1. 리스트 변환
    def isPalindrome_list(self, head: ListNode) -> bool:
        q: List = []

        if not head:
            return True

        node = head
        # 리스트로 변환
        while node is not None:
            q.append(node.val)
            node = node.next

        # 팰린드롬 판별
        while len(q) > 1:
            if q.pop(0) != q.pop():  # 첫번째 값을 꺼내오면 모든 값이 한 칸씩 shifting되며, 시간 복잡도 O(n)이 발생
                return False

        return True

    # 풀이 2. 데크를 이용한 최적화
    def isPalindrome_deque(self, head: ListNode) -> bool:
        q: Deque = collections.deque()

        if not head:
            return True

        node = head
        # 리스트로 변환
        while node is not None:
            q.append(node.val)
            node = node.next

        # 팰린드롬 판별
        while len(q) > 1:
            if q.popleft() != q.pop():  # 첫번째 값을 꺼내오면 모든 값이 한 칸씩 shifting되며, 시간 복잡도 O(n)이 발생
                return False

        return True

    # 풀이 4. 런너를 이용한 우아한 풀이
    # 런너(Runner)는 연결 리스트를 순회할 때 2개의 포인터를 동시에 사용하는 기법
    # 한 포인터가 다른 포인터보다 앞서게 하여 병합 지점이나 중간 위치, 길이 등을 판별할 때 유용하게 사용 됨
    # 빠른 런너는 두 칸씩, 느린 런너는 한 칸씩 이동하면 빠른 런너가 끝에 도달하면 느린 런너는 연결 리스트의 중간 지점을 가리키게 됨
    def isPalindrome_runner(self, head: ListNode) -> bool:
        rev = None
        slow = fast = head
        # 런너를 이용해 역순 연결 리스트 구성
        while fast and fast.next:
            fast = fast.next.next
            # 다중 할당. 가독성을 위해 분기하면 rev와 slow가 같은 객체를 참조하게 됨
            rev, rev.next, slow = slow, rev, slow.next
        if fast:
            slow = slow.next

        # 팰린드롬 여부 확인
        while rev and rev.val == slow.val:
            slow, rev = slow.next, rev.next
        return not rev  # rev가 slow와 일치하면 rev == None 이 됨을 이용해 bool 값을 리턴
