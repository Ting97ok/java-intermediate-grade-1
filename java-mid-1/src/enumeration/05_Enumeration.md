# 5. Enumeration

- 열거형이 생긴 이유
    - 고객을 3등급 (BASIC, GOLD, DIAMOND) 로 나누고 등급별로 할인률을 적용하는 시스템.
    - 문자열 (String) 을 사용하는 경우 ‘타입 안정성 부족’ 및 ‘데이터 일관성’ 의 문제 발생 가능성이 높아짐.
        - 타입 안정성 부족 : 오타 등 유효하지 않는 값 입력 가능.
        - 데이터 일관성 : BASIC, basic, Basic 등 다양한 형식의 데이터 입력 가능.
    - 또한 문자열 사용은 유효하지 않은 값을 입력 시 컴파일 오류가 나지 않음.
    
    - 위의 대안으로 문자열 상수 사용 → 미리 선언한 상수를 사용 → 문자열을 직접 사용하는 것보다 안전.
    - but, 문자열 상수도 ‘문자열 (String)’ 이므로 위 문제를 근본적으로 해결 X

- 타입 안전 열거형 패턴 (Type-Safe Enum Pattern)
    - 위 문제를 해결하기 위한 방식 → 이 방식은 나열된 항목만 사용가능.
        - 위의 경우 BASIC, GOLD, DIAMOND 만 사용 가능.
    - 사용 방식은 클래스 생성 후 등급별 상수를 선언.
        - 각각을 상수로 선언하기 위해 static 을 이용해 메소드 영역에 선언하고 final을 이용해 참조값 변경 불가능하게 선언.
        - 애플리케이션 로딩 시점에 3개의 상수는 각각 해당 클래스 타입의 서로 다른 인스턴스 참조값을 가짐.
    
    ```java
    // 타입 안전 열거형 패턴 (Type-Safe Enum Pattern)
    public class ClassGrade {
        public static final ClassGrade BASIC = new ClassGrade(); // x001
        public static final ClassGrade GOLD = new ClassGrade(); // x002
        public static final ClassGrade DIAMOND = new ClassGrade(); // x003
    }
    ```
    
    - 값을 비교할 때는 참조값 비교 (==) 를 사용.
    
    ```java
    public class DiscountService {
        public int discount(ClassGrade classGrade, int price) {
            int discountPercent = 0;
    
            if (classGrade == ClassGrade.BASIC) {
                discountPercent = 10;
            } else if (classGrade == ClassGrade.GOLD) {
                discountPercent = 20;
            } else if (classGrade == ClassGrade.DIAMOND) {
                discountPercent = 30;
            } else {
                System.out.println("할인X");
            }
            return price * discountPercent / 100;
        }
    }
    
    ```
    
    - 이 방식은 외부에서 임의로 인스턴스 생성 가능.
        - 방안으로 클래스 내부에 private 생성자를 추가. → 이후 외부에서 클래스를 생성하면 컴파일 에러.
        
        ```java
        // 타입 안전 열거형 패턴 (Type-Safe Enum Pattern)
        public class ClassGrade {
            public static final ClassGrade BASIC = new ClassGrade(); // x001
            public static final ClassGrade GOLD = new ClassGrade(); // x002
            public static final ClassGrade DIAMOND = new ClassGrade(); // x003
        
            // private 생성자 추가
            private ClassGrade() {}
        }
        ```
        
    - 장점
        - 타입 안정성 향샹 / 제한된 인스턴스 사용 : 클래스 내부에 정의된 인스턴스만 사용 가능하고 외부에서는 임의로 인스턴스 생성이 불가 → 잘못된 값을 사용하면 컴파일 시점에서 에러.
        - 데이터 일관성 : 정해진 객체만 사용 → 데이터의 일관성 보장.
    - 단점
        - 많은 코드를 작성해야 하며 private 추가 등 유의해야 할 사항도 존재
        
    - 리펙토링
        - 어차피 회원 등급에 따라 할인률이 적용됨 → 회원 등급 클래스에서 관리하도록 변경
        
        ```java
        // 할인률은 등급에 따라서 변동
        // 등급 클래스에서 관리 가능
        public class ClassGrade {
            public static final ClassGrade BASIC = new ClassGrade(10); // x001
            public static final ClassGrade GOLD = new ClassGrade(20); // x002
            public static final ClassGrade DIAMOND = new ClassGrade(30); // x003
        
            // 할인률 필드 추가
            private final int discountPercent;
        
            // 생성자를 통해서만 할인률 설정 가능 및 변경 불가능
            private ClassGrade(int discountPercent) {
                this.discountPercent = discountPercent;
            }
        
            public int getDiscountPercent() {
                return discountPercent;
            }
        }
        
        ```
        
        - 위처럼 할인률 필드 추가 및 생성자를 통해 할인률을 설정하면 DiscountService 의 if 문 필요 X
        
        ```java
        public class DiscountService {
        
            // 등급별 할인률 if문 필요 X -> 계산만 하면 됨.
            public int discount(ClassGrade classGrade, int price) {
                return price * classGrade.getDiscountPercent() / 100;
            }
        }
        ```
        

- 열거형 (Enum Type)
    - 자바는 ‘타입 안전 열거형 패턴’ 을 편리하게 사용 가능한 Enum Type을 제공.
    - 자바의 enum은 타입 안정성을 제공하고 코드의 가독성을 높이며 예상 가능한 값들의 집합을 나타냄.
    - 열거형 특징
        - 열거형도 클래스.
        - 자동으로 java.lang.Enum 을 상속 받음.
        - 외부에서 임의로 생성 불가능.
        - 열거형 내부에서 상수로 지정하는 것 외에 직접 생성이 불가능.
    - 아래 두개의 코드는 거의 동일함.
    
    ```java
    public enum Grade {
        BASIC, GOLD, DIAMOND
    }
    ```
    
    ```java
    public class ClassGrade {
        public static final ClassGrade BASIC = new ClassGrade();
        public static final ClassGrade GOLD = new ClassGrade();
        public static final ClassGrade DIAMOND = new ClassGrade();
    
        private ClassGrade() {}
    }
    ```
    
    - 이후 코드는 타입 안전 열거형 패턴과 동일함.
    
    - 주요 메서드
        - values() : 모든 enum 배열을 반환
        - valueOf(String name) : name과 일치하는 enum 반환
        - name() : 이름을 문자열로 반환
        - ordinal() : enum 선언된 순서 반환 (0 부터)
            - ordinal()은 가급적 사용을 하지 않는 것이 좋음. → 순서 반환 이라는 것은 순서가 바뀌면 해당 값이 변동 될 수 있기 때문
        - toString() : 이름을 문자열로 반환 → name()과 비슷하지만 toString()은 직접 오버라이딩이 가능.
        ```java
        public enum Grade {
            BASIC(), GOLD(), DIAMOND();
      
            // toString() 오버라이딩
            public String toString() {
                return name() + "-" + ordinal();
            }
        }
        // Grade.BASIC.name() => BASIC
        // Grade.BASIC.toString() => BASIC-0
        ```
    
    - 장점
        - 타입 안정성 향상 : 열거형은 사전에 정의된 상수들로만 구성되므로, 유효하지 않은 값이 입력될 가능성이 없다. 이런 경우 컴파일 오류가 발생한다.
        - 간결성 및 일관성 : 열거형을 사용하면 코드가 더 간결하고 명확해지며, 데이터의 일관성이 보장된다.
        - 확장성 : 새로운 회원 등급을 타입을 추가하고 싶을 때, ENUM에 새로운 상수를 추가하기만 하면 된다.
    
    - 참고 : import static 을 활용하면 가독성을 더 좋게 만들 수 있음.
    
    ```java
    public class DiscountService {
        public int discount(Grade grade, int price) {
            int discountPercent = 0;
            
            if (grade == Grade.BASIC) {
                discountPercent = 10;
            } else if (grade == Grade.GOLD) {
                discountPercent = 20;
            } else if (grade == Grade.DIAMOND) {
                discountPercent = 30;
            } else {
                System.out.println("할인X");
            }
    
            return price * discountPercent / 100;
        }
    }
    ```
    
    ```java
    import static enumeration.ex3.Grade.*;
    
    public class DiscountService {
        public int discount(Grade grade, int price) {
            int discountPercent = 0;
    
            //enum switch 변경 가능
            if (grade == BASIC) {
                discountPercent = 10;
            } else if (grade == GOLD) {
                discountPercent = 20;
            } else if (grade == DIAMOND) {
                discountPercent = 30;
            } else {
                System.out.println("할인X");
            }
    
            return price * discountPercent / 100;
        }
    }
    ```
    
    - 리펙토링
        - 타입 안전 열거형 패턴과 동일하게 리펙토링
        - 어차피 회원 등급에 따라 할인률이 적용됨 → 회원 등급 클래스에서 관리하도록 변경
        
        ```java
        // 할인률은 등급에 따라서 변동
        // 등급 클래스에서 관리 가능
        public enum Grade {
            BASIC(10), GOLD(20), DIAMOND(30);
        
            // 할인률 필드 추가
            private final int discountPercent;
        
            // 생성자를 통해서만 할인률 설정 가능 및 변경 불가능
            Grade(int discountPercent) {
                this.discountPercent = discountPercent;
            }
        
            public int getDiscountPercent() {
                return discountPercent;
            }
        }
        ```
        
        - 위처럼 할인률 필드 추가 및 생성자를 통해 할인률을 설정하면 DiscountService 의 if 문 필요 X
        
        ```java
        public class DiscountService {
        
            // 등급별 할인률 if문 필요 X -> 계산만 하면 됨.
            public int discount(Grade grade, int price) {
                return price * grade.getDiscountPercent() / 100;
            }
        }
        ```
        
        - 현재 main class
        
        ```java
        public static void main(String[] args) {
                int price = 10000;
        
                DiscountService discountService = new DiscountService();
                int basic = discountService.discount(Grade.BASIC, price);
                int gold = discountService.discount(Grade.GOLD, price);
                int diamond = discountService.discount(Grade.DIAMOND, price);
        
                System.out.println("BASIC 등급의 할인 금액: " + basic);
                System.out.println("GOLD 등급의 할인 금액: " + gold);
                System.out.println("DIAMOND 등급의 할인 금액: " + diamond);
        }
        ```
        
        - 위에서 DiscountService의 계산식도 Enum class에 추가
        
        ```java
        public enum Grade {
            BASIC(10), GOLD(20), DIAMOND(30);
        
            private final int discountPercent;
        
            Grade(int discountPercent) {
                this.discountPercent = discountPercent;
            }
        
            public int getDiscountPercent() {
                return discountPercent;
            }
        
            // 계산식 추가
            public int discount(int price) {
                return price * discountPercent / 100;
            }
        }
        ```
        
        - service도 불필요 → main에서 enum 계산식으로 넘어가면 됨
        
        ```java
        public static void main(String[] args) {
                int price = 10000;
        
                // DiscountService 도 불필요 -> 바로 Enum으로 넘어가면 됨
                System.out.println("BASIC 등급의 할인 금액: " + Grade.BASIC.discount(price));
                System.out.println("GOLD 등급의 할인 금액: " + Grade.GOLD.discount(price));
                System.out.println("DIAMOND 등급의 할인 금액: " + Grade.DIAMOND.discount(price));
        }
        ```