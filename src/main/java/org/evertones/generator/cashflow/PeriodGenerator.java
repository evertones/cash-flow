package org.evertones.generator.cashflow;

import org.evertones.generator.BaseGenerator;
import org.evertones.model.cashflow.Period;
import org.evertones.util.RandomDate;

import java.util.Random;

public class PeriodGenerator implements BaseGenerator<Period> {

    Random     random     = new Random();
    RandomDate randomDate = new RandomDate();

    @Override
    public Period generate() {
        Period period = new Period();

        //period.setId(RandomString.random.nextInt());
        period.setMonth(randomDate.randomMonth());
        period.setYear(randomDate.randomYear());
        period.setBalancePeriod(random.nextDouble());
        period.setBalanceFinal(random.nextDouble());

        return period;
    }

}
