package org.evertones.persistence.modules.client

import org.evertones.model.modules.client.ClientDetails
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.querydsl.QueryDslPredicateExecutor
import org.springframework.stereotype.Repository

@Repository
trait ClientDetailsRepository extends JpaRepository[ClientDetails, Integer]
    with QueryDslPredicateExecutor[ClientDetails] {
}
