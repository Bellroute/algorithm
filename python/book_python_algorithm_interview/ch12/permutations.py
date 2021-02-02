# 리트코드 46. Permutations

from typing import List
import itertools


class Solution:
    # 내 풀이. dfs를 이용함
    def permute_mySolution(self, nums: List[int]) -> List[List[int]]:
        result = []
        length = len(nums)
        visited = [False for _ in range(length)]

        def dfs(path):
            if len(path) == length:
                result.append(path[:])
                return

            for i, num in enumerate(nums):
                if visited[i]:
                    continue

                visited[i] = True
                path.append(num)
                dfs(path)
                visited[i] = False
                path.pop()

        dfs([])
        return result

    # 책 풀이 1. dfs를 활용한 순열 생성
    def permute_dfs(self, nums: List[int]) -> List[List[int]]:
        results = []
        prev_elements = []

        def dfs(elements):
            # 리프 노드일 때 결과 추가
            # 결과를 추가할 때 [:]로 처리해야한다.
            # 파이썬은 모든 객체를 참조하는 형태로 처리되므로 결과 값이 추가되는 게 아니라
            # 해당 변수에 대한 참조가 추가되며, 이 경우 참조된 값이 변경될 경우 같이 바뀌게 된다.
            # [:], copy(), deepcopy() 등으로 처리할 수 있다.
            if len(elements) == 0:
                results.append(prev_elements[:])

            # 순열 생성 재귀 호출
            for e in elements:
                next_elements = elements[:]
                next_elements.remove(e)

                prev_elements.append(e)
                dfs(next_elements)
                prev_elements.pop()

        dfs(nums)
        return results

        # 책 풀이 2. itertools 모듈 사용
        # itertools 모듈은 반복자 생성에 최적화된 효율적인 기능들을 제공하므로,
        # 실무에서는 알고리즘으로 직접 구현하기보다는 가능하면 이 모듈을 사용하는 편이 낫다.
        # 효율적으로 설계된 C 라이브러리이므로 속도면에서도 이점이 있다.
        # 알고리즘 테스트에서는 itertools 모듈을 제한하는 경우도 있다.
        # 테스트에서는 사용하지 않을 수 있지만, 실무에서는 사용하지 않을 이유가 없다.
        def permute_itertools(self, nums: List[int]) -> List[List[int]]:
            return list(itertools.permutations(nums))
