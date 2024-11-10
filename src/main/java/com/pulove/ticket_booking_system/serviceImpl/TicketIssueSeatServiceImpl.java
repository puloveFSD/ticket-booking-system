package com.pulove.ticket_booking_system.serviceImpl;

import com.pulove.ticket_booking_system.Service.TicketIssueSeatService;
import com.pulove.ticket_booking_system.dto.TicketIssueSeatDto;
import com.pulove.ticket_booking_system.entity.TicketIssueSeat;
import com.pulove.ticket_booking_system.exception.TicketIssueSeatNotFoundException;
import com.pulove.ticket_booking_system.mapper.TicketIssueSeatMapper;
import com.pulove.ticket_booking_system.repository.TicketIssueSeatRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
@RequiredArgsConstructor
public class TicketIssueSeatServiceImpl implements TicketIssueSeatService {
    private final TicketIssueSeatRepo ticketIssueSeatRepo;

    @Override
    public void createTicketIssueSeat(TicketIssueSeatDto ticketIssueSeatDto) {
        ticketIssueSeatRepo.save(TicketIssueSeatMapper.TickIssueSeatDtoToTicketIssueSeat(ticketIssueSeatDto));
    }

    @Override
    public void updateTicketIssueSeat(TicketIssueSeatDto ticketIssueSeatDto, Long ticketIssueSeatId) {
        TicketIssueSeat existingTicketIssueSeat = ticketIssueSeatRepo.findById(ticketIssueSeatId).orElseThrow(() -> new TicketIssueSeatNotFoundException("Ticket Issue not found for id:" + ticketIssueSeatId));

    }

    @Override
    public TicketIssueSeatDto findTicketIssueSeatById(Long ticketIssueSeatId) {
        return TicketIssueSeatMapper.TicketIssueSeatToTicketIssueSeatDto(ticketIssueSeatRepo.findById(ticketIssueSeatId).orElseThrow(()
                -> new TicketIssueSeatNotFoundException("Ticket Issue not found for id:" + ticketIssueSeatId)));

    }

    @Override
    public List<TicketIssueSeatDto> findAllTicketIssueSeat() {
        return ticketIssueSeatRepo.findAll().stream()
                .map(TicketIssueSeatMapper::TicketIssueSeatToTicketIssueSeatDto).collect(Collectors.toList());
    }

    @Override
    public void deleteTicketIssueSeat(Long ticketIssueSeatId) {
        ticketIssueSeatRepo.deleteById(ticketIssueSeatId);
    }
}
