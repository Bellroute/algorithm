# 리트코드 23. Merge k Sorted Lists

from typing import List
import heapq

# Definition for singly-linked list.


class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class Solution:
    def mergeKLists(self, lists: List[ListNode]) -> ListNode:
        root = result = ListNode(None)
        heap = []

        # 각 연결 리스트의 루트를 힙에 저장
        for i in range(len(lists)):
            if lists[i]:
                # heap 리스트 요소를 (lists[i].val, i, lists[i])로 저장함. 이 때 lists[i].val와 i는 비교 기준인듯 하다.
                heapq.heappush(heap, (lists[i].val, i, lists[i]))

        # 힙 추출 이후 다음 노드는 다시 저장
        while heap:
            node = heapq.heappop(heap)
            idx = node[1]
            result.next = node[2]

            result = result.next
            if result.next:
                heapq.heappush(heap, (result.next.val, idx, result.next))

        return root.next

        # heap에 들어갈 때 lists[i].val을 기준으로 정렬하고 값이 같으면 인덱스가 빠른 순으로 정렬한다.
        # lists = [[1,4,5],[1,3,4],[2,6]]인 경우
        # heap에는 1-4-5, 1-3-4, 2-6 순으로 정렬된다.
        # heapq.heappop(heap)을 하면 1-4-5를 꺼낸다.
        # result.next에 pop한 값을 붙이면 result = None-1-4-5 가 된다.
        # result = result.next 하게 되면, result = 1-4-5 가 된다.
        # result.next가 존재하니 이를 다시 우선순위 큐인 heap에 집어넣어 재정렬한다.
        # heap에는 result.next가 들어가니 4-5만 들어간다
        # 따라서 이번 heap에는 1-3-4, 2-6, 4-5로 정렬된다.
        # 위를 반복하게 되면
        # heap은
        # 2-6, 3-4, 4-5
        # 3-4, 4-5, 6
        # 4-5, 4, 6
        # 4, 4, 6
        # 4, 6
        # 6
        # 순으로 작은 수부터 차례대로 빠져나가면서 result에 쌓이게 된다.
