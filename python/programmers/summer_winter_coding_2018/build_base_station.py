# 코딩테스트 연습 > Summer/Winter Coding(~2018) > 기지국 설치

import math


def solution(n, stations, w):
    answer = 0
    range = w + w + 1

    now = 1
    for station in stations:
        length = station - w - now
        if length > 0:
            answer += math.ceil(length / range)
        now = station + w + 1

    if n >= now:
        answer += math.ceil((n - now + 1) / range)

    return answer
