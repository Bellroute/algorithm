# 리트코드 509. Fibonacci Number

import collections


class Solution:
    # 풀이 1. 재귀 구조 브루트 포스
    def fib_1(self, N: int) -> int:
        if N <= 1:
            return N
        return self.fib_1(N - 1) + self.fib_1(N - 2)

    # 풀이 2. 메모이제이션 (하향식 풀이)
    # 이미 계산한 값은 저장해뒀다가 바로 리턴
    dp = collections.defaultdict(int)

    def fib_2(self, N: int) -> int:
        if N <= 1:
            return N

        if self.dp[N]:
            return self.dp[N]
        self.dp[N] = self.fib_2(N - 1) + self.fib_2(N - 2)
        return self.dp[N]

    # 풀이 3. 타뷸레이션 (상향식 풀이)
    # 시간 복잡도 O(n), 공간복잡도 O(n)
    dp = collections.defaultdict(int)

    def fib_3(self, N: int) -> int:
        self.dp[1] = 1

        for i in range(2, N + 1):
            self.dp[i] = self.dp[i - 1] + self.dp[i - 2]
        return self.dp[N]

    # 풀이 4. 두 변수만 이용해 공간 절약
    # 시간 복잡도 O(n), 공간복잡도 O(1)
    def fib_4(self, N: int) -> int:
        x, y = 0, 1
        for i in range(0, N):
            x, y = y, x + y
        return x
