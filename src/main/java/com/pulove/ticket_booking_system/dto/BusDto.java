package com.pulove.ticket_booking_system.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BusDto {
    private Long busIdDto;
    private String busOperatorNameDto;
    private String busNumberDto;
    private String busTypeDto;
    private int busTotalSeatsDto;



}
