# <img src="https://static.solved.ac/tier_small/12.svg" width=30> 17406: 배열 돌리기 4 

### 문제 링크
> https://www.acmicpc.net/problem/17406

### 알고리즘 분류
>- 구현
>- 브루트포스 알고리즘

### 풀이 시간
>- ⏱ 2시간+

### 해결
> ![bad](../../../Img/bad.png)  
>- 회전 연산이 진행되는 사각형의 테두리에 있는 숫자들을 StringBuffer에 넣은 후 맨 뒤의 숫자를 맨 앞에 넣어 한 칸 민 상태로 만든 후 그대로 배열에 넣어주는 방식으로 풀었지만 바로 틀렸습니다가 나와버리고 실패..
>
> ![good](../../../Img/good.png)
>- 배열의 정보를 저장할 배열, 복사할 배열, 회전 연산을 진행할 배열 3개를 선언하고 각 회전 연산의 정수를 저장할 ArrayList 배열을 선언한다.
>- 모든 회전 연산을 1번씩 사용하여 연산한 후 배열의 최솟값을 구해야 하기 때문에 **순열**로 회전 연산의 순서를 구한다.
>- 길이가 K인 순열을 만든 후 복사 배열과 회전 배열을 초기화 해 주고 회전 연산을 진행한다.
>- 복사 배열의 꼭지점부터 오른쪽 혹은 아래쪽 정수 4개를 한 칸 옮겨 회전 배열에 저장한다.
>- 회전 연산이 한 번 끝난 후에는 다음 연산 때 복사 배열을 참고하기 위하여 복사 배열과 회전 배열의 모양을 같게 만들어준다.
>- 각 회전 순서에서의 배열 최솟값을 구한 후 전체 최솟값과 비교한다.