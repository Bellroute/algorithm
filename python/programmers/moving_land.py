# 프로그래머스 코딩테스트 연습 > Summer/Winter Coding(2019) > 지형 이동

import collections
import math
import heapq


# 풀이 1. 크루스칼 알고리즘 이용
# 그룹화를 시킬때 사다리 없이 방문할 수 있는 칸을 bfs로 탐색한다.
def bfs(land, height, groups, x, y, group_number):
    move = [(1, 0), (0, 1), (-1, 0), (0, -1)]
    queue = collections.deque([(x, y)])
    groups[x][y] = group_number

    while queue:
        now = queue.popleft()

        # 상, 하, 좌, 우 이동
        for i in range(4):
            new_x = now[0] + move[i][0]
            new_y = now[1] + move[i][1]

            # 범위 밖을 벗어나는 경우는 pass
            if new_x < 0 or new_y < 0 or new_x >= len(groups) or new_y >= len(groups[0]) or groups[new_x][new_y] != 0:
                continue

            # 사다리 없이 방문 가능한 경우에는 큐에 추가하고, 해당 칸에 그룹번호를 입력시킨다.
            if abs(land[new_x][new_y] - land[now[0]][now[1]]) <= height:
                queue.append((new_x, new_y))
                groups[new_x][new_y] = group_number


# 그룹과 그룹 사이의 가중치의 최솟값을 구한다.
def get_groups_wieghts(land, groups, height):
    move = [(1, 0), (0, 1), (-1, 0), (0, -1)]

    # 그룹과 그룹 사이의 가중치를 저장할 딕셔너리
    # 기본값으로 inf를 둔다.
    # 키 : (그룹a, 그룹b)
    # 값 : 최소 가중치
    weights = collections.defaultdict(lambda: math.inf)

    for i in range(len(groups)):
        for j in range(len(groups[0])):
            now = groups[i][j]
            for dx, dy in move:
                new_x, new_y = i + dx, j + dy

                # 범위를 벗어나는 경우 pass
                if new_x < 0 or new_y < 0 or new_x >= len(groups) or new_y >= len(groups[0]) or groups[new_x][new_y] == now:
                    continue

                dist = abs(land[new_x][new_y] - land[i][j])

                # 그룹과 그룹 사이 놓을 수 있는 사다리 중 가장 적은 비용을 저장
                weights[(now, groups[new_x][new_y])] = min(
                    dist, weights[(now, groups[new_x][new_y])])

    return weights


# 유니온파인드 알고리즘의 find 메소드
# root[x]의 값이 본인이 아니라는 것은
# 종속되어 있는(=이어져있는) 다른 노드가 존재함을 의미
def find(x, root):
    if x == root[x]:
        return x
    else:
        r = find(root[x], root)
        root[x] = r
        return r


# 유니온파인드 알고리즘의 union 메소드
# x와 y의 각각의 뿌리를 찾아서 하나로 합쳐준다.
def union(x, y, root):
    x_root = find(x, root)
    y_root = find(y, root)
    root[y_root] = x_root


# 크루스칼 알고리즘
def kruskal(group_weights, groups):
    sum = 0
    roots = {_: _ for _ in range(1, groups)}  # {1:1, 2:2, 3:3 ... }

    for (x, y), value in group_weights:
        if find(x, roots) != find(y, roots):
            sum += value
            union(x, y, roots)
        if len(roots.items()) == 1:
            return sum
    return sum


# 풀이 2. 우선순위 큐를 이용
def solution(land, height):
    N = len(land)

    # 방문 여부를 체크하는 2차원 배열
    visited = [[False for _ in range(N)] for _ in range(N)]
    move = [(1, 0), (0, 1), (-1, 0), (0, -1)]

    # 큐
    queue = []

    visit_count = 0
    max_count = N * N
    value = 0

    # 탐색 시작 지점을 큐에 넣는다.
    queue.append((0, 0, 0))

    while visit_count < max_count:
        # 사다리비용, x좌표, y좌표
        val, x, y = heapq.heappop(queue)

        # 이미 방문한 곳이라면 건너뛴다.
        if visited[x][y]:
            continue
        visited[x][y] = True

        visit_count += 1
        value += val

        # 현재 칸의 높이
        current_height = land[x][y]

        for dx, dy in move:
            nx, ny = x + dx, y + dy

            if nx < 0 or ny < 0 or nx >= N or ny >= N:
                continue

            # 다음 칸의 높이
            next_height = land[nx][ny]

            # 현재 칸과 다음 칸의 높이 차이가 height보다 크다면 사다리가 필요한 시점
            if abs(next_height - current_height) > height:
                heapq.heappush(
                    queue, (abs(next_height - current_height), nx, ny))  # (사다리비용, x좌표, y좌표)
            # 사다리가 필요하지 않은 시점은 사다리비용을 0으로 처리
            # 다음 반복문에서 value += 0 이기 때문에 결과값에 영향을 미치지 않음
            else:
                heapq.heappush(queue, (0, nx, ny))
    return value
