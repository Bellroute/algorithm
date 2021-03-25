# 리트코드 76. Mininum Window Substring

from typing import List
import collections


class Solution:
    # 풀이 1. 모든 윈도우 크기를 부르트 포스로 탐색
    # t의 크기부터 시작해 점점 크기를 키워가며 모든 윈도우 크기에 대해 탐색을 시도
    # 시간 복잡도 O(n^2)
    def minWindow_brouteforce(self, s: str, t: str) -> str:
        def contains(s_substr_lst: List, t_lst: List):
            for t_elem in t_lst:
                if t_elem in s_substr_lst:
                    s_substr_lst.remove(t_elem)
                else:
                    return False
            return True

        if not s or not t:
            return ''

        window_size = len(t)

        for size in range(window_size, len(s) + 1):
            for left in range(len(s) - size + 1):
                s_substr = s[left:left + size]
                if contains(list(s_substr), list(t)):
                    return s_substr

        return ''

    # 풀이 2. 투 포인터, 슬라이딩 윈도우로 최적화
    # 앞에서부터 오른쪽 포인터 값을 늘려간다. 필요한 문자가 다 나올 때까지.
    # 필요한 문자가 다 나오면 왼쪽 포인터 값을 늘려 윈도우 크기를 줄인다. s[left] 값이 0보다 작을 때까지.
    # 현재 left ~ right 길이와 역대 최소 길이와 비교한다.
    def minWindow_twopointer(self, s: str, t: str) -> str:
        need = collections.Counter(t)
        missing = len(t)
        left = start = end = 0

        # 오른쪽 포인터 이동
        for right, char in enumerate(s, 1):
            missing -= need[char] > 0
            need[char] -= 1

            # 필요 문자가 0이면 왼쪽 포인터 이동 판단
            if missing == 0:
                while left < right and need[s[left]] < 0:
                    need[s[left]] += 1
                    left += 1

                # 최소 길이 비교
                if not end or right - left <= end - start:
                    start, end = left, right

                need[s[left]] += 1
                missing += 1
                left += 1

        return s[start:end]

    # 풀이 3. Counter로 좀 더 편리한 풀이
    # AND 연산으로 모든 결과가 포함되는지 여부를 확인할 수 있음
    def minWindow(self, s: str, t: str) -> str:
        t_count = collections.Counter(t)
        current_count = collections.Counter()

        start = float('-inf')
        end = float('inf')

        left = 0
        # 오른쪽 포인터 이동
        for right, char in enumerate(s, 1):
            current_count[char] += 1

            # AND 연산 결과로 왼쪽 포인터 이동 판단
            while current_count & t_count == t_count:
                if right - left < end - start:
                    start, end = left, right
                current_count[s[left]] -= 1
                left += 1

        return s[start:end] if end - start <= len(s) else ''
