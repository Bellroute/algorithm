# 프로그래머스 코딩 테스트 연습 > 깊이/너비 우선 탐색(DFS/BFS) > 타겟 넘버

answer = 0


def solution(numbers, target):

    def dfs(index, total):
        if index == len(numbers):
            if total == target:
                global answer
                answer += 1
            return

        dfs(index + 1, total + numbers[index])
        dfs(index + 1, total - numbers[index])

    dfs(0, 0)
    return answer
