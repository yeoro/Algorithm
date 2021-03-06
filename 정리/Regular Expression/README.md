# **정규표현식 (Regular Expression, regex)**
![regex](https://miro.medium.com/max/2560/0*qASU92GfMj2HCTMg.jpg)
## **정의**
- 컴퓨터 과학의 정규언어로부터 유래한 것으로 특정한 규칙을 가진 문자열의 집합을 표현하기 위해 쓰이는 형식 언어
- 전화번호, 주민번호, 이메일 등 정해져있는 형식이 있고 사용자가 그 형식대로 입력했는지 검증을 하는 경우 종종 사용
## **구성**
- 메타문자 (문자를 나타내는 문자)
>- . : 모든 문자
>- [] : 대괄호 안에 들어가있는 문자를 찾음. 맨 앞에 ^가 오면 not을 의미
>- | : or
>- \s : 공백
>- \d : [0-9]
>- \w : 영문자, 숫자, 밑줄 [0-9a-zA-Z_]
- 수량자 (앞 문자의 개수)
>- ? : 앞 문자가 없거나 하나 있음 ({0, 1})
>- \+ : 앞 문자가 하나 이상 ({1, })
>- \* : 앞 문자가 0개 이상 ({0, })
>- {n, m} : 앞 문자가 n개 이상 m개 이하
>- {n, } : 앞 문자가 n개 이상. 위의 형태에서 m이 생략된 형태
>- {n} : 앞 문자가 n개
- 정규표현식 = 패턴구분자 시작 + 작성할 패턴 + 패턴구분자 끝 + 패턴 변경자
## **Example**
- /./g : 모든 문자
- /[.CU]/g : '.', 'C', 'U' 세 개의 문자를 찾음
- /[^.CU]/g : '.', 'C', 'U' 세 개의 문자를 제외한 문자를 찾음
- /abc|3|\\.\\./g : 'abc', '3', '..' 세 개의 문자를 찾음
- /\s|\w/g : 공백, 영문자, 숫자, 밑줄을 찾음
- /\d|[A-Za-z]/g : 숫자, 영문자를 찾음
- /o{1}|\d+|[A-Z]a*/g == /o{1}|\d{1,}|[A-Z]a{0,}/g : 'o'가 1개, 숫자가 1개 이상, 대문자+'a'의 길이가 0개 이상
- /wa?|,.*,/g : 'w', 'a'가 없거나 하나 있음, '.' 다음에 문자가 0개 이상이고 ','로 끝나는 문자열을 찾음
>- ex) Thank you, CU, Jason, JUN, Woni, Brown, Pobi! -> ,CU, Jason, JUN, Woni, Brown,
- /,.*?,/g : ?가 수량자의 뒤에 오면 게으른 수량자를 의미한다. 패턴을 처음 발견했을 때 쉬고 다시 찾는다
>- ex) Thank you, CU, Jason, JUN, Woni, Brown, Pobi! -> ,CU, , JUN, , Brown,
## **특징**
- 강점 : 패턴으로 검증 가능하며 if문을 많이 안써도 된다
- 약점 : 너무 안 좋은 가독성, 유지보수하기 힘들다
- 간단한 검증일 때는 if문으로 해결하며 메서드 명을 통해 가독성을 높이자
- 복잡한 검증일 때만 정규표현식을 사용하며 주석을 달아 가독성을 높이자
## **활용**
1. 컴파일러의 파서
2. CLI 환경을 주로 사용하는 경우 grep, sed, awk를 통해 쓰임
3. 이메일, 주소, 전화번호 규칙 검증
4. 입력에서 불필요한 입력 검증
5. 개발도구에서 문자열 치환
6. 로깅에서 찾아볼 때
7. 코딩테스트..
    - String의 replaceAll을 사용할 때, Pattern을 정적으로 만들어 사용하면 성능상의 이점을 얻을 수 있다.
## **Etc.**
- Pattern 객체는 불변 객체이다(생성자의 접근제어자가 private).
- Pattern의 compile 메소드는 정적 팩토리 메소드이므로 Thread-Safe 하다.
- Matcher 클래스 사용시 Matcher 객체를 reset하고 다시 input하여 재사용할 수 있지만 Thread-Safe 하지 못하다. 따라서 Matcher 객체를 새로 생성한 뒤 사용하자.


