# <img src="https://programmers.co.kr/assets/bi-symbol-light-49a242793b7a8b540cfc3489b918e3bb2a6724f1641572c14c575265d7aeea38.png" width=30> 완주하지 못한 선수

### 문제 링크
> https://programmers.co.kr/learn/courses/30/lessons/42576

### 알고리즘 분류
>- 해시

### 풀이 시간
>- ⏱ 10분

### 해결
>- 선수 이름-인원 수의 쌍을 갖는 HashMap 사용
>- 완주한 선수를 HashMap에서 찾고, 해당 이름을 가진 선수가 1명 완주했으므로 인원 수를 1만큼 감소하여 바꿔준다.
>- 완주한 선수를 모두 탐색했으면 HashMap에서 인원 수가 0보다 큰 선수의 이름을 찾아 출력한다.
