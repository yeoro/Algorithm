# <img src="https://static.solved.ac/tier_small/13.svg" width=30> 1039: 교환 

### 문제 링크
> https://www.acmicpc.net/problem/1039

### 알고리즘 분류
>- 그래프 이론
>- 그래프 탐색
>- 너비 우선 탐색

### 풀이 시간
>- ⏱ 2시간+

### 해결
> ![bad](../../../Img/bad.png)  
>- 방문 체크와 연산 횟수를 관리하기 위해 HashMap을 사용했는데, 게시판에 있는 반례들은 다 맞았는데 어떤 이유인지 계속 틀렸다고 나왔다..
>
> ![good](../../../Img/good.png)
>- 결국 HashMap 대신 방문 체크와 연산 횟수를 2차원 배열로 관리했고 한 번에 통과했다..
