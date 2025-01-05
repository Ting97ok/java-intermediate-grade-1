package enumeration.ref2;

public class DiscountService {

    // 등급별 할인률 if문 필요 X -> 계산만 하면 됨.
    public int discount(Grade grade, int price) {
        return price * grade.getDiscountPercent() / 100;
    }
}
