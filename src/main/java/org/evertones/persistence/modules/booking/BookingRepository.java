package org.evertones.persistence.modules.booking;

import org.evertones.model.service.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

public interface BookingRepository extends JpaRepository<Booking, Integer>, QueryDslPredicateExecutor<Booking> {
}
