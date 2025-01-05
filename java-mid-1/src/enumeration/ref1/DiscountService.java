package enumeration.ref1;

public class DiscountService {

    // 등급별 할인률 if문 필요 X -> 계산만 하면 됨.
    public int discount(ClassGrade classGrade, int price) {
        return price * classGrade.getDiscountPercent() / 100;
    }
}
