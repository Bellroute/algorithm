# 리트코드 49.Group Anagrams
"""
Given an array of strings strs, group the anagrams together. You can return the answer in any order.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

Example 1:

Input: strs = ["eat","tea","tan","ate","nat","bat"]
Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
Example 2:

Input: strs = [""]
Output: [[""]]
Example 3:

Input: strs = ["a"]
Output: [["a"]]
 

Constraints:

1 <= strs.length <= 104
0 <= strs[i].length <= 100
strs[i] consists of lower-case English letters.
"""

from typing import List
import collections


class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        # 존재하지 않는 키를 삽입할 경우 KeyError가 발생하므로 디폴트 dict를 선언해준다.
        anagrams = collections.defaultdict(list)  # 리스트를 value로 갖는 dict

        for word in strs:
            # sorted()는 문자열을 정렬해서 리스트 형태로 리턴한다.
            # 정렬된 리스트를 다시 문자열로 사용하기 위해 join()을 이용한다.
            anagrams[''.join(sorted(word))].append(word)

        return anagrams.values()
