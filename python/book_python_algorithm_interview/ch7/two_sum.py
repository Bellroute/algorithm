# 리트코드 1.Two Sum
"""
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.
You can return the answer in any order.

Example 1:

Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Output: Because nums[0] + nums[1] == 9, we return [0, 1].
Example 2:

Input: nums = [3,2,4], target = 6
Output: [1,2]
Example 3:

Input: nums = [3,3], target = 6
Output: [0,1]
 

Constraints:

2 <= nums.length <= 103
-109 <= nums[i] <= 109
-109 <= target <= 109
Only one valid answer exists.
"""

from typing import List


class Solution:
    # 풀이 1. 부르트 포스로 계산
    # 시간 복잡도는 O(n^2)
    def twoSum_bruteforce(self, nums: List[int], target: int) -> List[int]:
        for i in range(len(nums)):
            for j in range(i+1, len(nums)):
                if nums[i] + nums[j] == target:
                    return [i, j]

    # 풀이 2. in을 이용한 탐색
    # 타겟에서 첫 번째 값을 뺀 값이 존재하는지 탐색
    # 시간 복잡도은 O(n^2)로 이전과 동일하지만 훨씬 더 가볍고 빠르다. -> but, 실제로 따라 해보니까 그런건 아닌것 같다.
    # 파이썬 내부 함수로 구현된 in은 파이썬 레벨에서 매번 값을 비교하는 것보다 더 빨리 실행되기 때문
    def twoSum_in(self, nums: List[int], target: int) -> List[int]:
        # enumerate()는 리스트 원소들의 인덱스와 값을 전달하는 기능을 한다.
        for i, n in enumerate(nums):
            complement = target - n

            if complement in nums[i + 1:]:
                # index()는 해당 값을 가지고 있는 원소의 인덱스를 리턴
                # nums[i + 1:]이라는 슬라이싱된 리스트에서의 인덱스 값에서 실제 인덱스를 구하기 위해 (i + 1)을 더함
                return nums.index(n), nums[i + 1:].index(complement) + (i + 1)

    # 풀이 3. 첫 번째 수를 뺀 결과 키 조회
    # 두 번째 수를 키로 하고 기존의 인덱스는 값으로 바꿔서 딕셔너리로 저장해두면,
    # 나중에 두 번째 수를 키로 조회해서 정답을 즉시 찾아낼 수 있음.
    # 딕셔너리는 해시테이블로 구현되어있고 이 경우 조회는 O(1)에 가능
    # 시간 복잡도는 O(n)
    def twoSum_exceptFirstNum(self, nums: List[int], target: int) -> List[int]:
        nums_map = {}
        # 키와 값을 바꿔서 딕셔너리로 저장
        for i, num in enumerate(nums):
            nums_map[num] = i

        # 타겟에서 첫 번째 수를 뺀 결과를 키로 조회
        for i, num in enumerate(nums):
            if target - num in nums_map and i != nums_map[target - num]:
                return nums.index(num), nums_map[target - num]

    # 풀이 4. 조회 구조 개선
    # nums_map 전체를 저장할 필요 없이 정답을 찾게 되면 바로 빠져나올 수 있음
    # 앞선 풀이와 큰 차이는 없지만 코드는 한결 간결해짐
    def twoSum_exceptFirstNum_improve(self, nums: List[int], target: int) -> List[int]:
        nums_map = {}
        # 하나의 for 문으로 통합
        for i, num in enumerate(nums):
            if target - num in nums_map:
                return [nums_map[target - num], i]
            nums_map[num] = i

    # 풀이 5. 투 포인터 이용 -> sort()하게 되면 인덱스 값이 달라지기 때문에 원래 인덱스를 찾을 수 없음.
    # def twoSum_twoPointer(self, nums: List[int], target: int) -> List[int]:
    #     left, right = 0, len(nums) - 1
    #     while not left == right:
    #         if nums[left] + nums[right] < target:
    #             left += 1
    #         elif nums[left] + nums[right] > target:
    #             right -= 1
    #         else:
    #             return [left, right]

    # 풀이 6. 고(Go) 구현
    # 파이썬보다 약 6배 빠름.
    # 좀 더 최적화된 언어를 택했다는 것만으로도 온라인 코테에서 성능을 개선할 수 있다
    # func twoSum(nums []int, target int) []int {
    #     numsMap := make(map[int]int)

    #     # 키와 값을 바꿔서 딕셔너리로 저장
    #     for i, num := range nums {
    #         numsMap[num] = i
    #     }

    #     # 타겟에서 첫 번째 수를 뺀 결과를 키로 조회
    #     for i, num := range nums {
    #         if j, ok := numsMap[target-num]; ok && i != j {
    #             return []int{i, j}
    #         }
    #     }

    #     return []int{}
    # }
