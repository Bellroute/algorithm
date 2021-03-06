# 리트코드 179. Largest Number

from typing import List


class Solution:
    # 내 풀이
    def largestNumber_mySolution(self, nums: List[int]) -> str:
        def compare(a, b):
            if a + b <= b + a:
                return 1
            else:
                return -1

        result = [str(nums[0])]
        for i in range(1, len(nums)):
            flag = False
            for j in range(0, len(result)):
                if compare(str(nums[i]), result[j]) == -1:
                    result.insert(j, str(nums[i]))
                    flag = True
                    break
            if not flag:
                result.append(str(nums[i]))

        answer = ''.join(result)
        if answer.startswith('0'):
            return '0'

        return answer

    # 책 풀이. 삽입 정렬

    # 문제에 적합한 비교 함수
    @staticmethod
    def to_swap(n1: int, n2: int) -> bool:
        return str(n1) + str(n2) < str(n2) + str(n1)

    # 삽입정렬 구현
    def largestNumber(self, nums: List[int]) -> str:
        i = 1
        while i < len(nums):
            j = i
            while j > 0 and self.to_swap(nums[j - 1], nums[j]):
                nums[j], nums[j - 1] = nums[j - 1], nums[j]
                j -= 1
            i += 1

        # 입력값이 ['0','0']인 경우 리턴값이 00이 되어버리기 때문에 00이 0이 되도록 int로 변환 후 다시 str로 변경한다.
        return str(int(''.join(map(str, nums))))
