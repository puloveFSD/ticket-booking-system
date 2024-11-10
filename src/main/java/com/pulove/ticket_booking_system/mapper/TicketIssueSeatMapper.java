package com.pulove.ticket_booking_system.mapper;

import com.pulove.ticket_booking_system.dto.TicketIssueSeatDto;
import com.pulove.ticket_booking_system.entity.Bus;
import com.pulove.ticket_booking_system.entity.Seat;
import com.pulove.ticket_booking_system.entity.TicketIssueSeat;
import com.pulove.ticket_booking_system.entity.Trip;
import com.pulove.ticket_booking_system.exception.BusNotFoundException;
import com.pulove.ticket_booking_system.exception.SeatNotFoundException;
import com.pulove.ticket_booking_system.exception.TripNotFoundException;
import com.pulove.ticket_booking_system.repository.BusRepo;
import com.pulove.ticket_booking_system.repository.SeatRepo;
import com.pulove.ticket_booking_system.repository.TripRepo;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class TicketIssueSeatMapper {
    public static TicketIssueSeatDto TicketIssueSeatToTicketIssueSeatDto(TicketIssueSeat ticketIssueSeat) {
        return TicketIssueSeatDto.builder()
                .ticketIssueSeatIdDto(ticketIssueSeat.getTicketIssueSeatId())
                .seatIdDto(ticketIssueSeat.getTicketIssueSeatId())
                .tripIdDto(ticketIssueSeat.getTrip().getTripId())
                .busIdDto(ticketIssueSeat.getBus().getBusId())
                .build();
    }

    public static TicketIssueSeat TickIssueSeatDtoToTicketIssueSeat(TicketIssueSeatDto ticketIssueSeatDto) {
        final SeatRepo seatRepo = null;
        final TripRepo tripRepo = null;
        final BusRepo busRepo = null;
        Seat seatId = seatRepo.findById(ticketIssueSeatDto.getSeatIdDto()).orElseThrow(() ->
                new SeatNotFoundException("Seat Not found"));
        Bus busId = busRepo.findById(ticketIssueSeatDto.getBusIdDto()).orElseThrow(() ->
                new BusNotFoundException("Bus Not found"));
        Trip tripId = tripRepo.findById(ticketIssueSeatDto.getTripIdDto()).orElseThrow(() ->
                new TripNotFoundException("Trip Not found"));
        return TicketIssueSeat.builder()
                .ticketIssueSeatId(ticketIssueSeatDto.getTicketIssueSeatIdDto())
                .seat(seatId)
                .bus(busId)
                .trip(tripId)
                .build();
    }
}
