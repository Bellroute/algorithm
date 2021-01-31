# 리트코드 17. Letter Combinations of a Phone Number

from typing import List


class Solution:
    # 내 풀이. dfs를 이용하여 풀었음
    def letterCombinations_mySolution(self, digits: str) -> List[str]:
        graph = {
            '2': ['a', 'b', 'c'],
            '3': ['d', 'e', 'f'],
            '4': ['g', 'h', 'i'],
            '5': ['j', 'k', 'l'],
            '6': ['m', 'n', 'o'],
            '7': ['p', 'q', 'r', 's'],
            '8': ['t', 'u', 'v'],
            '9': ['w', 'x', 'y', 'z']
        }

        def dfs(index, letters):
            if index == len(digits):
                result.append(letters)
                return

            phone_number = graph[digits[index]]
            for i in range(len(phone_number)):
                dfs(index + 1, letters + phone_number[i])

        result = []

        if digits == "":
            return result

        dfs(0, '')

        return result

    # 책 풀이. 모든 조합 탐색
    # 전체적인 풀이 흐름은 내 풀이와 동일.
    # 단, 딕셔너리 형태를 굳이 리스트로 할 필요 없이 'abc', 'def' 처럼 문자열로 두는 것도 좋은 방법인 듯하다.
    def letterCombinations(self, digits: str) -> List[str]:
        def dfs(index, path):
            # 끝까지 탐색하면 백트래킹
            if len(path) == len(digits):
                result.append(path)
                return

            # 입력값 자리수 단위 반복
            for i in range(index, len(digits)):
                # 숫자에 해당하는 모든 문자열 반복
                for j in dic[digits[i]]:
                    dfs(i + 1, path + j)

        # 예외 처리
        if not digits:
            return []

        dic = {"2": "abc", "3": "def", "4": "ghi", "5": "jkl",
               "6": "mno", "7": "pqrs", "8": "tuv", "9": "wxyz"}
        result = []
        dfs(0, "")

        return result
