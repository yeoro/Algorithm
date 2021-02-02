# <img src="https://static.solved.ac/tier_small/8.svg" width=30> 13414: 수강신청

### 문제 링크

> https://www.acmicpc.net/problem/13414

### 알고리즘 분류
>- 자료 구조
>- 해시를 사용한 집합과 맵

### 풀이 시간

> - ⏱ 30분+

### 해결

> 1. **ArrayList**와 **LinkedList**를 사용했지만 검색과 삭제의 시간복잡도가 **O(N^2)** 여서 시간 초과가 뜨는 것 같았다.
> 2. **iterator**를 사용했지만 **O(N)** 이 뜨는건가..? 시간초과였다.
> 3. 결국 검색과 삽입/삭제가 빠른 **HashMap**을 써야하는 것을 알았고, 예상하는 시간복잡도는 **O(logN)** 인 것 같다.