# <img src="https://static.solved.ac/tier_small/5.svg" width=30> 3985: 롤 케이크

### 문제 링크
> https://www.acmicpc.net/problem/3985

### 알고리즘 분류
>- 구현

### 풀이 시간
>- ⏱ 16분

### 해결
> 1. 방청객의 수 만큼 반복문
> 2. 예상 조각을 계산하여 리스트에 저장
> 3. P와 K 범위에서 반복문 돌며 케이크 배열에 방청객 번호 저장
> 4. 실제 조각을 계산하여 리스트에 저장
> 5. Collections.max 를 이용하여 많이 받을 것으로 예상되는 방청객 출력
> 6. Collections.min 을 이용하여 실제 많이 받는 방청객 출력
> Collections 는 최소, 최대 값이 여러개인 경우 인덱스가 더 작은 것을 선택!