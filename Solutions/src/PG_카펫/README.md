# <img src="https://programmers.co.kr/assets/bi-symbol-light-49a242793b7a8b540cfc3489b918e3bb2a6724f1641572c14c575265d7aeea38.png" width=30> 카펫

### 문제 링크
> https://programmers.co.kr/learn/courses/30/lessons/42842

### 알고리즘 분류
>- [완전탐색](https://programmers.co.kr/learn/courses/30/parts/12230) 

### 풀이 시간
>- ⏱ 23분

### 해결
>- 전체 넓이를 구한 후 조건을 만족시키는 가로와 세로를 구하는 문제였다.
>1. brown과 yellow를 더해 카펫의 넓이를 구한 후, 가로와 세로가 될 수 있는 약수들을 ArrayList에 넣는다.
>2. 약수들의 쌍을 살펴보며 다음 조건을 만족하는 가로와 세로가 될 수 있는지 판단한다. 
>       - (가로-2)와 (세로-2)를 곱한 값이 yellow와 일치하는 경우
>       - 가로가 세로와 같거나 큰 경우
