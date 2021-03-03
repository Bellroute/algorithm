# 리트코드 148. Sort List

from typing import List

# Definition for singly-linked list.


class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class Solution:
    # 풀이 1. 병합 정렬
    # 분할 정복을 위해서는 중앙을 분할해야 한다.
    # 그러나 연결 리스트는 전체 길이를 알 수 없기 때문에 런너(Runner) 기법을 활용한다.

    # 두 정렬 리스트 병합
    def mergeTwoLists(self, l1: ListNode, l2: ListNode) -> ListNode:
        if l1 and l2:
            if l1.val > l2.val:
                l1, l2 = l2, l1
            l1.next = self.mergeTwoLists(l1.next, l2)

        return l1 or l2

    def sortList_mergesort(self, head: ListNode) -> ListNode:
        if not (head and head.next):
            return head

        # 런너 기법 활용
        # slow는 한 칸씩, fast는 두 칸씩 앞으로 이동
        # fast가 끝에 도달했을 때 slow는 중앙에 도착했을 것임
        half, slow, fast = None, head, head
        while fast and fast.next:
            half, slow, fast = slow, slow.next, fast.next.next
        half.next = None

        # 분할 재귀 호출
        l1 = self.sortList_mergesort(head)
        l2 = self.sortList_mergesort(slow)

        return self.mergeTwoLists(l1, l2)

    # 풀이 2. 퀵 정렬
    # 로무토 파티션 등의 일반적인 퀵 정렬 알고리즘으로 구현하면, 타임아웃 발생

    # 풀이 3. 내장 함수를 이용하는 실용적인 방법
    # 파이썬에서 제공하는 sort(), sorted() 함수는 팀소트를 사용하여 효율적인 정렬 알고리즘을 제공한다.

    def sortList(self, head: ListNode) -> ListNode:
        # 연결 리스트 -> 파이썬 리스트
        p = head
        lst: List = []
        while p:
            lst.append(p.val)
            p = p.next

        # 정렬
        lst.sort()

        # 파이썬 리스트 -> 연결 리스트
        p = head
        for i in range(len(lst)):
            p.val = lst[i]
            p = p.next
        return head
