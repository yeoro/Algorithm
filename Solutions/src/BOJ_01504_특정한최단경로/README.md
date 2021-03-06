# <img src="https://static.solved.ac/tier_small/12.svg" width=30> 1504: 특정한 최단 경로 

### 문제 링크
> https://www.acmicpc.net/problem/1504

### 알고리즘 분류
>- 그래프 이론
>- 다익스트라

### 풀이 시간
>- ⏱ 1시간 

### 해결
> ![bad](../../../Img/bad.png)  
>1. 단순하게 1부터 N까지의 최단 경로를 구하고 v1, v2의 거리가 갱신되어있다면 거리 배열 값들의 합을 출력했다.
>
> ![good](../../../Img/good.png)
>1. ArrayList 타입의 배열에 간선 정보를 저장한다.
>2. v1와 v2를 거치는 두 경우에 대해 최단 거리를 구한다.
>       - 1 -> v1 -> v2 -> N
>       - 1 -> v2 -> v1 -> N  
>>3. 위의 두 경우는 각각 3번의 부분 최단거리의 값을 합한다. 각 경우에서의 합을 비교한 후 더 작은 값을 출력한다.
>4. 만약 두 경우 모두 Integer.MAX_VALUE와 값이 같거나 간선이 하나도 없는 경우는 -1을 출력한다.
