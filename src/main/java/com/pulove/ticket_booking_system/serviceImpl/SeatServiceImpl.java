package com.pulove.ticket_booking_system.serviceImpl;

import com.pulove.ticket_booking_system.Service.SeatService;
import com.pulove.ticket_booking_system.dto.SeatDto;
import com.pulove.ticket_booking_system.entity.Seat;
import com.pulove.ticket_booking_system.exception.SeatNotFoundException;
import com.pulove.ticket_booking_system.mapper.SeatMapper;
import com.pulove.ticket_booking_system.repository.SeatRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SeatServiceImpl implements SeatService {
    private final SeatRepo seatRepo;

    @Override
    public void createSeat(SeatDto seatDto) {
        seatRepo.save(SeatMapper.seatDtoToSeat(seatDto));
    }

    @Override
    public void deleteSeat(Long seatIdDto) {
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
