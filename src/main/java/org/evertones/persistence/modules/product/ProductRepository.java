package org.evertones.persistence.modules.product;

import org.evertones.model.modules.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>, QueryDslPredicateExecutor<Product> {
}
