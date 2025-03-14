# String 클래스
## String 클래스 - 기본
#### 문자를 다루는 대표적인 타입
- char
- String

#### String은 참조형인데 기본 타입 처럼 사용할 수 있는 이유
- 자바에서 "hello" -> new String("hello") 변경 해준다.

### String 클래스 구조
#### 속성(필드)
- 문자 데이터 자체는 char[]에 저장
- 자바 9부터 byte[] 사용
  - 영어 숫자면 1바이트를 사용하여 최적화 하기 위해

#### 기능(메서드)
- 대표 기능
  - `length()` : 문자열의 길이를 반환한다.
  - `charAt(int index)` : 특정 인덱스의 문자를 반환한다.
  - `substring(int beginIndex, int endIndex)` : 문자열의 부분 문자열을 반환한다.
  - `indexOf(String str)` : 특정 문자열이 시작되는 인덱스를 반환한다.
  - `toLowerCase()` , `toUpperCase()` : 문자열을 소문자 또는 대문자로 변환한다.
  - `trim()` : 문자열 양 끝의 공백을 제거한다.
  - `concat(String str)` : 문자열을 더한다.

### String 클래스와 참조형
#### String은 클래스인데 + 연산자를 사용할 수 있는 이유
- 참조형은 원칙상 + 연산자를 사용할 수 없다.
- 하지만 String의 경우 자바내에서 +를 사용하면 내부적으로 concat() 메서드를 사용한다.

## String 클래스 - 비교
### new Stirng() 비교
- new String()은 새로운 객체를 생성하므로 동일성(`==`)은 false 동등성(`equals()`)은 true

### 문자열 리터럴(`""`), 문자열 풀
- 문자열 리터럴은 문자열 풀(String Pool)에 저장된다.
- 문자열 리터럴이 문자열 풀에 존재하면 새로 생성하지 않고 참조한다.
- 이로인해 메모리 사용률과 문자열 생성 관련 성능이 향상된다.
- 같은 문자열 리터럴의 경우 같은 주소를 참조하므로 동일성(`==`)과 동등성(`equals()`)이 true
- 문자열 풀은 힙 영역을 사용
- 문자열 풀에서 문자를 찾을 때는 해시 알고리즘 사용

### String 비교 시 equals() 사용해야 하는 이유
- 문자열 리터럴로 생성된 String인지 new String()으로 생성된 String인지 구분이 불가능하다.

## String 클래스 - 불변 객체
- 생성 이후 변경 불가능

### String이 불변으로 설계된 이유
- String 인스턴스 값이 변경되면 문자열 풀에 같은 값을 참조하고 있는 다른 변수에 영향을 준다.

## String 클래스 - 주요 메서드
### 문자열 정보 조회
- `length()` : 문자열의 길이를 반환한다.
- `isEmpty()` : 문자열이 비어 있는지 확인한다. (길이가 0)
- `isBlank()` : 문자열이 비어 있는지 확인한다. (길이가 0이거나 공백(Whitespace)만 있는 경우), 자바 11
- `charAt(int index)` : 지정된 인덱스에 있는 문자를 반환한다.

### 문자열 비교
- `equals(Object anObject)` : 두 문자열이 동일한지 비교한다.
- `equalsIgnoreCase(String anotherString)` : 두 문자열을 대소문자 구분 없이 비교한다.
- `compareTo(String anotherString)` : 두 문자열을 사전 순으로 비교한다.
- `compareToIgnoreCase(String str)` : 두 문자열을 대소문자 구분 없이 사전적으로 비교한다.
- `startsWith(String prefix)` : 문자열이 특정 접두사로 시작하는지 확인한다.
- `endsWith(String suffix)` : 문자열이 특정 접미사로 끝나는지 확인한다.

### 문자열 검색
- `contains(CharSequence s)` : 문자열이 특정 문자열을 포함하고 있는지 확인한다.
- `indexOf(String ch)` / `indexOf(String ch, int fromIndex)` : 문자열이 처음 등장하는 위치를 반환한다.
- `lastIndexOf(String ch)` : 문자열이 마지막으로 등장하는 위치를 반환한다.

### 문자열 조작 및 변환
- `substring(int beginIndex)` / `substring(int beginIndex, int endIndex)` : 문자열의 부분 문자열을 반환한다.
- `concat(String str)` : 문자열의 끝에 다른 문자열을 붙인다.
- `replace(CharSequence target, CharSequence replacement)` : 특정 문자열을 새 문자열로 대체 한다.
- `replaceAll(String regex, String replacement)` : 문자열에서 정규 표현식과 일치하는 부분을 새 문자열로 대체한다.
- `replaceFirst(String regex, String replacement)` : 문자열에서 정규 표현식과 일치하는 첫 번째 부분을 새 문자열로 대체한다.
- `toLowerCase()` / `toUpperCase()` : 문자열을 소문자나 대문자로 변환한다.
- `trim()` : 문자열 양쪽 끝의 공백을 제거한다. 단순 `Whitespace` 만 제거할 수 있다.
- `strip()` : `Whitespace` 와 유니코드 공백을 포함해서 제거한다. 자바 11

### 문자열 분할 및 조합
- `split(String regex)` : 문자열을 정규 표현식을 기준으로 분할한다.
- `join(CharSequence delimiter, CharSequence... elements)` : 주어진 구분자로 여러 문자열을 결합한다.

### 기타 유틸리티
- `valueOf(Object obj)` : 다양한 타입을 문자열로 변환한다.
- `toCharArray():` 문자열을 문자 배열로 변환한다.
- `format(String format, Object... args)` : 형식 문자열과 인자를 사용하여 새로운 문자열을 생성한다.
- `matches(String regex)` : 문자열이 주어진 정규 표현식과 일치하는지 확인한다.

## StringBuilder - 가변 String
### 불변인 `String` 클래스 단점
- 문자열 변경 시 새로운 객체를 생성하므로 많은 객체를 생성하고 GC(Garbage Collection)이 발생한다.
- CPU와 메모리 자원을 많이 사용하게 된다.

### StringBuilder
#### 가변(Mutable) vs 불변(Immutable)
- String(불변): 불변한 객체 이므로 안전하나 변경 시 마다 새로운 객체 생성으로 인한 메모리 낭비가 발생한다.
- StringBuilder(가변): 가변한 객체 이므로 불안전하나 변경 시 기존 객체를 변경하므로 메모리 낭비가 발생하지 않는다.
- 문자열 변경이 많은 경우 StringBuilder를 사용하다가 최종 단계의 String으로 변환하여 사용하는 것을 권장한다.

## String 최적화
### 자바의 String 최적화
#### 문자열 리터럴 최적화
- 문자열 리터럴은 결합 연산을 컴파일에 수행한다.

#### String 변수 최적화
- 변수의 경우 컴파일 시점에 알 수 없기 때문에 내부적으로 `StringBuilder`를 사용하여 최적화한다.
- 자바가 최적화 해주기 때문에 간단한 경우에는 `+` 연산자를 사용해도 된다.

### String 최적화가 어려운 경우
- 문자열을 루프안에서 문자열을 더하는 경우에는 자바 최적화가 이루어지지 않는다.
- 반복 횟수 만큼 `StringBuilder`를 생성하므로 성능이 저하된다.
- 이런 경우 `StringBuilder`를 직접 사용하여 최적화 해야 한다.

### StringBuiler를 직접 사용하는 경우
- 반복문에서 반복해서 문자를 연결할 때
- 조건문을 통해 동적으로 문자열을 조합할 때
- 복잡한 문자열의 특정 부분을 변경해야 할 때
- 매우 긴 대용량 문자열을 다룰 때

### StringBuiler vs StringBuffer
- 멀티 쓰레드 환경에서 안전하지만 느린 StringBuffer 불안전 하지만 빠른 StringBuilder

## 메서드 체인닝 - Method Chaining
- 메서드 반환 값을 인스턴스 자신의 참조값을 반환하여 연쇄적인 메서드 사용 하도록 하는 방식
- 메서드 체이닝 기법은 코드를 간결하고 읽기 쉽게 만들어준다.