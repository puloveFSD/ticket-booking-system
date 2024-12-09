package com.pulove.ticket_booking_system.controller;

import com.pulove.ticket_booking_system.Service.SeatService;
import com.pulove.ticket_booking_system.dto.SeatDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor

@RequestMapping("/seat")
public class SeatController {
    private final SeatService seatService;

    @PostMapping
    public ResponseEntity<?> createSeat(@RequestBody SeatDto seatDto) {
        seatService.createSeat(seatDto);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateSeat(@RequestBody SeatDto seatDto, @PathVariable("id") Long seatId) {
        seatService.updateSeat(seatDto, seatId);
        return ResponseEntity.ok("Updated");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSeat(@PathVariable("id") Long seatId) {
        seatService.deleteSeat(seatId);
        return ResponseEntity.ok("Deleted");
    }

    @GetMapping
    public ResponseEntity<?> getAllSeats() {
        return ResponseEntity.ok(seatService.getAllSeats());

    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getSeatById(@PathVariable("id") Long seatId) {
        return ResponseEntity.ok(seatService.getSeatById(seatId));
    }

}
