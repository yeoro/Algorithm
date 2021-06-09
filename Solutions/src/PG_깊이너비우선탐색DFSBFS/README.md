# <img src="https://programmers.co.kr/assets/bi-symbol-light-49a242793b7a8b540cfc3489b918e3bb2a6724f1641572c14c575265d7aeea38.png" width=30> 네트워크

### 문제 링크
> https://programmers.co.kr/learn/courses/30/lessons/43162

### 알고리즘 분류
>- 너비 우선 탐색
>- 깊이 우선 탐색

### 풀이 시간
>- ⏱ 9분

### 해결
>1. ArrayList 타입의 배열을 만들고 컴퓨터들의 연결 상태를 저장한다.
>2. 한 정점에서 연결된 정점들을 DFS 탐색하며 방문 처리를 해준다. 탐색이 끝나면 한 네트워크가 존재하는 것이므로 answer를 1 증가한다.
>3. 모든 정점에서의 탐색이 끝나면 answer를 return 한다.
