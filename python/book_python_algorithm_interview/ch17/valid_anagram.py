# 리트코드 242. Valid Anagram

import collections


class Solution:
    # 딕셔너리를 이용한 방법
    def isAnagram_dict(self, s: str, t: str) -> bool:
        word = collections.defaultdict(int)
        for char in s:
            word[char] += 1

        for char in t:
            if word[char] == 0:
                return False
            word[char] -= 1

        for char in word:
            if word[char] != 0:
                return False

        return True

    # 책 풀이. 정렬을 이용한 비교
    def isAnagram(self, s: str, t: str) -> bool:
        return sorted(s) == sorted(t)
