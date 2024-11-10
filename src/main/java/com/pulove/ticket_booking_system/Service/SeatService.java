package com.pulove.ticket_booking_system.Service;


import com.pulove.ticket_booking_system.dto.SeatDto;
import com.pulove.ticket_booking_system.entity.Seat;

import java.util.List;

public interface SeatService {
    void createSeat(SeatDto seatDto);

    void deleteSeat(Long seatIdDto);

    SeatDto getSeatById(Long seatIdDto);

    List<SeatDto> getAllSeats();

    void updateSeat(SeatDto seatDto, Long seatIdDto);

}
