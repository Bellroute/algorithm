# 리트코드 461. Hamming Distance

class Solution:
    # 풀이. XOR 풀이
    def hammingDistance(self, x: int, y: int) -> int:
        return bin(x ^ y).count('1')
