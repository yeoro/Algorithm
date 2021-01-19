# <img src="https://static.solved.ac/tier_small/7.svg" width=30> 9012: 괄호

### 문제 링크
> https://www.acmicpc.net/problem/9012

### 알고리즘 분류
>- 자료구조
>- 문자열
>- 스택

### 풀이 시간
>- ⏱ 26분

### 해결
> 1. Stack 이용
> 2. **(** 인 경우 push
> 3. **)** 인 경우 스택이 비어있지 않으면 pop 한 후 꺼낸 괄호가 **)** 이면 둘 다 push / 스택이 비어있으면 push   
