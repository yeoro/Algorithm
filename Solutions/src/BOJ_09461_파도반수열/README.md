# <img src="https://static.solved.ac/tier_small/8.svg" width=30> 9461: 파도반 수열 

### 문제 링크
> https://www.acmicpc.net/problem/9461

### 알고리즘 분류
>- 수학
>- 다이나믹 프로그래밍

### 풀이 시간
>- ⏱ 20분

### 해결
> ![bad](../../../Img/bad.png)  
>1. N이 커지면 값이 int 범위를 넘어가기 때문에 long으로 바꿔주었다.
>  
> ![good](../../../Img/good.png)
>1. 크기가 101인 long 타입의 dp 배열을 만들고, dp[3] 까지 값을 초기화한다.
>2. 다음의 점화식에 따라 dp 배열의 값을 채워넣는다.
>       - dp[i] = dp[i-2] + dp[i-3]
>3. T의 갯수 만큼 dp[N]을 출력한다.