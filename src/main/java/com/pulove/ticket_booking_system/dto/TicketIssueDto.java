package com.pulove.ticket_booking_system.dto;

import com.pulove.ticket_booking_system.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TicketIssueDto {
    private Long ticketIdDto;
    private Long numberOfPassengerDto=0L;
    private double totalAmountDto;
    private String pickUpLocationDto;
    private Date issuedDateDto;
    private Long issuedByIdDto;
    private String contactPersonDto;
    private String contactPersonPhoneNumberDto;
    private Long busIdDto;
    private Long tripIdDto;
    private List<Long> seatList;



}
