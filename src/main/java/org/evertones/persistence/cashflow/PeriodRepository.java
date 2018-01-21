package org.evertones.persistence.cashflow;

import org.evertones.model.cashflow.Period;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeriodRepository extends JpaRepository<Period, Integer> {
}
