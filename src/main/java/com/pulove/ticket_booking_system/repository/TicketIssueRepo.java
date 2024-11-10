package com.pulove.ticket_booking_system.repository;


import com.pulove.ticket_booking_system.entity.TicketIssue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TicketIssueRepo extends JpaRepository<TicketIssue, Long> {

    @Query("Select ti from TicketIssue ti join fetch ti.bus join fetch ti.trip tp join fetch tp.startLocationId join fetch tp.tripDestinationId ")
    List<TicketIssue> getAllTicketIssueDate();
}
