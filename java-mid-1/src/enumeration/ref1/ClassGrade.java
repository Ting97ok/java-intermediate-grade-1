package enumeration.ref1;

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
