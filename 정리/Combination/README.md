# **조합**
![combination](https://mblogthumb-phinf.pstatic.net/MjAxNzAxMTlfNzYg/MDAxNDg0ODE1ODM1MjM3.DDx7m-rEFsiWHk2WJtb1gJImKWjNeYfCwmV8nX02WMsg.Kcphzp_lBUV7SI6pV3IQCeL-nlilH_PCGLtIC8Iuuxog.GIF.vollollov/118_1.gif?type=w800)
- 서로 다른 **N**개의 수 중에 **R**개를 **순서에 상관없이** 나열하는 것
- nCr = n-1Cr-1 + n-1Cr
    - n-1Cr-1 : r-1개에서 n번째 원소를 선택(+1)해야 r개가 되므로 n번째 원소를 **선택**하는 경우의 수
    - n-1Cr : n번째 원소를 선택하지 않아도 r개가 되므로 n번째 원소를 **선택하지 않는** 경우의 수

# **중복조합**
![recombination](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FbKNmjh%2FbtqHAnsVZe5%2FvQRNVHXwiZKYbiebwyXTEK%2Fimg.png)
- 서로 다른 **N**개의 수 중에 **중복**하여 **R**개를 **순서에 상관없이** 나열하는 것

# **부분집합**
![subset](https://image.slidesharecdn.com/random-100312190808-phpapp01/95/-8-728.jpg?cb=1268420920)
- 원소가 N개인 집합에서 **0~N**개의 원소를 추출하여 만든 집합
- 각 원소의 입장에서 **선택** 혹은 **비선택** 2가지의 경우가 있으므로 총 경우의 수는 **2^N**
- Binary Counting
>- **0**부터 **2^N-1**까지의 수들로 이미 부분집합 비트열이 존재
>- 0, 1 두가지 상태로 선택, 비선택 판단
>- **비트열 & 1 << 원소의 인덱스** 로 사용여부 판단