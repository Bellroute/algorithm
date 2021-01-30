# 프로그래머스 코딩 테스트 연습 > 스택/큐 > 다리를 지나는 트럭

from collections import deque


def solution(bridge_length, weight, truck_weights):
    bridge = deque(0 for _ in range(bridge_length))
    total_weight = 0
    time = 0
    truck_weights.reverse()

    while truck_weights:
        total_weight -= bridge.popleft()
        if total_weight + truck_weights[-1] > weight:
            bridge.append(0)
        else:
            total_weight += truck_weights[-1]
            bridge.append(truck_weights.pop())
        time += 1

    time += bridge_length

    return time


# 처음 짠 코드. 통과시킨 코드지만 상당히 비효율적임
# 람다식을 쓴다고 map, filter 연산도 많았고
# 리스트를 pop(0)하게 되면 가장 첫 번째 원소를 빼내고 나머지 원소들을 앞으로 한 칸씩 당기는 연산이 계속 생겨 느려짐
# 위 코드처럼 리스트를 뒤집어두고 뒤에서부터 pop()하는 방식으로 하면 연산 속도를 줄일 수 있게 됨!
def solution_my(bridge_length, weight, truck_weights):
    queue = []
    time = 0

    while truck_weights:
        queue = zip(
            list(map(lambda q: q[0] + 1, queue)), list(map(lambda q: q[1], queue)))
        queue = list(filter(lambda q: q[0] < bridge_length, queue))
        if sum(list(map(lambda q: q[1], queue))) + truck_weights[0] <= weight:
            queue.append((0, truck_weights.pop(0)))
        time += 1

    return time + bridge_length
