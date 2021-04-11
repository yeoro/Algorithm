# <img src="https://static.solved.ac/tier_small/12.svg" width=30> 1717: 집합의 표현 

### 문제 링크
> https://www.acmicpc.net/problem/1717

### 알고리즘 분류
>- 자료구조
>- 분리 집합

### 풀이 시간
>- ⏱ 27분

### 해결
> ![bad](../../../Img/bad.png)
>- 단순한 연결리스트 문제인 줄 알고 입력 받는 원소끼리만 집합을 만들어서 구현했다.  
>
> ![good](../../../Img/good.png)
>- 유니온 파인드를 이용하여 구현했다.
>- 시간
>   - 기본적인 유니온 파인드: 4932ms
>   - 경로 압축: 432ms
>   - 경로 압축 + 높이 최적화: 404ms
