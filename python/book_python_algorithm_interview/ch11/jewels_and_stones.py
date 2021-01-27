# 리트코드 771. Jewels and Stones

import collections


class Solution:
    # 풀이 1. defaultdict를 이용한 비교 생략
    def numJewelsInStones_defaultdict(self, jewels: str, stones: str) -> int:
        table = collections.defaultdict(int)

        for stone in stones:
            table[stone] += 1

        result = 0
        for jewel in jewels:
            result += table[jewel]

        return result

    # 풀이 2. Counter로 계산 생략
    def numJewelsInStones_counter(self, jewels: str, stones: str) -> int:
        freqs = collections.Counter(stones)
        count = 0

        for jewel in jewels:
            count += freqs[jewel]

        return count

    # 풀이 3. 파이썬다운 방식
    def numJewelsInStones(self, jewels: str, stones: str) -> int:
        return sum(stone in jewels for stone in stones)
