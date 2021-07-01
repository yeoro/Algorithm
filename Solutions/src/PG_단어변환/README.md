# <img src="https://programmers.co.kr/assets/bi-symbol-light-49a242793b7a8b540cfc3489b918e3bb2a6724f1641572c14c575265d7aeea38.png" width=30> 단어 변환

### 문제 링크
> https://programmers.co.kr/learn/courses/30/lessons/43163

### 알고리즘 분류
>- [깊이/너비 우선 탐색(DFS/BFS)](https://programmers.co.kr/learn/courses/30/parts/12421)

### 풀이 시간
>- ⏱ 36분

### 해결
>- 나는 각 자리의 알파벳을 모두 바꿔가며 BFS를 진행했지만, 다른 사람들의 풀이를 보니 words 배열의 단어와 비교하여 한 번만에 갈 수 있다면 words 배열의 단어를 큐에 넣는 방식으로 하더라..
>1. BFS 탐색 도중에 바꾸려는 단어가 단어의 집합에 있는 단어인지 확인하기 위해 HashMap에 넣는다.
>2. 현재 단어에서 각 알파벳별로 바꿔가며 HashMap에 존재하는 단어인지 판단한다.
>3. HashMap에 존재하는 단어이고 현재 교환횟수가 더 작을 경우 큐에 넣는다.
>4. 큐에서 꺼낸 단어가 target과 같을 경우 최솟값을 갱신한다.
