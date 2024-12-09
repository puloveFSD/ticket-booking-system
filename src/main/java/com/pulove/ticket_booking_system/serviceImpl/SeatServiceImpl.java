package com.pulove.ticket_booking_system.serviceImpl;

import com.pulove.ticket_booking_system.Service.SeatService;
import com.pulove.ticket_booking_system.dto.SeatDto;
import com.pulove.ticket_booking_system.entity.Bus;
import com.pulove.ticket_booking_system.entity.Seat;
import com.pulove.ticket_booking_system.exception.BusNotFoundException;
import com.pulove.ticket_booking_system.exception.SeatNotFoundException;
import com.pulove.ticket_booking_system.mapper.SeatMapper;
import com.pulove.ticket_booking_system.repository.BusRepo;
import com.pulove.ticket_booking_system.repository.SeatRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SeatServiceImpl implements SeatService {
    private final SeatRepo seatRepo;
    private final BusRepo busRepo;

    @Override
    public void createSeat(SeatDto seatDto) {

        Bus busId = busRepo.findById(seatDto.getBusIdDto()).orElseThrow(() -> new BusNotFoundException("Bus not found"));
        Seat seat = Seat.builder()
                .seatNumber(seatDto.getSeatNumberDto())
                .bus(busId)
                .build();
        seatRepo.save(seat);
    }

    @Override
    public void deleteSeat(Long seatIdDto) {
        if (!seatRepo.existsById(seatIdDto)) {
            throw new SeatNotFoundException("Seat not found with id:" + seatIdDto);
        }
        seatRepo.deleteById(seatIdDto);

    }

    @Override
    public SeatDto getSeatById(Long seatIdDto) {
        return SeatMapper.seatToSeatDto(seatRepo.findById(seatIdDto).orElseThrow(() ->
                new SeatNotFoundException("Seat not found ")));

    }

    @Override
    public List<SeatDto> getAllSeats() {
        return seatRepo.findAll()
                .stream().map(SeatMapper::seatToSeatDto).collect(Collectors.toList());
    }

    @Override
    public void updateSeat(SeatDto seatDto, Long seatIdDto) {
        Seat existingSeat = seatRepo.findById(seatIdDto).orElseThrow(() ->
                new SeatNotFoundException("Seat not found "));

        existingSeat.setSeatNumber(seatDto.getSeatNumberDto());
        seatRepo.save(existingSeat);

    }
}
