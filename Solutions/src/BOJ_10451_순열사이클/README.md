# <img src="https://static.solved.ac/tier_small/10.svg" width=30> 10451: 순열 사이클 

### 문제 링크
> https://www.acmicpc.net/problem/10451

### 알고리즘 분류
>- 그래프 이론
>- 그래프 탐색
>- 순열 사이클 분할

### 풀이 시간
>- ⏱ 9분

### 해결
>- **모든 정점을 탐색**하며 **방문여부 판단 후 DFS**
>- 한 정점에서 DFS를 진행할 때 연결되어있는 정점은 방문 처리가 되며 한 사이클을 생성한다. DFS가 끝나고 사이클의 수를 1 증가시켜준다.
>- 간선이 없는 정점도 한 사이클로 생각해야한다.