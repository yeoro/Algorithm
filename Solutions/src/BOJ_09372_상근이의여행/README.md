# <img src="https://static.solved.ac/tier_small/8.svg" width=30> 9372: 상근이의 여행

### 문제 링크
> https://www.acmicpc.net/problem/9372

### 알고리즘 분류
>- 그래프 이론
>- 트리

### 풀이 시간
>- ⏱ 16분

### 해결
> ![good](../../../Img/good.png)
>1. 최소 비행기(간선)으로 모든 국가(정점)을 방문해야 하므로 최소신장트리를 구현한다.
>2. 주어진 두 정점의 부모가 같지 않다면 비행기 갯수를 1증가하고 union 연산한다.
