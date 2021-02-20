# 프로그래머스 코딩테스트 연습 > Summer/Winter Coding(2019) > 멀쩡한 사각형

def get_gcd(x, y):
    if x < y:
        x, y = y, x

    if y == 0:
        return x

    return get_gcd(y, x % y)


def solution(w, h):
    answer = w * h
    gcd = get_gcd(w, h)
    answer -= (w + h - gcd)
    return answer
