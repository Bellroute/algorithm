# 프로그래머스 코딩 테스트 연습 > 힙 > 디스크 컨트롤러

import heapq


def solution(jobs):
    answer, count, last = 0, 0, -1
    heap = []

    jobs.sort()

    time = jobs[0][0]

    while count < len(jobs):
        for s, t in jobs:
            if last < s <= time:
                heapq.heappush(heap, (t, s))

        if len(heap) > 0:
            count += 1
            last = time
            term, start = heapq.heappop(heap)
            time += term
            answer += time - start
        else:
            time += 1
    return answer // len(jobs)
