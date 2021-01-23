# 리트코드 225. Implement Stack using Queues

import collections


class MyStack:

    # 하나의 큐를 이용하여 스택 구현
    def __init__(self):
        self.q = collections.deque()

    def push(self, x: int) -> None:
        self.q.append(x)
        # 요소 삽입 후 맨 앞에 두는 상태로 재정렬
        for _ in range(len(self.q) - 1):
            self.q.append(self.q.popleft())

    def pop(self) -> int:
        return self.q.popleft()

    def top(self) -> int:
        return self.q[0]

    def empty(self) -> bool:
        return len(self.q) == 0

    # 두 개의 큐를 이용해서 스택을 구현하는 방법
    # def __init__(self):
    #     self.first_queue = []
    #     self.second_queue = []

    # def push(self, x: int) -> None:
    #     while self.first_queue:
    #         self.second_queue.append(self.first_queue.pop(0))
    #     self.first_queue.append(x)

    # def pop(self) -> int:
    #     x = self.first_queue.pop(0)
    #     self.first_queue, self.second_queue = self.second_queue, self.first_queue
    #     while len(self.first_queue) > 1:
    #         self.second_queue.append(self.first_queue.pop(0))
    #     return x

    # def top(self) -> int:
    #     return self.first_queue[0]

    # def empty(self) -> bool:
    #     return not self.first_queue and not self.second_queue
