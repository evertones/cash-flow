package org.evertones.persistence.product;

import org.evertones.model.client.Client;
import org.evertones.model.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>, QueryDslPredicateExecutor<Client> {
}
