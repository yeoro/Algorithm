# <img src="https://static.solved.ac/tier_small/13.svg" width=30> 12014: 주식 

### 문제 링크
> https://www.acmicpc.net/problem/12014

### 알고리즘 분류
>- [가장 긴 증가하는 부분 수열: O(n log n)](https://www.acmicpc.net/problem/tag/43)

### 풀이 시간
>- ⏱ 50분

### 해결
> ![bad](../../../Img/bad.png)  
>1. LIS를 구하는 도중에 길이가 K와 같으면 끝내고 1을 출력했는데 틀렸다. LIS를 끝까지 구하고 K와 비교해야 정답이었다.. 왜지..?
>  
> ![good](../../../Img/good.png)
>1. 주어진 주가들을 수열로 보고, 그 속에 존재하는 LIS의 길이를 구한다. 나는 Arrays 클래스의 binarySearch 메소드를 이용했다. 
>2. LIS 배열을 구하는 작업이 끝났다면 마지막 LIS의 인덱스+1가 K보다 크거나 같은지 비교한다. 그렇다면 1을 출력하고, 아니면 0을 출력한다.
