# 리트코드 347. Top K Frequent Elements

from typing import List
import collections
import heapq


class Solution:
    # 내 풀이
    def topKFrequent_mySolution(self, nums: List[int], k: int) -> List[int]:
        answer = []
        freqs = collections.Counter(nums)

        heap = []
        for num in freqs.keys():
            heapq.heappush(heap, (freqs[num], num))

        while heap:
            answer.append(heapq.heappop(heap)[1])

        return answer[::-1][:k]

    # 풀이 1. Counter를 이용한 음수 순 추출
    # 내 풀이와 동일한 방법이지만, 큐에 넣을 때 음수로 넣기 때문에 내림차순으로 정렬하는 과정이 필요없어졌다.
    def topKFrequent_counter(self, nums: List[int], k: int) -> List[int]:
        freqs = collections.Counter(nums)
        freqs_heap = []
        # 힙에 음수로 삽입
        for f in freqs:
            heapq.heappush(freqs_heap, (-freqs[f], f))

        topk = list()
        # k번 만큼 추출, 최소 힙(Min Heap)으로 가장 작은 음수 순으로 추출

        for _ in range(k):
            topk.append(heapq.heappop(freqs_heap)[1])

        return topk

    # 풀이 2. 파이썬 다운 방식
    # Counter에는 most_common() 이라는 빈도 수가 높은 순서대로 아이템을 추출하는 기능을 제공한다.
    # zip() 함수는 2개 이상의 시퀀스를 짧은 길이를 기준으로 일대일 대응하는 새로운 튜플 시퀀스를 만드는 역할을 한다.
    # 아스테리스크(*)는 시퀀스 언패킹 연산자로 말 그대로 시퀀스를 풀어 해치는 연산자를 뜻하며, 주로 튜플이나 리스트를 언패킹하는 데 사용하낟.
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        return list(zip(*collections.Counter(nums).most_common(k)))[0]
