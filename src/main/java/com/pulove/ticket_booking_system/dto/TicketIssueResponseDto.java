package com.pulove.ticket_booking_system.dto;

import lombok.*;

import java.time.LocalTime;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TicketIssueResponseDto {

    private Long issueId;
    private Long numberOfPassenger;
    private Double totalAmount;
    private String contactPersonName;
    private String contactPersonNumber;
    private List<Integer> seatNumberList;

    private Long tripId;
    private Date tripDate;
    private LocalTime departureTime;
    private String destination;
    private String startLocation;
    private String pickupLocation;

    private BusDto busDto;

}
