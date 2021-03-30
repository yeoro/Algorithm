# <img src="https://programmers.co.kr/assets/bi-symbol-light-49a242793b7a8b540cfc3489b918e3bb2a6724f1641572c14c575265d7aeea38.png" width=30> 전화번호 목록

### 문제 링크
> https://programmers.co.kr/learn/courses/30/lessons/42577

### 알고리즘 분류
>- 해시

### 풀이 시간
>- ⏱ 1시간

### 채점 결과
>- 정확성: 83.3
>- 효율성: 16.7
>- 합계: 100.0 / 100.0

### 해결
>- phone_book 배열을 정렬한 후 현재 전화번호가 그 다음 전화번호의 접두어인지 판단한다.
>- 배열을 정렬할 경우 사전 순으로 정렬되기 때문에 다음 전화번호가 현재 전화번호를 포함하지 않으면 뒤의 전화번호들은 살펴보지 않아도 된다.
