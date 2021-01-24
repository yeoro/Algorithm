# <img src="https://static.solved.ac/tier_small/8.svg" width=30> 10799: 쇠막대기

### 문제 링크
> https://www.acmicpc.net/problem/10799

### 알고리즘 분류
>- 자료구조
>- 스택

### 풀이 시간
>- ⏱ 7분

### 해결
> 1. **Stack** 이용
> 2. **(** 인 경우 인덱스 값 push
> 3. **)** 인 경우 **Stack.peek()** 와 값이 1차이 나면 레이저로 판단, **Stack.pop()** 후 **Stack.size()** 만큼 막대기 조각이 생겼으므로 사이즈 값을 더해줌
> 4. 값이 1 이상 차이나면 막대기로 판단, 레이저가 **N번** 잘랐으면 **N+1** 개의 조각이 생기므로 **1**만 더해줌