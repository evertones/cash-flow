package org.evertones.persistence.modules.product


import org.evertones.model.modules.product.Product
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.querydsl.QueryDslPredicateExecutor

trait ProductRepository extends JpaRepository[Product, Integer]
        with QueryDslPredicateExecutor[Product] {

}
