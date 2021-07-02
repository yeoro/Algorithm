# <img src="https://programmers.co.kr/assets/bi-symbol-light-49a242793b7a8b540cfc3489b918e3bb2a6724f1641572c14c575265d7aeea38.png" width=30>  더 맵게

### 문제 링크
> https://programmers.co.kr/learn/courses/30/lessons/42626

### 알고리즘 분류
>- [힙(Heap)](https://programmers.co.kr/learn/courses/30/parts/12117)

### 풀이 시간
>- ⏱ 30분

### 해결
>- 우선순위 큐를 사용하여 해결하는 문제였다. 나는 매 회마다 Iterator로 순회하며 K보다 작은 값이 있으면 섞는 작업을 진행했지만, 어차피 최소값이 앞에 가니까 맨 앞 값과 K를 비교하면 불필요한 작업을 줄일 수 있었다.
>1. 우선순위 큐에 모든 스코빌 지수를 넣는다.
>2. while문 안에서 작업을 진행한다. Iterator를 이용하여 모든 스코빌 지수를 살펴보며 K보다 작은 수가 있는지 판단한다. K보다 작은 수가 존재하고 우선순위 큐의 크기가 1이라면 더 이상 섞는 작업을 진행하지 못하므로 -1을 반환한다.
>3. 그렇지 않으면 섞는 작업을 진행한다. 큐에서 값 두 개를 꺼내 연산한 값을 다시 큐에 넣고 answer 값을 1 증가한다.
>4. 모든 스코빌 지수가 K보다 크면 작업을 종료하고 answer 값을 반환한다.
