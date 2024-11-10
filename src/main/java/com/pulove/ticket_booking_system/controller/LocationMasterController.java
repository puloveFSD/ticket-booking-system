package com.pulove.ticket_booking_system.controller;

import com.pulove.ticket_booking_system.Service.LocationMasterService;
import com.pulove.ticket_booking_system.dto.LocationMasterDto;
import com.pulove.ticket_booking_system.entity.LocationMaster;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/location")
public class LocationMasterController {
    private final LocationMasterService locationMasterService;

    @PostMapping
    public ResponseEntity<?> createLocation(@RequestBody LocationMasterDto locationMasterDto) {
        locationMasterService.createLocation(locationMasterDto);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getLocationMasterById(@PathVariable("id") Long locationId) {
        return ResponseEntity.ok(locationMasterService.getLocationMasterById(locationId));
    }

    @GetMapping
    public ResponseEntity<?> getLocations() {
        return ResponseEntity.ok(locationMasterService.getAllLocationMaster());
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateLocationMaster(@RequestBody LocationMasterDto locationMasterDto, @PathVariable("id") Long locationMasterId) {
        locationMasterService.updateLocationMaster(locationMasterDto, locationMasterId);
        return ResponseEntity.ok("Location Updated");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteLocation(@PathVariable("id") Long locationMasterId) {
        locationMasterService.deleteLocation(locationMasterId);
        return ResponseEntity.ok("deleted");
    }


}
