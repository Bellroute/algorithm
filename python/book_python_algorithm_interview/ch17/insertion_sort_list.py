# 리트코드 147. Insertion Sort List

# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class Solution:
    # 풀이 1. 삽입 정렬
    # 정렬해야 할 대상과 정렬을 끝난 대상, 두 그룹으로 나눠 진행한다.
    # head는 정렬할 대상, cur는 정렬을 끝낸 대상, parent는 루트를 가리키는 역할을 한다.
    def insertionSortList(self, head: ListNode) -> ListNode:
        cur = parent = ListNode(None)
        while head:
            while cur.next and cur.next.val < head.val:
                cur = cur.next

            cur.next, head.next, head = head, cur.next, head.next

            cur = parent
        return cur.next

    # 풀이 2. 삽입 정렬의 비교 조건 개선
    # 풀이 1은 제대로 된 삽입 정렬이 아님.
    # 삽입정렬은 큰 쪽에서 작은 쪽으로 내려가며 스왑됨.
    # 이 문제의 경우 연결 리스트이기 때문에 이전 노드로 거슬러 올라갈 수 없음
    # cur = parent 를 통해 다음 번 head를 비교할 때 처음으로 되돌아 간다.
    # 만약 다음번 head도 cur보다 작은 상태라면 굳이 처음으로 되돌아 가지 않아도 되지 않을까?
    # cur가 head보다 클 때만 처음으로 되돌아가도록 하면 비교 횟수를 줄일 수 있다.
    def insertionSortList_upgrade(self, head: ListNode) -> ListNode:
        # cur.val을 비교할 때 None 타입이면 에러가 발생하므로, 초기값을 0으로 수정
        cur = parent = ListNode(0)
        while head:
            while cur.next and cur.next.val < head.val:
                cur = cur.next

            cur.next, head.next, head = head, cur.next, head.next

            # 필요한 경우에만 cur 포인터가 되돌아가도록 처리
            if head and cur.val > head.val:
                cur = parent
        return cur.next
