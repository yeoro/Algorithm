# <img src="https://static.solved.ac/tier_small/8.svg" width=30> 1158: 요세푸스 문제

### 문제 링크

> https://www.acmicpc.net/problem/1158

### 알고리즘 분류

> - 자료구조
>- 큐

### 풀이 시간

> - ⏱ 30분+

### 해결

> 1. **LinkedList** 를 이용하여 **ListIterator** 로 커서를 움직이며 하나씩 값을 없앰
> 2. 커서가 리스트의 맨 오른쪽에 위치하면 **list.listIterator(0)** 를 통해 맨 왼쪽 위치로 초기화 한 후 **next()** 로 처음 수를 선택하게 했다.
> 3. **list.listIterator(1)** 로 처음 수 오른쪽에 커서를 놨더니, 삭제할 수의 위치는 맞지만 선택된 수가 없어 맨 왼쪽으로 옮기고 수를 선택하는 방식으로 바꿨다.
