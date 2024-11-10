package com.pulove.ticket_booking_system.Service;

import com.pulove.ticket_booking_system.dto.TicketIssueSeatDto;
import com.pulove.ticket_booking_system.entity.TicketIssueSeat;

import java.util.List;

public interface TicketIssueSeatService {
    void createTicketIssueSeat(TicketIssueSeatDto ticketIssueSeatDto);
    void updateTicketIssueSeat(TicketIssueSeatDto ticketIssueSeatDto, Long ticketIssueSeatId);
    TicketIssueSeatDto findTicketIssueSeatById(Long ticketIssueSeatId);
    List<TicketIssueSeatDto> findAllTicketIssueSeat();
    void deleteTicketIssueSeat(Long ticketIssueSeatId);
}
