package org.evertones.persistence.modules.client;

import org.evertones.model.modules.client.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer>, QueryDslPredicateExecutor<Client> {
}
