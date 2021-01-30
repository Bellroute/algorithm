# 프로그래머스 코딩테스트 연습 > Summer/Winter Coding(~2018) > 스킬트리

def solution(skill, skill_trees):
    answer = 0

    for skill_tree in skill_trees:
        parsed_skill = list(filter(lambda s: s in skill, skill_tree))
        matcher = zip(skill, parsed_skill)

        if any(m[0] != m[1] for m in matcher):
            continue
        answer += 1

    return answer
