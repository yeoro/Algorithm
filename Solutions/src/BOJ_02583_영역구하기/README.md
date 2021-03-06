# <img src="https://static.solved.ac/tier_small/10.svg" width=30> 2583: 영역 구하기 

### 문제 링크
> https://www.acmicpc.net/problem/2583

### 알고리즘 분류
>- 그래프 이론
>- 그래프 탐색
>- 너비 우선 탐색
>- 깊이 우선 탐색

### 풀이 시간
>- ⏱ 30분

### 해결
> ![good](../../../Img/good.png)
>1. (M x N) 크기를 같은 모눈종이 배열을 선언한 후, 주어진 좌표 대로 색칠을 한다.
>2. 단, 좌표는 (열 행)의 순서로 주어지므로 주의해야 한다. 또한 오른쪽 위 좌표는 1씩 빼주어야 한다.
>3. 색칠 후에 BFS 탐색을 통해서 영역 갯수과 각 영역의 넓이를 출력한다.
