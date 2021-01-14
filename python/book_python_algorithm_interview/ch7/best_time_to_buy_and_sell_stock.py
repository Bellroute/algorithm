# 리트코드 121. Best Time to Buy and Sell Stock

from typing import List
import sys


class Solution:
    # 풀이 1. 부르트 포스로 계산 -> 타임아웃 O(n^2)
    def maxProfit_brouteforce(self, prices: List[int]) -> int:
        profit = 0

        for (i, price) in enumerate(prices):
            for j in range(i + 1, len(prices)):
                profit = max(profit, prices[j] - price)

        return profit

    # 풀이 2. 저점과 현재 값과의 차이 계산
    # 현재 값을 가리키는 포인터가 우측으로 이동하면서 이전 상태의 저점을 기준으로 가격 차이 계산
    # 만약 클 경우 최댓값을 계속 교체해 나감 - O(n)
    def maxProfit_lowPoint(self, prices: List[int]) -> int:
        profit = 0
        min_price = sys.maxsize  # None으로 초기값을 잡아두게 되면 비교 시 TypeError 발생할 수 있음

        for price in prices:
            min_price = min(min_price, price)
            profit = max(profit, price - min_price)

        return profit

    # 내 풀이
    def maxProfit(self, prices: List[int]) -> int:
        profit = 0
        low = [0, prices[0]]

        for (i, price) in enumerate(prices):
            if low[1] > price:
                low[0] = i
                low[1] = price

        for i in range(low[0] + 1, len(prices)):
            profit = max(profit, prices[i] - low[1])

        return profit


s = Solution()
print(s.maxProfit([7, 1, 5, 3, 6, 4]))
