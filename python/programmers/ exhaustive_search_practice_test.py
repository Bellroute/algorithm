# 프로그래머스 코딩 테스트 연습 > 완전 탐색 > 모의고사

import collections


def solution(answers):
    result = []
    supos = collections.defaultdict(list)
    supo1 = [1, 2, 3, 4, 5]
    supo2 = [2, 1, 2, 3, 2, 4, 2, 5]
    supo3 = [3, 3, 1, 1, 2, 2, 4, 4, 5, 5]

    supos[1] = supo1
    supos[2] = supo2
    supos[3] = supo3

    max = 0

    for i in supos:
        supo = supos[i]
        count = 0
        for j, answer in enumerate(answers):
            if answer == supo[j % len(supo)]:
                count += 1

        if max < count:
            max = count
            result = [i]
        elif max == count:
            result.append(i)

    return result
