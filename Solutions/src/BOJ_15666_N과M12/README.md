# <img src="https://static.solved.ac/tier_small/9.svg" width=30> 15666: N과 M (12)

### 문제 링크

> https://www.acmicpc.net/problem/15666

### 알고리즘 분류
>- 백트래킹

### 풀이 시간

> - ⏱ 4분

### 해결

> 1. 다음 수가 큰 경우에만 순열 생성
> 2. 순열이 생성될 때마다 **HashSet**에 있는지 판단 후 없으면 넣고 출력, 있으면 return 
> 3. **StringBuffer**에 순열을 **문자열**로 넣다보니, **1 11**과 **11 1**을 구분하지 못해 틀렸다. 출력 처럼 수의 사이에 **공백**을 넣어 해결했다.
> 3. **BufferedReader**, **BufferedWriter** 사용