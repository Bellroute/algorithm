# 프로그래머스 코딩 테스트 연습 > 그래프 > 순위

# 플로이드-와샬 알고리즘
# 그래프에서 모든 정점 사이의 최단 거리를 구하기 위한 알고리즘
# 음수 가중치에 대한 처리가 어려운 다익스트라 알고리즘에 비해 플로이드 와샬 알고리즘은 사이클이 없는 경우 음수 가중치 처리가 가능
def solution(n, results):
    wins = {x: set() for x in range(1, n + 1)}
    loses = {x: set() for x in range(1, n + 1)}

    for A, B in results:
        wins[A].add(B)
        loses[B].add(A)

    for i in range(1, n + 1):
        for winner in loses[i]:
            wins[winner].update(wins[i])
        for loser in wins[i]:
            loses[loser].update(loses[i])

    answer = 0
    for i in range(1, n + 1):
        if len(wins[i]) + len(loses[i]) == n - 1:
            answer += 1

    return answer
