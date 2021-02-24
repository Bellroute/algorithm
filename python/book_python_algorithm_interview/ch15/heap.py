# 힙 연산
# 파이썬의 heapq 모듈에서 지원하는 최소 힙 연산을 직접 구현해보자.
# 밑줄(_) 2개로 둘러싸인 함수는 파이썬의 매직 메소드로 여러 가지 내부(Built-In) 기능이 동작되는 데 사용됨.

class BinaryHeap(object):
    def __init__(self):
        # 0번 인덱스는 사용하지 않기 위해 None을 미리 설정해둔다.
        self.items = [None]

    def __len__(self):
        return len(self.items) - 1

    # 삽입
    # 힙에 요소를 삽입하기 위해서는 업힙(Up-Heap) 연산을 수행해야 한다.
    # [힙에 요소를 삽입하는 과정]
    # 1. 요소를 가장 하위 레벨의 최대한 왼쪽으로 삽입(배열로 표현할 경우 가장 마지막에 삽입)
    # 2. 부모 값과 비교해 값이 더 작은 경우 위치를 변경
    # 3. 게속해서 부모 값과 비교해 위치를 변경(가장 작은 값일 경우 루트까지 올라감)
    # 메소드명 앞에 밑줄(_)은 private임을 표현하기 위함.
    # 시간 복잡도는 O(log n)
    def _percolate_up(self):
        i = len(self)
        parent = i // 2
        while parent >= 0:
            if self.items[i] < self.items[parent]:
                self.items[parent], self.items[i] = self.items[i], self.items[parent]
            i = parent
            parent = i // 2

    def insert(self, k):
        self.items.append(k)
        self._percolate_up()

    # 추출
    # 추출은 간단하다. 루트를 추출하면 된다.
    # 시간복잡도는 O(1)이라 생각할 수 있지만, 추출 이후 다시 힙의 특성을 유지하는 작업이 필요하기 때문에 O(log n)
    # [힙에 요소를 추출하는 과정]
    # 1. 루트를 추출한다.
    # 2. 추출 이후에 비어 있는 루트에는 가장 마지막 요소를 삽입한다.
    # 3. 자식 노드와 값을 비교해서 자식보다 크면 내려가는 다운힙(Down-Heap) 연산을 수행한다.
    def _percolate_down(self, idx):
        left = idx * 2
        right = idx * 2 + 1
        smallest = idx

        if left <= len(self) and self.items[left] < self.items[smallest]:
            smallest = left

        if right <= len(self) and self.items[right] < self.items[smallest]:
            smallest = right

        if smallest != idx:
            self.items[idx], self.items[smallest] = self.items[smallest], self.items[idx]
            self._percolate_down(smallest)

    def extract(self):
        extracted = self.items[1]
        self.items[1] = self.items[len(self)]
        self.items.pop()
        self._percolate_down(1)
        return extracted

# 이진 힙 vs 이진 탐색 트리(BST)
# 힙은
# 상/하 관계를 보장(최소 힙에서는 부모가 항상 자식보다 작다)
# 최대값 혹은 최소값을 추출할 때 사용. 단순 1회 추출 시에는 시간 복잡도 O(1)
# BST는
# 좌/우 관계를 보장(BST에서 부모는 왼쪽 자식보다는 크며, 오른쪽 자식보다는 작거나 같다.)
# 모든 값이 정렬되어야 할 때 사용.
# 탐색, 삽입 모두 O(log n)
