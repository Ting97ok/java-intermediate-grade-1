package time;

import java.time.LocalDate;

public class LocalDateMain {
    public static void main(String[] args) {
        LocalDate now = LocalDate.now();
        LocalDate ofDate = LocalDate.of(2020, 1, 29);
        System.out.println("Now: " + now);
        System.out.println("ofDate: " + ofDate);

        // ofDate.plusDays(10); -> 꼭 반환값 존재해야함!!!
        ofDate = ofDate.plusDays(10);
        System.out.println("ofDate2: " + ofDate);
    }
}
