package com.pulove.ticket_booking_system.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TicketIssueSeatDto {
    private Long ticketIssueSeatIdDto;
    private Long seatIdDto;
    private Long tripIdDto;
    private Long busIdDto;


}
