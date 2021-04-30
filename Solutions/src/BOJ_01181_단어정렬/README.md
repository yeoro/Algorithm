# <img src="https://static.solved.ac/tier_small/6.svg" width=30> 1181: 단어 정렬 

### 문제 링크
> https://www.acmicpc.net/problem/1181

### 알고리즘 분류
>- 정렬
>- 문자열

### 풀이 시간
>- ⏱ 분

### 해결
> ![good](../../../Img/good.png)
>1. 문자열과 길이를 갖는 클래스를 만들어 리스트에 저장하고 정렬하려고 했지만 단어가 중복되는지 판단하기 어려워서 HashMap을 사용했다.
>2. 주어진 단어를 HashMap에 입력한 후 Entry<> 리스트를 만들어 값을 넣어줬다. 
>3. Comparator를 이용하여 2가지 정렬 조건을 세웠고, 조건에 맞게 정렬한 후 Entry<> 리스트에 있는 key값들을 출력했다.
