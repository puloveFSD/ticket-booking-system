package com.pulove.ticket_booking_system.repository;

import com.pulove.ticket_booking_system.entity.TicketIssueSeat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TicketIssueSeatRepo extends JpaRepository<TicketIssueSeat, Long> {

    @Query(value = "select seat_id from tbl_ticket_issue_seat where ticket_issue_id = ?1", nativeQuery = true)
    List<Integer> getSeatNumbersByTicketIssueId(Long ticketId);

    @Modifying
    void deleteAllByTicketIssue_TicketId(Long ticketId);
}
