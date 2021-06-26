# <img src="https://softeer.ai/images/common/logo.png" width=50 height=20> 동계 테스트 시점 예측 

### 문제 링크
> https://softeer.ai/practice/info.do?eventIdx=1&psProblemId=411

### 알고리즘 분류
>- 구현
>- 시뮬레이션
>- 너비 우선 탐색

### 풀이 시간
>- ⏱ 1시간 18분

### 해결
> ![good](../../../Img/good.png)
>1. 임의의 공기 좌표에서 BFS 탐색을 통해 얼음과 인접한 외부 공기만 골라낸다.
>2. 인접한 공기의 갯수를 저장할 배열을 따로 선언하고, 아까 골라낸 외부 공기들의 좌표에서 BFS 탐색을 통해 인접한 얼음들의 좌표에 1씩 카운트를 증가한다.
>3. 인접한 공기가 2 이상인 얼음을 녹이고 1번 과정부터 반복한다. 만약 녹일 얼음이 없다면 시간을 출력하고 종료한다.
