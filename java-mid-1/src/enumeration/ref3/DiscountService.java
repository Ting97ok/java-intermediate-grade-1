package enumeration.ref3;

public class DiscountService {

    // 계산식도 불필요
    public int discount(Grade grade, int price) {
        return grade.discount(price);
    }
}
