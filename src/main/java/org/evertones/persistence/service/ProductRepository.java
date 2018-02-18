package org.evertones.persistence.service;

import org.evertones.model.service.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
