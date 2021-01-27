# 리트코드 706. Design HashMap
# 충돌은 개별 체이닝 방식으로 해결한다.

import collections


class MyHashMap:

    # 초기화
    def __init__(self):
        self.size = 1000
        self.table = collections.defaultdict(ListNode)

    # 삽입
    def put(self, key: int, value: int) -> None:
        index = key % self.size

        # 해당 인덱스에 아무것도 없는 경우
        if self.table[index].value is None:
            self.table[index] = ListNode(key, value)
            return

        # 해당 인덱스에 노드가 존재하는 경우
        node = self.table[index]
        while node:
            # key 값이 이미 있는 경우 업데이트 해줌
            if node.key == key:
                node.value = value
                return
            # 연결 리스트에 끝까지 도달한 경우 == 처음 들어오는 key인 경우
            if node.next is None:
                break
            node = node.next

        # 연결 리스트의 마지막에 노드를 추가한다.
        node.next = ListNode(key, value)

    # 조회
    def get(self, key: int) -> int:
        index = key % self.size
        if self.table[index].value is None:
            return -1
        # 노드가 존재할 때 일치하는 키 탐색
        node = self.table[index]
        while node:
            if node.key == key:
                return node.value
            node = node.next
        return -1

    # 삭제
    def remove(self, key: int) -> None:
        index = key % self.size
        if self.table[index].value is None:
            return -1

        # 삭제할 대상이 인덱스의 첫 번째 노드일 경우
        node = self.table[index]
        if node.key == key:
            self.table[index] = ListNode() if node.next is None else node.next
            return
        # 삭제할 대상이 인덱스의 중간 노드일 경우
        prev = node
        while node:
            if node.key == key:
                prev.next = node.next
                return
            prev, node = node, node.next


class ListNode:
    def __init__(self, key=None, value=None):
        self.key = key
        self.value = value
        self.next = None
