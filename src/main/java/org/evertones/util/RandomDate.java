package org.evertones.util;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Random;
import java.util.List;

public class RandomDate {

    private Random random = new Random();

    public Integer randomMonth() {
        return random.nextInt(12) + 1;
    }

    public Integer randomYear() {
        return 1900 + random.nextInt(120);
    }

    public Integer randomDayOfMonth(Integer year, Integer month) {
        Integer day;

        List<Integer> months = Arrays.asList(1,3,5,7,8,10,12);

        if (months.contains(month)) {
            // Months Jan, Mar, May, Jul, Ago, Oct, Dec
            day = random.nextInt(31) + 1;
        } else {
            if (month == 2) {
                if (isLeapYear(year)) {
                    day = random.nextInt(29) + 1;
                } else {
                    day = random.nextInt(28) + 1;
                }
            } else {
                // Months Apr, Jun, Sep, Nov, except Feb
                day = random.nextInt(30) + 1;
            }
        }
        return day;
    }

    public LocalDate randomLocalDate() {
        Integer year  = randomYear();
        Integer month = randomMonth();
        Integer day   = randomDayOfMonth(year, month);

        return LocalDate.of(year, month, day);
    }

    public Boolean isLeapYear(Integer year) {
        Boolean leapYear = false;
        if((year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0))){
            leapYear = true;
        }
        return leapYear;
    }

}
