package org.evertones.dataset.generator.modules.cashflow;

import org.evertones.dataset.generator.BaseGenerator;
import org.evertones.model.modules.cashflow.Period;
import org.evertones.dataset.generator.util.RandomDate;

import java.util.Random;

public class PeriodGenerator implements BaseGenerator<Period> {

    Random     random     = new Random();
    RandomDate randomDate = new RandomDate();

    @Override
    public Period generate() {
        Period period = new Period();

        //period.setId(RandomText.random.nextInt());
        period.setMonth(randomDate.randomMonth());
        period.setYear(randomDate.randomYear());
        period.setBalancePeriod(random.nextDouble());
        period.setBalanceFinal(random.nextDouble());

        return period;
    }

}
