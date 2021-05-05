# <img src="https://programmers.co.kr/assets/bi-symbol-light-49a242793b7a8b540cfc3489b918e3bb2a6724f1641572c14c575265d7aeea38.png" width=30> 멀리 뛰기

### 문제 링크
> https://programmers.co.kr/learn/courses/30/lessons/12914

### 알고리즘 분류
>- 다이나믹 프로그래밍

### 풀이 시간
>- ⏱ 1시간

### 채점 결과
>- 정확성 100.0

### 해결
>1. BFS, DFS 두 가지 방법으로 구현했지만 모두 시간초과여서 DP로 구현했다.
>2. n-1에서 n에 도달하는 경우는 1칸을 뛰는 경우와 2칸을 뛰는 경우 2가지가 있기 때문에 다음과 같은 점화식을 세웠다.
>       - dp[n] = dp[n-1] + dp[n-2]
