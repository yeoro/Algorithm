# <img src="https://programmers.co.kr/assets/bi-symbol-light-49a242793b7a8b540cfc3489b918e3bb2a6724f1641572c14c575265d7aeea38.png" width=30>  크레인 인형뽑기 게임

### 문제 링크
> https://programmers.co.kr/learn/courses/30/lessons/64061

### 알고리즘 분류
>- 구현

### 풀이 시간
>- ⏱ 26분

### 해결
>1. moves 배열의 크기만큼 인형뽑기-터뜨리기 작업을 진행한다.
>2. 이동한 열에서 위에서 아래로 행을 훑으며 인형을 찾는다. 인형이 있다면 뽑고 board에서의 값을 0으로 바꾼다.
>3. 인형을 뽑았을 경우 스택의 크기가 0이면 그냥 넣는다. 
>4. 스택의 맨 위 값이 뽑은 인형과 같다면 answer를 2 증가하고 맨 위의 인형을 꺼낸다. 다르다면 뽑은 인형을 스택에 넣는다.
