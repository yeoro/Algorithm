# <img src="https://static.solved.ac/tier_small/7.svg" width=30> 11653: 소인수분해

### 문제 링크

> https://www.acmicpc.net/problem/11653

### 알고리즘 분류
>- 수학
>- 정수론
>- 소수 판정

### 풀이 시간

> - ⏱ 13분

### 해결

> 1. **N**이 **1**이면 바로 **return**
> 2. **2**부터 **N**까지 반복문을 돌며 **N을 i로 나눈 나머지**가 **0**인 경우, i를 출력하고 N을 i로 나눈 값으로 바꾸고 **i++** 이 아닌 **i**로 반복문을 다시 시작한다.
> 3. N이 **1**이 되면 반복문을 종료한다.