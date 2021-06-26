# <img src="https://softeer.ai/images/common/logo.png" width=50 height=20> 지도 자동 구축 

### 문제 링크
> https://softeer.ai/practice/info.do?eventIdx=1&psProblemId=413

### 알고리즘 분류
>- 다이나믹 프로그래밍

### 풀이 시간
>- ⏱ 30분

### 해결
> ![good](../../../Img/good.png)
>1. 처음에는 현재 단계에서의 한 변에 있는 점의 갯수에 접근했다. 이때 단계별 점의 갯수는 각 항끼리의 차가 2의 거듭제곱인 수열이라는 것을 알 수 있었다. 점화식은 다음과 같다.
>       - dp[i] = Math.sqrt(dp[i-1]) + (1 * Math.pow(2, i-1))
>2. dp 배열의 값을 미리 계산한 후 dp[N]을 출력한다.
