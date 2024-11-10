package com.pulove.ticket_booking_system.Service;

import com.pulove.ticket_booking_system.dto.TicketIssueDto;
import com.pulove.ticket_booking_system.dto.TicketIssueResponseDto;

import java.util.List;

public interface TicketIssueService {
    void createTicket(TicketIssueDto ticketIssueDto);

    void updateTicket(TicketIssueDto ticketIssueDto, Long ticketIdDto);

    void deleteTicket(Long ticketIdDto);

    TicketIssueDto getTicket(Long ticketIdDto);

    List<TicketIssueResponseDto> getAllTickets();
}
