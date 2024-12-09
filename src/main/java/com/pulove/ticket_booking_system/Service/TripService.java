package com.pulove.ticket_booking_system.Service;

import com.pulove.ticket_booking_system.dto.TripDto;
import com.pulove.ticket_booking_system.dto.TripResponseDto;
import com.pulove.ticket_booking_system.entity.Trip;
import org.springframework.stereotype.Service;

import java.util.List;

public interface TripService {
    List<TripDto> getAllTrip();

    TripDto getTripById(Long id);

    void createTrip(TripDto tripDto);

    void updateTrip(TripDto tripDto, Long tripId);

    void deleteTrip(Long tripId);

    List<Trip> getByStartLocationIdAndTripDestinationId(Long startId, Long destinationId);
}
