# 리트코드 29. Valid Parentheses
class Solution:
    # 내 풀이
    def isValid_mySolution(self, s: str) -> bool:
        if len(s) == 1:
            return False

        stack = []
        table = {
            '(': ')',
            '{': '}',
            '[': ']'
        }

        for i in range(len(s)):
            if s[i] in table:
                stack.append(s[i])
            else:
                if not stack:
                    return False

                pop = stack.pop()
                if table[pop] != s[i]:
                    return False

        if stack:
            return False

        return True

    def isValid(self, s: str) -> bool:
        stack = []
        table = {
            ')': '(',
            '}': '{',
            ']': '['
        }

        # 스택 이용 예외 처리 및 일치 여부 판별
        for char in s:
            if char not in table:
                stack.append(char)
            elif not stack or table[char] != stack.pop():
                return False

        return len(stack) == 0


s = Solution()
print(s.isValid("()[]{}"))
