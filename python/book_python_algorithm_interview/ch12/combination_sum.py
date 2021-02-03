# 리트코드 39. Combination Sum

from typing import List


class Solution:
    # 내 풀이. dfs를 이용
    def combinationSum_mySolution(self, candidates: List[int], target: int) -> List[List[int]]:
        result = []

        def dfs(elements, index):
            if sum(elements) == target:
                result.append(elements[:])
                return

            if sum(elements) > target:
                return

            for i in range(index, len(candidates)):
                elements.append(candidates[i])
                dfs(elements, i)
                elements.pop()

        dfs([], 0)
        return result

    # 책 풀이. DFS로 중복 조합 그래프 탐색
    # 직접 푼 방식과 유사하지만 dfs메소드의 파라미터로 csum을 넘기면 sum()메소드가 돌아가는 메모리를 절약할 수 있는 것 같다!
    # 또 path + [candidates[i]] 방식으로 하면 elements를 append, pop()하는 연산도 절약되는 듯 하다.
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        result = []

        def dfs(csum, index, path):
            # 종료 조건
            if csum < 0:
                return
            if csum == 0:
                result.append(path)
                return

            # 자신부터 하위 원소까지의 나열 재귀 호출
            for i in range(index, len(candidates)):
                dfs(csum - candidates[i], i, path + [candidates[i]])

        dfs(target, 0, [])
        return result


s = Solution()
print(s.combinationSum([2, 3, 5], 8))
