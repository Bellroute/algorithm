# 리트코드 215. Kth Largest Element in an Array

from typing import List
import heapq


class Solution:
    # 풀이 1. heqpq 모듈 이용
    def findKthLargest_heapq(self, nums: List[int], k: int) -> int:
        heap = []
        for num in nums:
            heapq.heappush(heap, -num)

        for _ in range(k):
            result = heapq.heappop(heap)

        return -result

    # 풀이 2. heapq 모듈의 heapify 이용
    # 모든 값을 꺼내서 push하지 않고도 한 번에 heapify()하여 처리할 수 있음.
    def findKthLargest_heapify(self, nums: List[int], k: int) -> int:
        heapq.heapify(nums)

        for _ in range(len(nums) - k):
            heapq.heappop(nums)

        return heapq.heappop(nums)

    # 풀이 3. heapq 모듈의 nlargest 이용
    # nlargest는 k번째만큼 큰 값이 가장 큰 값부터 순서대로 리스트로 리턴된다.
    # nsmallest()를 사용하면 동일한 방식으로 n번ㅉ재 작은 값도 추출 가능
    def findKthLargest_nlargest(self, nums: List[int], k: int) -> int:
        return heapq.nlargest(k, nums)[-1]

    # 풀이 4. 정렬을 이용한 풀이
    # 위 방식들과 실행 속도에 큰 차이가 없으나 파이썬의 정렬 함수는 팀소트를 사용하며 C로 정교하게 구현되어있기 때문에 가장 빠르다.
    def findKthLargest(self, nums: List[int], k: int) -> int:
        nums.sort()
        return nums[-k]
