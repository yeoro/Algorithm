# <img src="https://programmers.co.kr/assets/bi-symbol-light-49a242793b7a8b540cfc3489b918e3bb2a6724f1641572c14c575265d7aeea38.png" width=30>  모의고사

### 문제 링크
> https://programmers.co.kr/learn/courses/30/lessons/42840

### 알고리즘 분류
>- [완전탐색](https://programmers.co.kr/learn/courses/30/parts/12230)

### 풀이 시간
>- ⏱ 31분

### 해결
>1. 각 수포자의 정답 규칙 배열을 만든다.
>       - **1**: 1, 2, 3, 4, 5
>       - **2**: 2, 1, 2, 3, 2, 4, 2, 5
>       - **3**: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5
>2. 문제의 정답들을 보며 각 수포자가 맞춘 문제 갯수를 score 배열에 저장한다.
>3. HashMap에 맞춘 문제 갯수별 수포자를 저장한다.
>4. 맞춘 문제를 내림차순으로 정렬하고 HashMap 맨 앞의 키값이 0이 아닐 경우 맞춘 수포자들을 배열에 저장한다.
