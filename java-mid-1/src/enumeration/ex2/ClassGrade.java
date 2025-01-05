package enumeration.ex2;

// 타입 안전 열거형 패턴 (Type-Safe Enum Pattern)
public class ClassGrade {
    public static final ClassGrade BASIC = new ClassGrade(); // x001
    public static final ClassGrade GOLD = new ClassGrade(); // x002
    public static final ClassGrade DIAMOND = new ClassGrade(); // x003

    // private 생성자 추가
    private ClassGrade() {}
}
