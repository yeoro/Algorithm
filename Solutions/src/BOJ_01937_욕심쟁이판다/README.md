# <img src="https://static.solved.ac/tier_small/13.svg" width=30> 1937: 욕심쟁이 판다 

### 문제 링크
> https://www.acmicpc.net/problem/1937

### 알고리즘 분류
>- 그래프 이론
>- 그래프 탐색
>- 깊이 우선 탐색
>- 다이나믹 프로그래밍

### 풀이 시간
>- ⏱ 1시간 20분

### 해결
> ![bad](../../../Img/bad.png)  
>1. 최'단'거리가 아닌 최'장'거리인데 BFS를 해서 오답이 나온 것 같다. 그래서 DFS로 풀었는데 시간초과였다.. 
>  
> ![good](../../../Img/good.png)
>1. 그래프 탐색이 아닌 2차원 dp 배열을 통해 풀 수 있는 문제였다.
>2. 한 좌표에서 4방향을 탐색하며 자기보다 큰 수이면 해당 좌표의 값과 나의 좌표+1 값을 비교하여 해당 좌표의 값을 갱신하며 dp 배열을 계산한다.
>3. 왼쪽 위 좌표에서 부터 차례대로 dp 배열을 갱신하면 큰 값이 작은 값보다 먼저 나왔을 때 값이 제대로 계산되지 않았다. 좌표들을 리스트에 넣고 값을 기준으로 오름차순 정렬 후 차례대로 꺼내 dp 배열을 완성했다.
