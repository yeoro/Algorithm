# <img src="https://static.solved.ac/tier_small/8.svg" width=30> 1003: 피보나치 함수

### 문제 링크

> https://www.acmicpc.net/problem/1003

### 알고리즘 분류
>- 다이나믹 프로그래밍

### 풀이 시간

> - ⏱ 30분+

### 해결

> 1. **2차원 배열**을 만들어 **fibo(N, 0)** 과 **fibo(N, 1)** 을 호출하여 각 항에서의 0과 1의 호출 횟수를 저장했다.
> 2. **호출 횟수의 규칙**도 자연스럽게 **피보나치 수열**을 따르므로, 피보나치 수열을 구하기 위해 **재귀**와 **메모이제이션** 기법을 사용했다.