# 리트코드 56. Merge Intervals

from typing import List
import heapq


class Solution:
    # 내 풀이. 우선순위 큐를 이용하여 첫번째 인덱스 기준으로 정렬 뒤 앞 인터벌의 끝나는 시간과 뒤 인터벌의 시작 시간을 비교하여 병합
    def merge_mySolution(self, intervals: List[List[int]]) -> List[List[int]]:
        queue = []
        for interval in intervals:
            heapq.heappush(queue, interval)

        result = []
        while queue:
            now = heapq.heappop(queue)

            if len(result) == 0:
                result.append(now)
                continue

            before = result[-1]
            if before[1] >= now[0]:
                result[-1] = [before[0], max(before[1], now[1])]
            else:
                result.append(now)

        return result

    # 책 풀이. 정렬하여 병합
    def merge(self, intervals: List[List[int]]) -> List[List[int]]:
        merged = []
        for i in sorted(intervals, key=lambda x: x[0]):
            if merged and i[0] <= merged[-1][1]:
                merged[-1][1] = max(merged[-1][1], i[1])
            else:
                merged += i,  # 콤마는 중첩 리스트로 만들어주는 역할 merged += [i] 와 동일한 역할
        return merged
