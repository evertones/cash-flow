package org.evertones.unit.util;


import org.evertones.util.RandomDate;
import org.junit.Assert;
import org.junit.Test;

import java.util.Random;
import java.util.stream.IntStream;

public class RandomDateTest {

    Random     random     = new Random();
    RandomDate randomDate = new RandomDate();

    @Test
    public void simpleRandomDayOfMonth() {
        // TODO: Increment this test to check the month and year to assert the correct day range
        IntStream.range(1, 100).forEach(i -> {
            Integer day = randomDate.randomDayOfMonth(randomDate.randomYear(), randomDate.randomMonth());
            Assert.assertTrue("Day of month is in the correct range.", (day > 0 && day <= 31));
        });
    }

    @Test
    public void randomMonth() {
        IntStream.range(1, 100).forEach(i -> {
            Integer month = randomDate.randomMonth();
            Assert.assertTrue("Month is in the correct range.", (month > 0 && month <= 12));
        });
    }

    @Test
    public void randomYear() {
        IntStream.range(1, 1000).forEach(i -> {
            Integer month = randomDate.randomYear();
            Assert.assertTrue("Year is in the correct range.", (month >= 1900 && month <= 2100));
        });
    }

    @Test
    public void randomLocalDate() {
        IntStream.range(1, 100).forEach(i -> {
            Assert.assertNotNull(randomDate.randomLocalDate());
        });
    }

    @Test
    public void isLeapYear() {
        Assert.assertTrue("1980 is a leap year",     randomDate.isLeapYear(1980) == true);
        Assert.assertTrue("1981 is not a leap year", randomDate.isLeapYear(1981) == false);
        Assert.assertTrue("1982 is not a leap year", randomDate.isLeapYear(1982) == false);
        Assert.assertTrue("1983 is not a leap year", randomDate.isLeapYear(1983) == false);
        Assert.assertTrue("1984 is a leap year",     randomDate.isLeapYear(1984) == true);
        Assert.assertTrue("1984 is not a leap year", randomDate.isLeapYear(1985) == false);
    }

}
