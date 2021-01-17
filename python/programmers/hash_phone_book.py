# 프로그래머스 코딩 테스트 연습 > 해쉬 > 전화번호 목록

def my_solution(phone_book):
    phone_book.sort()

    for i, phone in enumerate(phone_book):
        for j in range(i + 1, len(phone_book)):
            # startswith 이용하면 더 간결해질 듯하다.
            if phone == phone_book[j][:len(phone)]:
                return False

    return True
