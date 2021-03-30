# 리트코드 406. Queue Reconstruction by Height

from typing import List
import heapq


class Solution:
    # 풀이. 우선순위 큐 이용
    def reconstructQueue(self, people: List[List[int]]) -> List[List[int]]:
        queue = []
        # 키 역순, 인덱스 삽입
        for person in people:
            heapq.heappush(queue, [-person[0], person[1]])

        result = []
        # 키 역순, 인덱스 추출
        while queue:
            person = heapq.heappop(queue)
            result.insert(person[1], [-person[0], person[1]])

        return result
