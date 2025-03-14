## Class 클래스
- 자바에서 `Class`클래스는 클래스의 정보(메타데이터)를 다루는데 사용된다.
- `Class`클래스를 통해 실행 중인 자바 애플리케이션 내에 필요한 클래스의 속성과 메소드 정보를 조회하고 조작할 수 있다.

### Class 클래스의 주요 기능
- 타입 정보 얻기: 클래스의 이름, 부모클래스, 인터페이스, 접근 제한자 등과 같은 정보 조회 가능
- 리플렉션: 클래스의 생성자, 필드, 메소드 정보를 조회하고 이를 이용해 인스턴스를 생성하거나 메소드 호출 작업 가능
- 동적 로딩과 생성: `Class.forName()` 메소드를 이용해 동적으로 클래스를 로드하고, `newInstance()` 메소드를 이용해 인스턴스를 생성할 수 있다.
- 애노테이션 처리: 클래스에 적용된 애노테이션(Annotation) 정보를 조회하고 처리하는 기능 제공

### Class 클래스의 주요 메소드
- **getDeclaredFields()**: 클래스의 모든 필드를 조회한다.
  - 실제 사례로 알리고 연동 때 파라미터로 전달받은 클래스를 MultipartData로 변환하는 유틸 메서드를 만들 때 사용했었다.
- **getDeclaredMethods()**: 클래스의 모든 메서드를 조회한다.
- **getSuperclass()**: 클래스의 부모 클래스를 조회한다.
- **getInterfaces()**: 클래스의 인터페이스들을 조회한다.