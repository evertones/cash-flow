package org.evertones.generator.cashflow;

import org.evertones.generator.BaseGenerator;
import org.evertones.model.cashflow.Period;
import org.evertones.util.Random;

public class PeriodGenerator implements BaseGenerator<Period> {

    @Override
    public Period generate() {
        Period period = new Period();

        //period.setId(Random.random.nextInt());
        period.setMonth(randomMonth());
        period.setYear(randomYear());
        period.setBalancePeriod(Random.randomValue());
        period.setBalanceFinal(Random.randomValue());

        return period;
    }

    private Short randomMonth() {
        return Short.valueOf(String.valueOf(Random.random.nextInt(13)));
    }

    private Short randomYear() {
        Integer year = 1900 + Random.random.nextInt(120);
        return Short.valueOf(String.valueOf(year));
    }
}
