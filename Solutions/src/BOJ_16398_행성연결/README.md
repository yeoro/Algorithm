# <img src="https://static.solved.ac/tier_small/12.svg" width=30> 16398: 행성 연결 

### 문제 링크
> https://www.acmicpc.net/problem/16398

### 알고리즘 분류
>- 그래프 이론
>- 최소 스패닝 트리

### 풀이 시간
>- ⏱ 19분

### 해결
> ![bad](../../../Img/bad.png)  
>1. 주어지는 간선의 가중치는 최대 100,000,000 까지이므로 행성의 개수가 1,000 일 때 100,000,000 * 1,000 까지 커질 수 있다. 따라서 자료형은 int가 아닌 long을 사용해야 한다.
>  
> ![good](../../../Img/good.png)
>1. 크루스칼 알고리즘 이용
