# <img src="https://static.solved.ac/tier_small/10.svg" width=30> 21608: 상어 초등학교 

### 문제 링크
> https://www.acmicpc.net/problem/21608

### 알고리즘 분류
>- 구현

### 풀이 시간
>- ⏱ 1시간 31분

### 해결
> ![good](../../../Img/good.png)
>- 정렬과 4방 탐색만으로 풀 수 있는 구현 문제였다.
>1. 1개의 2차원 배열과 2개의 배열을 사용하여 다음과 같이 주어진 정보를 저장했다.
>       - 2차원 배열: 학생들의 자리를 배치할 배열이다. 
>       - ArrayList 배열: 각 학생들의 원하는 학생을 저장할 배열이다.
>       - int 배열: 자리배치 순서를 저장할 배열이다.
>2. 우선 첫 번째 순서의 학생은 다음과 같이 배치한다.
>       1. 배열이 비어있는 초기 상태에서 1번 조건을 적용하면, 좋아하는 학생이 인접한 칸은 없으므로 모든 칸이 조건에 해당된다.
>       2. 2번 조건을 적용하면, 인접한 빈 칸이 가장 만은 칸을 선택해야하므로 배열의 가장자리는 제외해야한다.
>       3. 3번 조건을 적용하면, 위의 후보 칸들 중에서 가장 왼쪽 위 칸을 선택해야 하므로 (1, 1)을 선택한다.
>       4. 이는 모든 N의 경우에 해당된다. 따라서 첫 번째 순서의 학생은 무조건 (1, 1)에 배치한다.
>3. 나머지 학생들도 다음과 같이 배치한다.
>       1. 배열에서 빈 칸을 찾는다. 인접한 칸에 좋아하는 학생이 있는지, 빈 칸이 있는지 구한 후 우선순위 큐에 넣는다.
>       2. 우선순위 큐에 있는 객체들을 다음과 같이 정렬한다.
>           1. 인접한 좋아하는 학생 수 내림차순
>           2. 인접한 비어있는 칸 수 내림차순
>           3. 행 오름차순
>           4. 열 오름차순
>       3. 우선순위 큐의 peek() 의 좌표에 현재 학생을 배치한다.
>4. 학생들의 만족도를 계산한 후 출력한다.

