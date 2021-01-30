# 프로그래머스 코딩 테스트 연습 > 스택/큐 > 프린

def solution(priorities, location):
    queue = list(zip(range(0, len(priorities)), priorities))
    count = 1
    while queue:
        document = queue.pop(0)
        if any(document[1] < q[1] for q in queue):
            queue.append(document)
            continue
        if document[0] == location:
            return count
        count += 1

    # queue = list(zip(range(0, len(priorities)), priorities))
    # count = 1
    # while queue:
    #     document = queue.pop(0)

    #     if not queue:
    #         return count

    #     index, value = zip(*queue)

    #     if document[1] < max(value):
    #         queue.append(document)
    #         continue

    #     if document[0] == location:
    #         return  count
    #     count += 1
