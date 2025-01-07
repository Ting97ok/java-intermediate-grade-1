package time;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class LocalDateTimeMain {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime ofDate = LocalDateTime.of(2020, 01, 29, 8, 10 ,1);
        System.out.println("now: " + now);
        System.out.println("ofDate: " + ofDate);

        // 날짜와 시간 분리
        LocalDate localDate = ofDate.toLocalDate();
        LocalTime localTime = ofDate.toLocalTime();
        System.out.println("localDate: " + localDate);
        System.out.println("localTime: " + localTime);

        // 날짜와 시간 병합
        LocalDateTime localDateTime = LocalDateTime.of(localDate, localTime);
        System.out.println("localDateTime: " + localDateTime);

        // 계산(불변)
        LocalDateTime ofDtPlusDays = ofDate.plusDays(1000);
        System.out.println("ofDtPlus: " + ofDtPlusDays);
        LocalDateTime ofDtPlusYears = ofDate.plusYears(1);
        System.out.println("ofDtPlusYears: " + ofDtPlusYears);

        // 비교
        System.out.println("현재 날짜 시간이 지정 날짜 시간보다 이전인가? " + now.isBefore(ofDate));
        System.out.println("현재 날짜 시간이 지정 날짜 시간보다 이후인가? " + now.isAfter(ofDate));
        System.out.println("현재 날짜 시간이 지정 날짜 시간보다 동일한가? " + now.isEqual(ofDate));
    }
}
