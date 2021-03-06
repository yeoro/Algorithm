# <img src="https://static.solved.ac/tier_small/11.svg" width=30> 2225: 합분해 

### 문제 링크
> https://www.acmicpc.net/problem/2225

### 알고리즘 분류
>- 다이나믹 프로그래밍

### 풀이 시간
>- ⏱ 40분

### 해결
> ![bad](../../../Img/bad.png)  
>1. dp 배열에 값을 저장할 때 1,000,000,000으로 나눈 나머지를 저장해야했다.
>  
> ![good](../../../Img/good.png)
>1. (K x N) 크기의 2차원 dp 배열을 선언한다.
>2. 모든 K의 경우에 0을 만드는 경우는 1밖에 없기 때문에 0열의 값을 모두 1로 초기화한다.
>3. 배열을 초기화해놓고 경우의 수를 생각해보니, (N, K)의 값은 (N-1, K)와 (N, K-1)가 더해지는 규칙이 있는 것을 알 수 있었다. 따라서 점화식을 다음과 같이 세웠다.
>       - dp[i][j] = dp[i-1][k] + dp[i][k-1]
>4. 나는 무지성으로 규칙을 찾아서 풀었기에 다른 사람들이 푼 방법을 찾아보니 다음과 같았다.
>       - K=2, N=2인 경우 (0, 2), (1, 1), (2, 0) 와 같이 끝자리가 0부터 K까지인 것을 알 수 있다.
>       - K=3, N=2인 경우 (0, **0, 2**), (0, **2, 0**), (0, **1, 1**), (1, **0, 1**), (1, **1, 0**), (2, **0, 0**) 와 같이 끝자리가 K=2, N=2인 경우인 것을 알 수 있다.
>       - 따라서 dp[K][N]의 값은 dp[K-1][N-0] + dp[K-1][N-1] + dp[K-1][N-3] 인 것을 알 수 있다.
>5. dp 배열을 채운 후 dp[N][K]을 출력한다.