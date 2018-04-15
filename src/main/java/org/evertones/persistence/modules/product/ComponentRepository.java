package org.evertones.persistence.modules.product;

import org.evertones.model.modules.product.Component;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

public interface ComponentRepository
        extends JpaRepository<Component, Integer>,
            QueryDslPredicateExecutor<Component> {
}
