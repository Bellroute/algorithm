# 프로그래머스 코딩 테스트 연습 > 해쉬 > 베스트앨범


import collections
import heapq


def solution(genres, plays):
    answer = []
    sum = collections.defaultdict(int)
    for i, genre in enumerate(genres):
        sum[genre] += plays[i]

    heap = []
    for i, genre in enumerate(genres):
        heapq.heappush(heap, (-sum[genre], -plays[i], i))

    count = collections.defaultdict(int)
    while heap:
        index = heapq.heappop(heap)[2]

        if count[genres[index]] < 2:
            count[genres[index]] += 1
            answer.append(index)

    return answer
