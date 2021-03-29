# 리트코드 424. Longest Repeating Character Replacement

import collections


class Solution:

    # 풀이. 투 포인터, 슬라이딩 윈도우, Counter를 모두 이용
    def characterReplacement(self, s: str, k: int) -> int:
        left = right = 0
        counts = collections.Counter()
        for right in range(1, len(s) + 1):
            counts[s[right - 1]] += 1
            # 가장 흔하게 등장하는 문자 탐색
            max_char_n = counts.most_common(1)[0][1]

            # k 초과시 왼쪽 포인터 이동
            if right - left - max_char_n > k:
                counts[s[left]] -= 1
                left += 1
        # 최댓값을 구해야 하지만, 한번 최댓값이 된 상태(right - left - max_char_n == k)에서는
        # 오른쪽 포인터가 한 칸 이동하면 왼쪽 포인터도 따라서 이동하게 되면서 최대값은 바뀌지 않게 됨.
        # 불필요하게 최대값을 비교하는 연산을 추가할 필요가 없음.
        return right - left
