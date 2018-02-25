package org.evertones.persistence.modules.cashflow;

import org.evertones.model.modules.cashflow.Flow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlowRepository extends JpaRepository<Flow, Integer> {
}
