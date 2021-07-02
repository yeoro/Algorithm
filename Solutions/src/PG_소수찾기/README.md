# <img src="https://programmers.co.kr/assets/bi-symbol-light-49a242793b7a8b540cfc3489b918e3bb2a6724f1641572c14c575265d7aeea38.png" width=30>  소수 찾기

### 문제 링크
> https://programmers.co.kr/learn/courses/30/lessons/42839

### 알고리즘 분류
>- [완전탐색](https://programmers.co.kr/learn/courses/30/parts/12230)

### 풀이 시간
>- ⏱ 20분

### 해결
>- 문자열의 숫자들로 중복순열을 만들어 만든 숫자가 소수인지 판단하는 문제였다. 재귀 호출시 인자값에 subString을 이용하여 문자열을 넣어주는 방법도 있었다.
>1. 문자열의 숫자들을 배열에 저장한다.
>2. 배열의 숫자들로 중복 순열을 만든다. 순열의 크기가 주어진 문자열의 크기 보다 작을 경우 소수 판단을 진행한다.
>3. 중복 순열을 숫자로 바꾼다. 처음 보는 숫자이고 소수라고 판단되면 answer를 1 증가한다.
>4. 모든 경우의 수를 다 봤다면 answer를 반환한다.
