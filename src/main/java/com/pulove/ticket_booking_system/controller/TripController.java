package com.pulove.ticket_booking_system.controller;

import com.pulove.ticket_booking_system.Service.TripService;
import com.pulove.ticket_booking_system.dto.TripDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController

@RequestMapping("/trip")
@RequiredArgsConstructor
public class TripController extends BaseController {
    private final TripService tripService;

    @PostMapping
    public ResponseEntity<?> save(@Valid @RequestBody TripDto tripDto) {
        tripService.createTrip(tripDto);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> getAllTrip() {
        return ResponseEntity.ok(tripService.getAllTrip());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getTripById(@PathVariable("id") Long tripId) {
        return ResponseEntity.ok(tripService.getTripById(tripId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTripById(@PathVariable("id") Long tripId) {
        tripService.deleteTrip(tripId);
        return ResponseEntity.ok("deleted");
    }


    @PutMapping("/{id}")
    public ResponseEntity<String> updateTripById(@RequestBody TripDto tripDto, @PathVariable("id") Long tripId) {
        tripService.updateTrip(tripDto, tripId);
        return ResponseEntity.ok("Trip Updated");
    }

    @GetMapping("/records")
    public ResponseEntity<?> getTripsByLocation(
            @RequestParam("startLocation") Long startLocationId,
            @RequestParam("destination") Long destinationLocationId
    ) {
        return ResponseEntity.ok(tripService.getByStartLocationIdAndTripDestinationId(startLocationId, destinationLocationId));
    }

}
