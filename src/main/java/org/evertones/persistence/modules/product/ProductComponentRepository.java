package org.evertones.persistence.modules.product;

import org.evertones.model.modules.product.ProductComponent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

public interface ProductComponentRepository
        extends JpaRepository<ProductComponent, Integer>,
            QueryDslPredicateExecutor<ProductComponent> {
}
