# **프림 (Prim)**
![prim](https://lh3.googleusercontent.com/proxy/GsOOEH4UHTTjTwdtd7ErFJJo4zQzZ4T228_LkKsCv8cPUVGAAPpIkfUGYtP2_2EGAOZTOU1gutNziw)
## **정의**
- 시작 정점에서부터 출발하여 신장 트리 집합을 단계적으로 확장해나가는 방법
## **과정**
1. 시작 단계에서는 시작 정점만이 MST 집합에 포함된다.
2. 앞 단계에서 만들어진 MST 집합에 인접한 정점들 중에서 최소 간선으로 연결된 정점을 선택하여 트리를 확장한다.
3. 위의 과정을 트리가 (n-1)개의 간선을 가질 때까지 반복한다.
## **시간 복잡도**
- 주 반복문이 정점의 수 n만큼 반복하고, 내부 반복문이 n번 반복하므로 O(N^2)이 된다.
- 그래프에 간선이 많은 **밀집 그래프(Dense Graph)** 의 경우에 사용한다.
## **참고**
- [[알고리즘] Prim 알고리즘 이란](https://gmlwjd9405.github.io/2018/08/30/algorithm-prim-mst.html)



