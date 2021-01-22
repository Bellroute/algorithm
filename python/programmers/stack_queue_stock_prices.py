# 프로그래머스 코딩 테스트 연습 > 스택/큐 > 주식가격

def solution(prices):
    answer = [0] * len(prices)
    stack = []

    for i, price in enumerate(prices):
        while stack and price < prices[stack[-1]]:
            last = stack.pop()
            answer[last] = i - last
        stack.append(i)

    while stack:
        index = stack.pop()
        answer[index] = len(prices) - 1 - index

    return answer
