# <img src="https://programmers.co.kr/assets/bi-symbol-light-49a242793b7a8b540cfc3489b918e3bb2a6724f1641572c14c575265d7aeea38.png" width=30> 베스트앨범

### 문제 링크
> https://programmers.co.kr/learn/courses/30/lessons/42579

### 알고리즘 분류
>- [해시](https://programmers.co.kr/learn/courses/30/parts/12077)

### 풀이 시간
>- ⏱ 1시간 30분

### 해결
>- 해시맵 간의 데이터 이동, 해시맵 내의 정렬 등 해시맵을 능숙하게 다뤄야하는 문제였다. 특히 해시맵의 정렬이나 삽입 순서가 유지되는 LinkedHashMap 과 같이 몰랐던 지식을 알 수 있었다.
>1. 우선 장르를 재생횟수 기준으로 내림차순 해야한다. HashMap을 하나 만들고 장르 배열을 순회하며 각 장르별 재생횟수를 누적시켜준다.
>2. HashMap의 값을 List에 복사한 후 값을 기준으로 내림차순 정렬한다.
>3. HashMap을 하나 만들고 List에 순서대로 정렬된 장르들을 넣어준다. 이때, 그냥 HashMap은 삽입 순서가 보장되지 않으므로 LinkedHashMap을 사용한다.
>4. 장르 배열을 순회하며 해당 장르를 키로 갖는 ArrayList에 노래들의 번호와 재생횟수를 넣어준다. 다 넣어줬다면 ArrayList를 재생횟수를 기준으로 내림차순한다.
>5. 각 장르별 ArrayList의 크기가 2이상이면 2개를 넣고, 2미만이면 1개만 정답배열에 넣는다.
