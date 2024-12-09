package com.pulove.ticket_booking_system.mapper;

import com.pulove.ticket_booking_system.dto.SeatDto;
import com.pulove.ticket_booking_system.entity.Seat;

public  class SeatMapper {
    public static SeatDto seatToSeatDto(Seat seat) {
        return SeatDto.builder()
                .setIdDto(seat.getSeatId())
                .seatNumberDto(seat.getSeatNumber())
                .busIdDto(seat.getBus().getBusId())
                .build();
    }

//    public static Seat seatDtoToSeat(SeatDto seatDto) {
//        return Seat.builder()
//                .seatId(seatDto.getBusIdDto())
//                .seatNumber(seatDto.getSeatNumberDto())
//
//                .build();
//    }
}
