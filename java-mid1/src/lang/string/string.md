## String 클래스 - 기본
### 문자를 다루는 대표적인 타입
- char
- String

### String은 참조형인데 기본 타입 처럼 사용할 수 있는 이유
- 자바에서 "hello" -> new String("hello") 변경 해준다.

## String 클래스 구조
### 속성(필드)
- 문자 데이터 자체는 char[]에 저장
- 자바 9부터 byte[] 사용
  - 영어 숫자면 1바이트를 사용하여 최적화 하기 위해

### 기능(메서드)
- 대표 기능
  - `length()` : 문자열의 길이를 반환한다.
  - `charAt(int index)` : 특정 인덱스의 문자를 반환한다.
  - `substring(int beginIndex, int endIndex)` : 문자열의 부분 문자열을 반환한다.
  - `indexOf(String str)` : 특정 문자열이 시작되는 인덱스를 반환한다.
  - `toLowerCase()` , `toUpperCase()` : 문자열을 소문자 또는 대문자로 변환한다.
  - `trim()` : 문자열 양 끝의 공백을 제거한다.
  - `concat(String str)` : 문자열을 더한다.

## String 클래스와 참조형
### String은 클래스인데 + 연산자를 사용할 수 있는 이유
- 참조형은 원칙상 + 연산자를 사용할 수 없다.
- 하지만 String의 경우 자바내에서 +를 사용하면 내부적으로 concat() 메서드를 사용한다.