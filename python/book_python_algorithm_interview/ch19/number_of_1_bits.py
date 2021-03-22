# 리트코드 191. Number of 1 Bits

class Solution:
    # 풀이 1. 1의 개수 계산
    # 해밍 가중치의 값 == 모두 0으로 구성된 비트들과의 해밍 거리 == A XOR 0
    # def hammingWeight(self, n: int) -> int:
    #   return bin(n ^ 0b00000000000000000000000000000000).count('11)
    def hammingWeight(self, n: int) -> int:
        return bin(n).count('1')

    # 풀이 2. 비트 연산
    # 이진수의 특징을 이용한다.
    # A라는 값에서 1을 빼고, 그 값과 AND 연산을 하게 되면 비트가 1씩 빠지게 된다.
    # 이를 A가 0이 될 때까지 반복하면 1의 갯수를 구할 수 있다.
    def hammingWeight_bit(self, n: int) -> int:
        count = 0
        while n:
            # 1을 뺀 값과 AND 연산 횟수 측정
            n &= n - 1
            count += 1
        return count
