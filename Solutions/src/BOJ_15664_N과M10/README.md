# <img src="https://static.solved.ac/tier_small/9.svg" width=30> 15664: N과 M (10)

### 문제 링크

> https://www.acmicpc.net/problem/15664

### 알고리즘 분류
>- 백트래킹

### 풀이 시간

> - ⏱ 6분

### 해결

> 1. 방문체크 배열 사용
> 2. 다음 수가 큰 경우에만 순열 생성
> 3. 순열이 생성될 때마다 **HashSet**에 있는지 판단 후 없으면 넣고 출력, 있으면 return 
> 4. **BufferedReader**, **BufferedWriter** 사용