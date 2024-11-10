package com.pulove.ticket_booking_system.exception;

public class TicketIssueSeatNotFoundException extends RuntimeException {
    public TicketIssueSeatNotFoundException(String message) {
        super(message);
    }
}
