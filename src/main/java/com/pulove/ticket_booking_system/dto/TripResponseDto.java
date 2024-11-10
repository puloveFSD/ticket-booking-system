package com.pulove.ticket_booking_system.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.pulove.ticket_booking_system.entity.LocationMaster;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TripResponseDto {
    private Long tripIdDto;
    //   @JsonFormat(shape = JsonFormat.Shape.STRING,pattern ="yyyy-MM-dd" )
    private Date tripDateDto;
    @JsonFormat(pattern = "HH:mm")
    @JsonSetter(nulls = Nulls.SKIP)
    private LocalTime tripDepartureTimeDto;
    @JsonFormat(pattern = "HH:mm")
    @JsonSetter(nulls = Nulls.SKIP)
    private LocalTime tripArrivalTimeDto;
    private LocationMaster startLocationDtoId;
    private LocationMaster destinationDtoId;
    private BusDto busDto;
}
