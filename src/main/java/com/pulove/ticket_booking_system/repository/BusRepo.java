package com.pulove.ticket_booking_system.repository;

import com.pulove.ticket_booking_system.entity.Bus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BusRepo extends JpaRepository<Bus, Long> {

}
