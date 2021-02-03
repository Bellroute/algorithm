# 리트코드 332. Reconstruct Itierary

from typing import List
import collections


class Solution:
    # 풀이 1. DFS로 일정 그래프 구성
    def findItinerary_dfs(self, tickets: List[List[str]]) -> List[str]:
        result = []
        flights = collections.defaultdict(list)

        # 그래프를 순서대로 구성
        # for a, b in tickets:
        #     flights[a].append(b)
        # for a in flights:
        #     flights[a].sort()
        for a, b in sorted(tickets):
            flights[a].append(b)

        def dfs(path):
            # 첫 번째 값을 읽어 어휘 순으로 방문
            while flights[path]:
                dfs(flights[path].pop(0))
            result.append(path)

        dfs('JFK')
        # 다시 뒤집어서 어휘 순 결과로
        return result[::-1]

    # 풀이 2. 스택 연산으로 큐 연산 최적화 시도
    # pop(0) 연산은 리스트의 첫 번째 원소를 빼내고 뒤의 원소들을 앞으로 당기는 연산을 수행하기 때문에 비효율적
    # 애초에 그래프를 역순으로 정렬하여 pop() 메소드를 이용하는 방식으로 구현할 수 있다.
    def findItinerary_stack(self, tickets: List[List[str]]) -> List[str]:
        flights = collections.defaultdict(list)
        # 그래프를 뒤집어서 구성
        for a, b in sorted(tickets, reverse=True):
            flights[a].append(b)

        result = []

        def dfs(path):
            # 마지막 값을 읽어 어휘 순 방문
            while flights[path]:
                dfs(flights[path].pop())
            result.append(path)

        dfs('JFK')
        # 다시 뒤집어서 어휘 순 결과로
        return result[::-1]

    # 풀이 3. 일정 그래프 반복
    # 재귀가 아닌 동일한 구조를 반복으로 풀이 가능하다.
    def findItinerary_repeat(self, tickets: List[List[str]]) -> List[str]:
        flights = collections.defaultdict(list)
        # 그래프를 뒤집어서 구성
        for a, b in sorted(tickets):
            flights[a].append(b)

        result, stack = [], ['JFK']
        while stack:
            # 반복으로 스택을 구성하되 막히는 부분에서 풀어내는 처리
            while flights[stack[-1]]:
                stack.append(flights[stack[-1]].pop(0))
            result.append(stack.pop())

        # 다시 뒤집어 어휘 순 결과로
        return result[::-1]
