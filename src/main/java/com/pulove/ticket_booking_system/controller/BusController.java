package com.pulove.ticket_booking_system.controller;

import com.pulove.ticket_booking_system.Service.BusService;
import com.pulove.ticket_booking_system.dto.BusDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/bus")
public class BusController extends BaseController {
    private final BusService busService;


    @PostMapping
    public ResponseEntity<?> save(@RequestBody BusDto busDto) {
        busService.createBus(busDto);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<BusDto>> getAllBus() {
        return ResponseEntity.ok(busService.getAllBuses());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BusDto> getBusById(@PathVariable("id") Long busId) {
        return ResponseEntity.ok(busService.getBusById(busId));
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateBusById(@RequestBody BusDto busDto, @PathVariable("id") Long busId) {
        busService.updateBus(busDto, busId);
        return ResponseEntity.ok("Updated");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBusById(@PathVariable("id") Long busId) {
        busService.deleteBus(busId);
        return ResponseEntity.ok("Deleted");
    }
}
