# 리트코드 3. Longets Substring Without Repeating Characters

import collections


class Solution:
    def lengthOfLongestSubstring_mySolution(self, s: str) -> int:
        left = 0
        right = 0
        maximum = 0

        while right <= len(s):
            str = s[left:right]
            counter = collections.Counter(str)

            for i in counter.values():
                if i >= 2:
                    left += 1
                    break

            maximum = max(maximum, right - left)
            right += 1

        return maximum

    def lengthOfLongestSubstring(self, s: str) -> int:
        used = {}
        max_length = start = 0
        for index, char in enumerate(s):
            # 이미 등장했던 문자라면 'start' 위치 갱신
            if char in used and start <= used[char]:
                start = used[char] + 1
            else:  # 최대 부분 문자열 길이 갱신
                max_length = max(max_length, index - start + 1)

            used[char] = index

        return max_length
