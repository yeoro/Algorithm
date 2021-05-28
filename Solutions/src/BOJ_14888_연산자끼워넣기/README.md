# <img src="https://static.solved.ac/tier_small/10.svg" width=30> 14888: 연산자 끼워넣기 

### 문제 링크
> https://www.acmicpc.net/problem/14888

### 알고리즘 분류
>- 백트래킹
>- 브루트포스 알고리즘

### 풀이 시간
>- ⏱ 26분

### 해결
> ![good](../../../Img/good.png)
>1. 완탐으로 연산자들의 순서를 조합한 후 연산을 진행한다.
>2. 숫자를 담는 Deque를 선언하고, 앞에서 숫자를 2개씩 꺼내 연산한다. 연산 결과는 다시 Deque의 앞에 넣는다.
>3. 현재 결과를 최대, 최소값과 비교 후 갱신한다.
