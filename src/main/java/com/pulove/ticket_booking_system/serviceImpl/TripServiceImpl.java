package com.pulove.ticket_booking_system.serviceImpl;

import com.pulove.ticket_booking_system.Service.TripService;
import com.pulove.ticket_booking_system.dto.TripDto;

import com.pulove.ticket_booking_system.dto.TripResponseDto;
import com.pulove.ticket_booking_system.entity.Bus;
import com.pulove.ticket_booking_system.entity.LocationMaster;
import com.pulove.ticket_booking_system.entity.Trip;
import com.pulove.ticket_booking_system.exception.BusNotFoundException;
import com.pulove.ticket_booking_system.exception.LocationNotFoundException;
import com.pulove.ticket_booking_system.exception.TripNotFoundException;
import com.pulove.ticket_booking_system.mapper.TripMapper;
import com.pulove.ticket_booking_system.repository.BusRepo;
import com.pulove.ticket_booking_system.repository.LocationMasterRepo;
import com.pulove.ticket_booking_system.repository.TripRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TripServiceImpl implements TripService {

    private final TripRepo tripRepo;
    private final BusRepo busRepo;
    private final LocationMasterRepo locationMasterRepo;


    @Override
    public List<TripDto> getAllTrip() {
        return tripRepo.findAllTrips()
                .stream().map(TripMapper::mapTripToTripDto).collect(Collectors.toList());
    }

    @Override
    public TripDto getTripById(Long tripId) {

        return TripMapper.mapTripToTripDto(tripRepo.findById(tripId).orElseThrow(() ->
                new TripNotFoundException("Trip for id " + tripId + " not found")));
    }

    @Override
    public void createTrip(TripDto tripDto) {
        // is bus id valid
        Bus busById = busRepo.findById(tripDto.getBusIdDto()).orElseThrow(() -> new BusNotFoundException("Bus details not found"));
        //is location id valid
        LocationMaster startLocation = locationMasterRepo.findById(tripDto.getStartLocationDtoId()).orElseThrow(() -> new LocationNotFoundException("Start location not found"));
        LocationMaster destinationLocation = locationMasterRepo.findById(tripDto.getDestinationDtoId()).orElseThrow(() -> new LocationNotFoundException("Destination location not found"));

        Trip trip = Trip.builder()
                .tripDate(tripDto.getTripDateDto())
                .tripDepartureTime(tripDto.getTripDepartureTimeDto())
                .tripArrivalTime(tripDto.getTripArrivalTimeDto())
                .startLocationId(startLocation)
                .tripDestinationId(destinationLocation)
                .ticketPricePerPerson(tripDto.getTicketPricePerPersonDto())
                .bus(busById)
                .build();
        if (Objects.nonNull(tripDto.getTripIdDto())) {
            Trip tripById = tripRepo.findById(tripDto.getTripIdDto()).orElseThrow(() -> new TripNotFoundException("Trip for id " + tripDto.getTripIdDto() + " not found"));
            trip.setTripId(tripById.getTripId());
        }
        tripRepo.save(trip);
    }

    @Override
    public void updateTrip(TripDto tripDto, Long tripId) {
        Trip existingTrip = tripRepo.findById(tripId).orElseThrow(() ->
                new TripNotFoundException("Trip for id " + tripId + " not found"));
        //if bus exists
        Bus busId = busRepo.findById(tripDto.getBusIdDto()).orElseThrow(() ->
                new BusNotFoundException("Bus details not found"));

        existingTrip.setTripDate(tripDto.getTripDateDto());
        existingTrip.setTripArrivalTime(tripDto.getTripArrivalTimeDto());
        existingTrip.setTripDepartureTime(tripDto.getTripDepartureTimeDto());
//        existingTrip.setStartLocationId(tripDto.getStartLocationDtoId());
//        existingTrip.setTripDestinationId(tripDto.getDestinationDtoId());
//        existingTrip.setBus(busId);
//        existingTrip.setStartLocationId(tripDto.getStartLocationDtoId());


    }

    @Override
    public void deleteTrip(Long tripId) {
        if (!tripRepo.existsById(tripId)) {
            throw new TripNotFoundException("Trip not found with id: " + tripId);
        }
        tripRepo.deleteById(tripId);
    }


    //    public List<TripDto> getAllTrip() {
//        return tripRepo.findAll()
//                .stream().map(TripMapper::mapTripToTripDto).collect(Collectors.toList());
//    }
//
//    @Override
//    public TripDto getTripById(int id) {
//        return null;
//    }
//
//    public TripDto getTripById(Long tripId) {
//        return TripMapper.mapTripToTripDto(tripRepo.findById(tripId).orElseThrow(() ->
//                new TripNotFoundException("Trip not found for " + tripId)));
//
//    }
//
//    public void updateTrip(TripDto tripDto, Long tripId) {
//        Trip existingTrip = tripRepo.findById(tripId).orElseThrow(() ->
//                new TripNotFoundException("Trip not found for " + tripId));
//
//        existingTrip.setTripDate(tripDto.getTripDateDto());
//        existingTrip.setTripArrivalTime(tripDto.getTripArrivalTimeDto());
//        existingTrip.setTripDepartureTime(tripDto.getTripDepartureTimeDto());
//        tripRepo.save(existingTrip);
//    }
//
//    public void createTrip(TripDto tripDto) {
//        tripRepo.save(TripMapper.mapTripDtoToTrip(tripDto));
//    }
//
//    @Override
//    public void deleteTrip(TripDto tripDto) {
//
//    }
//
//    public void deleteTrip(Long tripId) {
//        tripRepo.deleteById(tripId);
//    }
//


    @Override
    public List<Trip> getByStartLocationIdAndTripDestinationId(Long startId, Long destinationId) {
        LocationMaster startLocation = locationMasterRepo.findById(startId).orElseThrow(() ->
                new LocationNotFoundException("Start location not found"));

        LocationMaster destination = locationMasterRepo.findById(destinationId).orElseThrow(() ->
                new LocationNotFoundException("Destination location not found"));
        return tripRepo.getByStartLocationIdAndTripDestinationId(startLocation, destination);
    }
}
