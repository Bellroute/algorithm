# 리트코드 316. Remove Duplicate Letters

import collections


class Solution:
    # 풀이 1. 재귀를 이용한 분리
    def removeDuplicateLetters_recursive(self, s: str) -> str:
        for char in sorted(set(s)):
            suffix = s[s.index(char):]

            if set(s) == set(suffix):
                return char + self.removeDuplicateLetters(suffix.replace(char, ''))
        return ''

    # 풀이 2. 스택을 이용한 문자 제거
    def removeDuplicateLetters(self, s: str) -> str:
        counter, seen, stack = collections.Counter(s), set(), []

        for char in s:
            counter[char] -= 1
            if char in seen:
                continue
            # 뒤에 붙일 문자가 남아 있다면 스택에서 제거
            while stack and char < stack[-1] and counter[stack[-1]] > 0:
                seen.remove(stack.pop())
            stack.append(char)
            seen.add(char)

        return ''.join(stack)
