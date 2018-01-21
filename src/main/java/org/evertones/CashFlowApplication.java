package org.evertones;

import org.evertones.generator.cashflow.DefaultItemGenerator;
import org.evertones.generator.cashflow.PeriodGenerator;
import org.evertones.persistence.cashflow.DefaultItemRepository;
import org.evertones.persistence.cashflow.PeriodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.stream.IntStream;

@SpringBootApplication
public class CashFlowApplication implements CommandLineRunner {

//	private FlowRepository flowRepository;
	private DefaultItemRepository itemRepository;
	private PeriodRepository periodRepository;

//	@Autowired
//	public void setFlowRepository(FlowRepository flowRepository) {
//		this.flowRepository = flowRepository;
//	}

	@Autowired
	public void setItemRepository(DefaultItemRepository itemRepository) {
		this.itemRepository = itemRepository;
	}

	@Autowired
	public void setPeriodRepository(PeriodRepository periodRepository) {
		this.periodRepository = periodRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(CashFlowApplication.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {
		DefaultItemGenerator itemGenerator = new DefaultItemGenerator();
		PeriodGenerator periodGenerator = new PeriodGenerator();

		IntStream.range(1, 10).forEach(item -> {
			itemRepository.save(itemGenerator.generate());
		});

		IntStream.range(1, 10).forEach(period -> {
			periodRepository.save(periodGenerator.generate());
		});

//        flowRepository.save(new FlowGenerator().generate());
//        flowRepository.save(new FlowGenerator().generate());
//        flowRepository.save(new FlowGenerator().generate());
//        flowRepository.save(new FlowGenerator().generate());
//        flowRepository.save(new FlowGenerator().generate());
//        flowRepository.save(new FlowGenerator().generate());
//        flowRepository.save(new FlowGenerator().generate());
//        flowRepository.save(new FlowGenerator().generate());
//        flowRepository.save(new FlowGenerator().generate());
//        flowRepository.save(new FlowGenerator().generate());
	}

}