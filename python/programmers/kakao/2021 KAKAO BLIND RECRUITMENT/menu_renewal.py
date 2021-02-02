# 2021 KAKAO BLIND RECRUITMENT > 메뉴 리뉴얼
import collections


def solution(orders, course):
    results = []

    def combine(target, elements, index, length):
        if len(elements) == length:
            table[elements] += 1
            return

        for i in range(index, len(target)):
            elements += target[i]
            combine(target, elements, i + 1, length)
            elements = elements[:len(elements) - 1]

    for c in course:
        table = collections.defaultdict(int)
        for order in orders:
            combine(sorted(order), '', 0, c)

        result = list(filter(lambda x: table[x] != 1 and table[x] == max(
            table.values()), table.keys()))

        while result:
            results.append(result.pop())

    results.sort()
    return results


print(solution(["ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"], [2, 3, 5]))
