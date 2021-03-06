# **플로이드 와샬 (Floyd-Warshall)**
![floyd-warshall](https://miro.medium.com/max/1250/1*DdqguI9FlBehCWALlFDEOw.png)
## **정의**
- 그래프에서 **모든 정점 사이의 최단 거리**를 구하기 위한 알고리즘
- **다익스트라 알고리즘을 모든 정점에서 수행**한 것과 같은 알고리즘이지만 **비교적 구현이 간단**하다.
- 사이클이 없는 경우 **음수 가중치 처리가 가능**하다.
## **Complexity**
- 시간
>- **반복문 3개**를 **정점의 개수 만큼** 돌기 때문에 **O(N^3)** 의 시간 복잡도를 갖는다.
- 공간
>- 특정 정점에서 특정 정점까지의 경로를 저장해나가며 구한 경로를 이용해 새로운 최단 경로를 찾는 **DP**방식으로 수행
>- **경로를 저장하며 최단 경로를 찾기** 때문에 **2차원 배열**을 사용해야하므로 **O(N^2)**의 공간 복잡도를 갖는다.
## **Process (단방향 그래프)**
- 직접 갈 수 있는 정점이 아니라면 **INF(무한대)** 값, 직접 갈 수 있는 정점이라면 **가중치** 값을 넣고 이차원 배열 초기화
- 경유해서 갈 수 있는 최단 경로가 있는지 확인하기 위해 **모든 정점을 경유 정점으로 설정하여 모든 정점 탐색**