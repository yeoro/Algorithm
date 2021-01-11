# <img src="https://static.solved.ac/tier_small/5.svg" width=30> 9093: 단어 뒤집기

### 문제 링크
> https://www.acmicpc.net/problem/9093

### 알고리즘 분류
>- 문자열

### 풀이 시간
>- ⏱ 30분+

### 해결
> 1. nextLine 으로 문자열 입력 
> 2. nextInt 는 개행 문자를 처리하지 않으므로 문자열을 입력하기 전에 nextLine 을 해서 개행 문자를 처리해준다.
> 3. split 을 사용하여 공백 단위로 문자열을 잘라 String 배열에 저장한다.
> 4. StringBuffer 를 사용하여 잘라낸 단어를 담고, StringBuffer.reverse 를 이용하여 공백과 함께 거꾸로 출력한다.   