# 프로그래머스 코딩 테스트 연습 > 해쉬 > 위장

import collections
import functools


def my_solution(clothes):
    list = []
    for cloth in clothes:
        list.append(cloth[1])

    result = 1
    dict = collections.Counter(list)
    for key in dict:
        result *= dict[key] + 1

    return result - 1


def solution(clothes):
    cnt = collections.Counter([kind for (name, kind) in clothes])
    answer = functools.reduce(lambda x, y: x * (y + 1), cnt.values(), 1) - 1
    return answer
