package com.pulove.ticket_booking_system.controller;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.pulove.ticket_booking_system.Service.TicketIssueSeatService;
import com.pulove.ticket_booking_system.dto.TicketIssueSeatDto;
import com.pulove.ticket_booking_system.entity.TicketIssueSeat;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/booked")
public class TicketIssueSeatController {
    private final TicketIssueSeatService ticketIssueSeatService;

    @PostMapping
    public ResponseEntity<?> saveTicketIssueSeat(@RequestBody TicketIssueSeatDto ticketIssueSeatDto) {
        ticketIssueSeatService.createTicketIssueSeat(ticketIssueSeatDto);
        return ResponseEntity.ok("Ticket Issue Seat Saved");
    }

    @GetMapping
    public ResponseEntity<?> findAllTicketIssueSeats() {
        return ResponseEntity.ok(ticketIssueSeatService.findAllTicketIssueSeat());

    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findTicketIssueSeatById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(ticketIssueSeatService.findTicketIssueSeatById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateTicketIssueSeat(@RequestBody TicketIssueSeatDto ticketIssueSeatDto, @PathVariable("id") Long ticketIssueSeatIdDto) {
        ticketIssueSeatService.updateTicketIssueSeat(ticketIssueSeatDto, ticketIssueSeatIdDto);
        return ResponseEntity.ok("Ticket Issue Seat Updated");
    }

}
