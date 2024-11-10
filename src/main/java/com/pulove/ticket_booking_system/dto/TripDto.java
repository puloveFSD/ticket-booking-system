package com.pulove.ticket_booking_system.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TripDto {
    private Long tripIdDto;
    //   @JsonFormat(shape = JsonFormat.Shape.STRING,pattern ="yyyy-MM-dd" )
    private Date tripDateDto;
    @JsonFormat(pattern = "HH:mm")
    @JsonSetter(nulls = Nulls.SKIP)
    private LocalTime tripDepartureTimeDto;
    @JsonFormat(pattern = "HH:mm")
    @JsonSetter(nulls = Nulls.SKIP)
    private LocalTime tripArrivalTimeDto;
    @NotNull(message = "Please select a location")
    private Long startLocationDtoId;
    private Long destinationDtoId;
    private double ticketPricePerPersonDto;
    @NotNull(message = "Please select bus")
    private Long busIdDto;


}
