# 4-3. System

- 시스템과 관련된 기본 기능들을 제공
- 주요기능
    - 표준 입력, 표준 출력, 오류 스트림 : System.in , System.out , System.err 은 각각 표준 입력, 표준 출력, 표준오류 스트림을 나타낸다.
    - 시간 측정 : System.currentTimeMillis() 와 System.nanoTime() 은 현재 시간을 밀리초 또는 나노초 단위로 제공한다.
    - 환경 변수 : System.getenv() 메서드를 사용하여 OS에서 설정한 환경 변수의 값을 얻을 수 있다.
    - 시스템 속성 : System.getProperties() 를 사용해 현재 시스템 속성을 얻거나System.getProperty(String key) 로 특정 속성을 얻을 수 있다.
        - 시스템 속성은 자바에서 사용하는 설정값이다.
    - 시스템 종료 : `System.exit(int status)` 메서드는 프로그램을 종료하고, OS에 프로그램 종료의 상태 코드를 전달한다.
        - 상태코드가 0이 정상 / 0이 아니면 비정상
    - 배열 고속 복사 : System.arraycopy 는 시스템 레벨에서 최적화된 메모리 복사 연산을 사용한다. 직접 반복문을 사용해서 배열을 복사할 때 보다 수 배 이상 빠른 성능을 제공한다.