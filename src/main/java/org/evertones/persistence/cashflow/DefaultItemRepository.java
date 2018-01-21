package org.evertones.persistence.cashflow;

import org.evertones.model.cashflow.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DefaultItemRepository extends JpaRepository<Item, Integer> {
}
