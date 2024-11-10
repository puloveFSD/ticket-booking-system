package com.pulove.ticket_booking_system.mapper;

import com.pulove.ticket_booking_system.dto.BusDto;
import com.pulove.ticket_booking_system.dto.TripDto;
import com.pulove.ticket_booking_system.dto.TripResponseDto;
import com.pulove.ticket_booking_system.entity.Trip;

public class TripMapper {
    public static TripDto mapTripToTripDto(Trip trip) {

        BusDto busDto = null;
        if (trip.getBus() != null) {
            busDto = BusMapper.mapBusToBusDto(trip.getBus());
        }

        return TripDto.builder()
                .tripIdDto(trip.getTripId())
                .tripDateDto(trip.getTripDate())
                .tripArrivalTimeDto(trip.getTripArrivalTime())
                .tripDepartureTimeDto(trip.getTripDepartureTime())
                .startLocationDtoId(trip.getStartLocationId().getLocationId())
                .destinationDtoId(trip.getTripDestinationId().getLocationId())
                .ticketPricePerPersonDto(trip.getTicketPricePerPerson())
                .busIdDto(trip.getBus().getBusId())
                .build();

//        return TripResponseDto.builder()
//                .tripIdDto(trip.getTripId())
//                .tripDateDto(trip.getTripDate())
//                .tripArrivalTimeDto(trip.getTripArrivalTime())
//                .tripDepartureTimeDto(trip.getTripDepartureTime())
//                .busDto(busDto)
//
//                .build();

    }

//    public static Trip mapTripDtoToTrip(TripDto tripDto) {
//        return Trip.builder()
//                .tripId(tripDto.getTripIdDto())
//                .tripDate(tripDto.getTripDateDto())
//                .tripArrivalTime(tripDto.getTripArrivalTimeDto())
//                .tripDepartureTime(tripDto.getTripDepartureTimeDto())
//                .bus(Bus.builder()
//                        .busId(tripDto.getBusDto().getBusIdDto())
//                        .busOperatorName(tripDto.getBusDto().getBusOperatorNameDto())
//                        .busNumber(tripDto.getBusDto().getBusNumberDto())
//                        .busType(tripDto.getBusDto().getBusTypeDto())
//                        .busTotalSeats(tripDto.getBusDto().getBusTotalSeatsDto())
//                        .build())
//                .route(Route.builder()
//                        .routeId(tripDto.getRouteDto().getRouteIdDto())
//                        .startLocation(tripDto.getRouteDto().getRouteStartLocationDto())
//                        .endLocation(tripDto.getRouteDto().getRouteEndLocationDto())
//                        .expectedDurationOfTravel(tripDto.getRouteDto().getRouteExpectedDurationOfTravelDto())
//                        .build())
//                //.bus(Bus.builder().busId(tripDto.getBusIdDto()).build())
//                //.route(Route.builder().routeId(tripDto.getRouteIdDto()).build())
//                .build();
//    }
}
