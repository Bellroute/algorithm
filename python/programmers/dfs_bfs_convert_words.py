# 프로그래머스 코딩 테스트 연습 > 깊이/너비 우선 탐색(DFS/BFS) > 단어 변환

import collections


def solution(begin, target, words):
    queue = collections.deque()
    queue.append((begin, 0))
    words_deque = collections.deque(words)

    count = 100

    while queue:
        now = queue.popleft()

        if now[0] == target:
            count = min(count, now[1])
            continue

        for _ in range(len(words_deque)):
            word = words_deque.popleft()

            flag = 0
            for index in range(len(now[0])):
                if now[0][index] != word[index]:
                    flag += 1

            if flag == 1:
                queue.append((word, now[1] + 1))
            else:
                words_deque.append(word)

    if count == 100:
        return 0
    return count
