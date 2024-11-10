package com.pulove.ticket_booking_system.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class SeatDto {
    private Long setIdDto;
    private String seatNumberDto;
    private Long busIdDto;
}
