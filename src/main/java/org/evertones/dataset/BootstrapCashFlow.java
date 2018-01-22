package org.evertones.dataset;

import org.evertones.generator.cashflow.DefaultItemGenerator;
import org.evertones.generator.cashflow.PeriodGenerator;
import org.evertones.persistence.cashflow.DefaultItemRepository;
import org.evertones.persistence.cashflow.PeriodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.IntStream;

@Component
public class BootstrapCashFlow {

    private DefaultItemRepository itemRepository;
    private PeriodRepository periodRepository;

    @Autowired
    public void setItemRepository(DefaultItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Autowired
    public void setPeriodRepository(PeriodRepository periodRepository) {
        this.periodRepository = periodRepository;
    }

    public void create() {
        DefaultItemGenerator itemGenerator = new DefaultItemGenerator();
        PeriodGenerator periodGenerator = new PeriodGenerator();

        IntStream.range(1, 10).forEach(item -> {
            itemRepository.save(itemGenerator.generate());
        });

        IntStream.range(1, 10).forEach(period -> {
            periodRepository.save(periodGenerator.generate());
        });
    }

}
