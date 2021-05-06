# <img src="https://static.solved.ac/tier_small/8.svg" width=30> 2003: 수들의 합 2 

### 문제 링크
> https://www.acmicpc.net/problem/2003

### 알고리즘 분류
>- 두 포인터

### 풀이 시간
>- ⏱ 45분

### 해결
> ![good](../../../Img/good.png)
>1. 두 포인터 알고리즘의 로직을 이해하느라 오래걸렸다.
>2. 문제를 푸는 과정은 다음과 같다.
>       1. start와 end까지의 합 sum과 M을 비교하며 end가 배열의 끝에 닿을 때 까지 진행한다.
>       2. sum > M 인 경우, sum의 값을 줄여야 M에 가까워지기 때문에 start를 1 증가한다.
>       3. sum < M 인 경우, sum의 값을 늘려야 M에 가까워지기 때문에 end를 1 증가한다.
>       4. sum = M 인 경우, cnt를 1 증가하고 다음 구간을 찾기 위해 start를 1 증가한다. 여기서 start를 1 증가하는 과정은 sum > M 인 경우에 포함되었다.
>3. 배열의 크기를 N+1로 선언하는 것은 포인터가 배열의 마지막 오른쪽으로 갔을 때를 위해서인가..? 
