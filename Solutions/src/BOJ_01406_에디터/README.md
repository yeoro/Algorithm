# <img src="https://static.solved.ac/tier_small/8.svg" width=30> 1406: 에디터

### 문제 링크

> https://www.acmicpc.net/problem/1406

### 알고리즘 분류

> - 자료구조
> - 스택
> - 덱
> - 연결 리스트

### 풀이 시간

> - ⏱ 30분+

### 해결

> 1. 인덱스를 통해 값을 찾기 위해 **LinkedList** 이용
> 2. **BufferedReader**, **BufferedWriter**를 이용해도 시간초과
> 3. LinkedList는 **get()** 메소드 사용시 바로 그 인덱스에 접근하는게 아니라, head와 tail을 제외하곤 하나하나 살펴보며 찾아가서 처리하기 때문에 **비효율**적이다.
> 4. 위치를 찾아가는 방법이 아닌 **커서**처럼 해당하는 위치에 계속 있으면서 삽입/삭제를 처리할 수 있는 **ListIterator** 이용
