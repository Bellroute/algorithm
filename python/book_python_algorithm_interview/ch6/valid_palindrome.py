# 리트코드 125.Valid Palindrome
"""
Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

Note: For the purpose of this problem, we define empty string as valid palindrome.

Example 1:

Input: "A man, a plan, a canal: Panama"
Output: true
Example 2:

Input: "race a car"
Output: false

"""

import re
import collections
from typing import Deque


class Solution(object):
    # 풀이1. 리스트로 변환
    def isPalindrome_list(self, s: str) -> bool:
        strs = []
        for char in s:
            if char.isalnum():  # isalnum()은 영문자, 숫자 여부를 판별하는 함수
                strs.append(char.lower())

        while len(strs) > 1:
            # pop(i)는 리스트의 i번째 원소를 pop하는 함수, 파라미터를 입력하지 않으면 맨 끝 원소를 pop한다.
            if strs.pop(0) != strs.pop():
                return False

        return True

    # 풀이2. 데크 자료형을 이용한 최적화
    """
    리스트의 pop(0)은 O(n)인 데 반해, 데크의 popleft()는 O(1)이기 때문에 
    각각 n번씩 반복하면, 리스트 구현은 O(n^2), 데크 구현은 O(n)으로 성능차이가 크다.
    """

    def isPalindrome_deque(self, s: str) -> bool:
        # 자료형 데크로 선언
        strs: Deque = collections.deque()

        for char in s:
            if char.isalnum():
                strs.append(char.lower())

        while len(strs) > 1:
            if strs.popleft() != strs.pop():
                return False

        return True

    # 풀이3. 슬라이싱 사용
    """
    파이썬 슬라이싱은 내부적으로 C로 빠르게 구현되어 있어 훨씬 더 좋은 속도를 기대할 수 있다.
    """

    def isPalindrome_slicing(self, s: str) -> bool:
        s = s.lower()
        # 정규식으로 불필요한 문자 필터링
        s = re.sub('[^a-z0-9]', '', s)  # re 는 정규 표현식 모듈

        return s == s[::-1]  # 슬라이싱. [::-1]은 뒤집는 기능

    # 풀이4. C로 풀이
    """
    bool isPalindrome(char * s){
    int bias_left = 0;
    int bias_right = 1;
    
    int str_len = strlen(s);
    for (int i = 0; i < str_len; i++) {
        while(!isalnum(s[i + bias_left])) {
            bias_left++;
            if(i + bias_left == str_len)
                return true;
        }
        
        while(!isalnum(s[str_len - i - bias_right])) {
            bias_right++;
        }
        
        if(i + bias_left >= str_len - i - bias_right)
            break;
        
        if(tolower(s[i + bias_left]) != tolower(s[str_len - i - bias_right]))
            return false;
    }
    
    return true;
}
    """
