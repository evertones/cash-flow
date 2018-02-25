package org.evertones.persistence.modules.cashflow;

import org.evertones.model.modules.cashflow.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DefaultItemRepository extends JpaRepository<Item, Integer> {
}
