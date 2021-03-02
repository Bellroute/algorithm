# 버블 정렬(Bubble Sort)
# n번의 라운드로 이뤄져 있으며, 각 라운드마다 배열의 아이템을 한 번씩 모두 살펴본다.
# 연달아 있는 아이템 2개의 순서가 잘못되어 있는 것을 발견하면, 두 아이템을 맞바꾼다.
# 시간 복잡도 : O(n^2)
# (스왑 여부를 확인해 더 최적화할 수 있지만, 그럼에도 다른 정렬 알고리즘과는 여전히 성능 차이가 있음)
def bubblesort(A):
    for i in range(1, len(A)):
        for j in range(0, len(A) - 1):
            if A[j] > A[j + 1]:
                A[j], A[j + 1] = A[j + 1], A[j]


# 병합 정렬(Merge Sort)
# 분할 정복(Divide and Conquer)을 이용한 알고리즘
# 더 이상 쪼갤 수 없을 때까지 계속해서 분할한 후, 분할이 끝나면 정렬하면서 정복해 나간다.
# 퀵 정렬보다는 느리지만 일정한 실행 속도 뿐만 아니라 안정 정렬이라는 점에서 상용 라이브러리에 많이 쓰임
# 시간 복잡도 : 최선, 최악 모두 O(n log n)
def mergesort(A):
    if len(A) < 2:
        return A

    mid = len(A) // 2
    low = mergesort(A[:mid])
    high = mergesort(A[mid:])

    result = []
    l = h = 0
    while l < len(low) and h < len(high):
        if low[l] < high[h]:
            result.append(low[l])
            l += 1
        else:
            result.append(high[h])
            h += 1

    result += low[l:]
    result += high[h:]
    return result

# 퀵 정렬(Quick Sort)
# 병합 정렬과 마찬가지로 분할 정복 알고리즘을 사용
# 피벗(Pivot)이라는 개념을 통해 피벗보다 작으면 왼쪽, 크면 오른쪽과 같은 방식으로 파티셔닝하면서 쪼개 나간다.
# 여러 가지 변형과 개선 버전이 있는데 여기서는 로무토 파티션 계획을 살펴본다.
# 로무토 파티션이란 항상 맨 오른쪽의 피벗을 택하는 단순한 방법
# (피봇을 어떤 값으로 선정하느냐에 따라 성능 차이가 난다. 예를 들어, 이미 정렬된 배열이 들어온 경우)
# 시간 복잡도 : O(n log n), 최악 O(n^2)


def quicksort(A, lo, hi):
    def partition(lo, hi):
        pivot = A[hi]
        left = lo
        for right in range(lo, hi):
            if A[right] < pivot:
                A[left], A[right] = A[right], A[left]
                left += 1
        A[left], A[hi] = A[hi], A[left]
        return left

    if lo < hi:
        pivot = partition(lo, hi)
        quicksort(A, lo, pivot - 1)
        quicksort(A, pivot + 1, hi)
