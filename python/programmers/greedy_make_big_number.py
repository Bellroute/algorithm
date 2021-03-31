# 프로그래머스 코딩테스트 연습 >탐욕법(Greedy) > 큰 수 만들기

def solution(number, k):
    collected = []
    for i, num in enumerate(number):
        while collected and collected[-1] < num and k > 0:
            collected.pop()
            k -= 1

        if k == 0:
            collected += number[i:]
            break

        collected.append(num)

    collected = collected[:-k] if k > 0 else collected
    answer = ''.join(collected)
    return answer
