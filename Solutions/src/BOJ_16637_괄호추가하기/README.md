# <img src="https://static.solved.ac/tier_small/13.svg" width=30> 16637: 괄호 추가하기 

### 문제 링크
> https://www.acmicpc.net/problem/16637

### 알고리즘 분류
>- 브루트포스 알고리즘

### 풀이 시간
>- ⏱ 1시간 40분

### 해결
> ![bad](../../../Img/bad.png)  
>- 괄호가 생길 수 있는 경우의 수에 따라 앞에서부터 괄호를 만들어 가며 연산하는 방법을 생각했다.
>- 덱을 이용하여 연산 결과를 앞에 삽입하고 다음 연산을 진행하려 했는데, 중간에 괄호가 들어가는 경우에 대한 해결법을 찾지 못했다.
>- 다른 사람의 소스를 [참조](https://steady-coding.tistory.com/36)하여 풀었다.
>
> ![good](../../../Img/good.png)
>- **DFS**와 **백트래킹**을 이용하여 풀었다.
>- 숫자 리스트와 연산자 리스트를 따로 두고, 괄호가 있는 경우와 괄호가 없는 경우 두가지를 나누어 DFS 탐색을 진행했다.
>- 괄호가 없는 경우
>   - 연산자 리스트의 인덱스를 통해 숫자 2개와 연산자 1개를 뽑아 계산하고, 다음 재귀 함수의 변수로 계산 결과와 연산자 인덱스를 1증가 시킨 값을 선언했다.
>- 괄호가 있는 경우
>   - 연산자 리스트 크기를 넘어가지 않는 인덱스 내에 아직 계산에 사용하지 않은 연산자가 있다면, 다음에 계산할 수와 그 다음의 수를 계산한다.
>   - 현재 결과 값과 미리 계산한 값을 현재 연산자로 계산한 값과 연산자 인덱스를 2증가 시킨 값을 다음 재귀함수의 변수로 선언한다.  
