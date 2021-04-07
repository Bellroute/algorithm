# 리트코드 241. Different Ways to Add Parentheses

from typing import List


class Solution:
    # 풀이. 분할 정복을 이용한 다양한 조합
    def diffWaysToCompute(self, expression: str) -> List[int]:
        def compute(left, right, op):
            results = []
            for l in left:
                for r in right:
                    results.append(eval(str(l) + op + str(r)))
            return results

        if expression.isdigit():
            return [int(expression)]

        results = []
        for i, value in enumerate(expression):
            if value in '+-*':
                left = self.diffWaysToCompute(expression[:i])
                right = self.diffWaysToCompute(expression[i + 1:])

                results.extend(compute(left, right, value))
        return results
