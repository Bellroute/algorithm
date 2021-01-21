# 프로그래머스 코딩 테스트 연습 > 스택/큐 > 기능개발

import math


def solution(progresses, speeds):
    answer = []

    for i, progress in enumerate(progresses):
        progresses[i] = math.ceil((100 - progress) / speeds[i])

    target = progresses[0]
    for progress in progresses:
        if answer and target >= progress:
            answer[-1] += 1
        else:
            target = progress
            answer.append(1)

    return answer
