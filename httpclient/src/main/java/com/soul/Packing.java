package com.soul;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class Packing {
    public static void main(String[] args) {
        testPacking();
    }

    private static void testPacking() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDate localDate = LocalDate.now();
        String s = localDate.format(formatter);
        System.out.println(s);

        LocalDateTime dt = LocalDateTime.now();
        System.out.println(dt.getYear());
        System.out.println(dt.getDayOfMonth());
        System.out.println(dt.getHour());
        System.out.println(dt.getMinute());

        System.out.println(dt.minusDays(1));
    }
}
