package com.pulove.ticket_booking_system.controller;

import com.pulove.ticket_booking_system.Service.TicketIssueService;
import com.pulove.ticket_booking_system.dto.TicketIssueDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/ticket")
public class TicketIssueController {
    private final TicketIssueService ticketIssueService;

    @PostMapping
    public ResponseEntity<?> createTicket(@RequestBody TicketIssueDto ticketIssueDto) {
        ticketIssueService.createTicket(ticketIssueDto);
        return ResponseEntity.ok("Ticket created");
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateTicket(@RequestBody TicketIssueDto ticketIssueDto, @PathVariable("id") Long ticketId) {
        ticketIssueService.updateTicket(ticketIssueDto, ticketId);
        return ResponseEntity.ok("Ticket updated");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTicket(@PathVariable("id") Long ticketId) {
        ticketIssueService.deleteTicket(ticketId);
        return ResponseEntity.ok("Ticket deleted");
    }

    @GetMapping
    public ResponseEntity<?> findAllTickets() {
        return ResponseEntity.ok(ticketIssueService.getAllTickets());

    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findTicketById(@PathVariable("id") Long ticketId) {
        return ResponseEntity.ok(ticketIssueService.getTicket(ticketId));
    }
}
