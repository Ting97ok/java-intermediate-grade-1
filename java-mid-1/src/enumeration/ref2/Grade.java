package enumeration.ref2;

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
