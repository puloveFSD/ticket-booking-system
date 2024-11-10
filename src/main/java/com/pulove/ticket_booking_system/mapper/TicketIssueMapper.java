package com.pulove.ticket_booking_system.mapper;

import com.pulove.ticket_booking_system.dto.BusDto;
import com.pulove.ticket_booking_system.dto.TicketIssueDto;
import com.pulove.ticket_booking_system.dto.TicketIssueResponseDto;
import com.pulove.ticket_booking_system.entity.Bus;
import com.pulove.ticket_booking_system.entity.TicketIssue;
import com.pulove.ticket_booking_system.entity.Trip;
import com.pulove.ticket_booking_system.entity.User;
import com.pulove.ticket_booking_system.exception.BusNotFoundException;
import com.pulove.ticket_booking_system.exception.TripNotFoundException;
import com.pulove.ticket_booking_system.exception.UserNotFound;
import com.pulove.ticket_booking_system.repository.BusRepo;
import com.pulove.ticket_booking_system.repository.SeatRepo;
import com.pulove.ticket_booking_system.repository.TripRepo;
import com.pulove.ticket_booking_system.repository.UserRepo;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class TicketIssueMapper {

    public static TicketIssueResponseDto mapTicketIssueToDto(TicketIssue ticketIssue) {
        Trip trip = ticketIssue.getTrip();
        Bus bus = ticketIssue.getBus();
        BusDto busDto = BusDto.builder()
                .busIdDto(bus.getBusId())
                .busOperatorNameDto(bus.getBusOperatorName())
                .busNumberDto(bus.getBusNumber())
                .busTypeDto(bus.getBusType())
                .build();
        return TicketIssueResponseDto.builder()
                .issueId(ticketIssue.getTicketId())
                .numberOfPassenger(ticketIssue.getNumberOfPassenger())
                .totalAmount(ticketIssue.getTotalAmount())
                .contactPersonName(ticketIssue.getContactPerson())
                .contactPersonNumber(ticketIssue.getContactPersonPhoneNumber())

                .tripId(trip.getTripId())
                .tripDate(trip.getTripDate())
                .departureTime(trip.getTripDepartureTime())
                .destination(trip.getTripDestinationId().getLocationName())
                .startLocation(trip.getStartLocationId().getLocationName())
                .pickupLocation(ticketIssue.getPickUpLocation())


                .busDto(busDto)
                .build();
    }

    public static TicketIssueDto ticketToTicketDto(TicketIssue ticket) {
        return TicketIssueDto.builder()
                .ticketIdDto(ticket.getTicketId())
                .busIdDto(ticket.getBus().getBusId())
                .tripIdDto(ticket.getTrip().getTripId())
                .numberOfPassengerDto(ticket.getNumberOfPassenger())
                .totalAmountDto(ticket.getTotalAmount())
                .pickUpLocationDto(ticket.getPickUpLocation())
                .issuedByIdDto(ticket.getTicketId())
                .issuedDateDto(ticket.getIssuedDate())
                .contactPersonDto(ticket.getContactPerson())
                .contactPersonPhoneNumberDto(ticket.getContactPersonPhoneNumber())
                .build();
    }

//    public static TicketIssue ticketDtoToTicket(TicketIssueDto dto) {
////        final BusRepo busRepo = null;
////        final UserRepo userRepo = null;
////        final TripRepo tripRepo = null;
////
////        Bus busId = busRepo.findById(dto.getBusIdDto()).orElseThrow(() -> new BusNotFoundException("Bus not found"));
////        Trip tripId = tripRepo.findById(dto.getTripIdDto()).orElseThrow(() -> new TripNotFoundException("Trip not found"));
////        User userId = userRepo.findById(dto.getIssuedByIdDto()).orElseThrow(() ->
////                new UserNotFound("User not found for id: " + dto.getIssuedByIdDto()));
////
////        return TicketIssue.builder()
////                .ticketId(dto.getTicketIdDto())
////                .bus(busId)
////                .trip(tripId)
////                .issuedBy(userId)
////                .build();

}
