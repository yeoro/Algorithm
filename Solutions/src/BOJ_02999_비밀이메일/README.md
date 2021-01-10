# <img src="https://static.solved.ac/tier_small/5.svg" width=30> 2999: 비밀 이메일

### 문제 링크
> https://www.acmicpc.net/problem/2999

### 알고리즘 분류
>- 구현

### 풀이 시간
>- ⏱ 30분+

### 해결
> 1. 1부터 N까지 반복문을 돌며 조건에 맞는 R과 C를 구함
> 2. 암호를 해독할 R*C 크기의 배열 생성
> 3. 암호를 앞에서 부터 한 글자씩 제거하면서 배열에 넣을 생각으로 ArrayList 이용
> 4. 배열의 왼쪽 부터 채우고, 위에서 부터 출력 