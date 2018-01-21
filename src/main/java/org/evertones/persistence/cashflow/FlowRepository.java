package org.evertones.persistence.cashflow;

import org.evertones.model.cashflow.Flow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlowRepository extends JpaRepository<Flow, Integer> {
}
