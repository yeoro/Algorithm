# <img src="https://static.solved.ac/tier_small/5.svg" width=30> 11005: 진법 변환 2

### 문제 링크
> https://www.acmicpc.net/problem/11005

### 알고리즘 분류
>- 구현

### 풀이 시간
>- ⏱ 10분

### 해결
> 1. 10진법 수 N을 B로 나누며 나온 **나머지**를 **StringBuffer**에 저장
> 2. 나머지가 **10 이상**인 경우, **아스키 코드**에서의 **대문자**로 바꾸기 위해 나머지에 **55**를 더해주고 **캐릭터** 타입으로 변환
> 3. **StringBuffer.reverse()** 로 출력