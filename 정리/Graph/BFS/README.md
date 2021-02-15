# **BFS (Breadth First Search)**
![bfs](https://gmlwjd9405.github.io/images/algorithm-dfs-vs-bfs/bfs-example.png)
- 루트 노드에서 시작하여 인접한 노드들을 먼저 차례로 방문한 후에, 방문했던 노드를 시작점으로 하여 다시 인접한 노드들을 차례로 방문하는 방법
- 인접한 노드들에 대해 탐색을 한 후 차례로 다시 너비 우선 탐색을 진행해야 하므로, **선입선출** 형태의 자료구조인 **큐**를 
- **두 노드 사이의 최단 경로** 혹은 **임의의 경로를 찾고 싶을 때** 사용
- **Prim**, **Dijkstra** 알고리즘과 유사