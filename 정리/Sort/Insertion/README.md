# **삽입 정렬 (Insertion Sort)**
![Insertion_Sort](https://upload.wikimedia.org/wikipedia/commons/9/9c/Insertion-sort-example.gif)
- 모든 요소에 대해 앞에서부터 차례대로 이미 정렬된 배열과 비교하여 정렬된 배열에서 자신의 위치를 찾아 삽입하는 방식

## 특징
- 버블정렬, 선택정렬보다 빠르나 자료구조에 따라 밀어내는데 시간이 오래 걸린다.
- 이미 정렬되어 있는 자료구조에 자료를 하나씩 삽입/제거하는 경우 오버헤드가 적다.
- 배열의 크기가 작을 때 상당히 효율적이어서 배열의 크기가 클 때는 O(nlogn) 알고리즘을 쓰다가 삽입정렬도 전환하기도 한다.

## 정렬 과정 
- 정렬할 자료를 두 개의 부분집합 S와 U로 가정
    - 부분집합 S : 정렬된 앞부분 원소들
    - 부분집합 U : 아직 정렬되지 않은 나머지 원소들
- 정렬되지 않은 부분집합 U의 원소를 하나씩 꺼내서 이미 정렬되어있는 부분집합 S의 마지막 원소부터 비교하면서 위치를 찾아 삽입한다.
- 삽입 정렬을 반복하면서 부분집합 S의 원소는 하나씩 늘리고 부분집합 U의 원소는 하나씩 감소하게 된다.
- 부분집합 U가 공집합이 되면 삽입정렬이 완성된다.

## 시간 복잡도
- **O(N^2)**

## 공간 복잡도 
-  단 하나의 배열에서만 진행되므로 **O(n)** 이다.  

