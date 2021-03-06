# <img src="https://programmers.co.kr/assets/bi-symbol-light-49a242793b7a8b540cfc3489b918e3bb2a6724f1641572c14c575265d7aeea38.png" width=30>  2017 카카오코드 본선 - 단체사진 찍기

### 문제 링크
> https://programmers.co.kr/learn/courses/30/lessons/1835

### 알고리즘 분류
>- 브루트포스 알고리즘

### 풀이 시간
>- ⏱ 1시간

### 채점 결과
>- 정확성 100.0
>- 합계 100.0 / 100.0

### 해결
>1. 8명의 카카오프렌즈를 줄 세우며 조건이 맞는지 확인했다. 8명을 줄 세우는 경우의 수는 8! (40,320) 이기 때문에 시간 초과는 나지 않을 것으로 예상했다.
>2. 줄을 세운 후 조건 문자열에서 2명의 알파벳, 부호, 거리를 뽑아 조건에 맞는지 확인한다. 모든 조건에 부합한다면 답을 1 증가한다.
>3. 조건을 확인하는 과정에서는 플래그 변수를 선언해서 조건에 부합하지 않을 경우 변수 값만 바꿔주고 for문이 끝났을 때 변수를 반환하는 식으로 구현했는데, 모든 조건을 살펴봐야 메소드가 끝나기 때문에 시간 초과가 뜬 것 같다. 
>4. 변수를 반환하지 않고 안맞는 조건이 있을 경우 바로 메소드를 끝내는 방법으로 구현했더니 해결할 수 있었다.
