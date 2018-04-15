package org.evertones.persistence.modules.product

import org.evertones.model.modules.product.Component
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.querydsl.QueryDslPredicateExecutor

trait ComponentRepository extends JpaRepository[Component, Integer]
        with QueryDslPredicateExecutor[Component] {

}
