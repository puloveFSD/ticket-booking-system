package com.pulove.ticket_booking_system.serviceImpl;

import com.pulove.ticket_booking_system.Service.TicketIssueService;
import com.pulove.ticket_booking_system.dto.TicketIssueDto;
import com.pulove.ticket_booking_system.dto.TicketIssueResponseDto;
import com.pulove.ticket_booking_system.entity.*;
import com.pulove.ticket_booking_system.exception.*;
import com.pulove.ticket_booking_system.mapper.TicketIssueMapper;
import com.pulove.ticket_booking_system.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TicketIssueServiceImpl implements TicketIssueService {
    private final TicketIssueRepo ticketIssueRepo;
    private final BusRepo busRepo;
    private final TripRepo tripRepo;
    private final UserRepo userRepo;
    private final TicketIssueSeatRepo ticketIssueSeatRepo;
    private final SeatRepo seatRepo;

    @Transactional
    @Override
    public void createTicket(TicketIssueDto dto) {

        Bus busId = busRepo.findById(dto.getBusIdDto()).orElseThrow(() -> new BusNotFoundException("Bus not found"));
        Trip tripId = tripRepo.findById(dto.getTripIdDto()).orElseThrow(() -> new TripNotFoundException("Trip not found"));
        User userId = userRepo.findById(dto.getIssuedByIdDto()).orElseThrow(() ->
                new UserNotFound("User not found for id: " + dto.getIssuedByIdDto()));

        TicketIssue ticketIssue = ticketIssueRepo.save(TicketIssue.builder()
//                .ticketId(dto.getTicketIdDto())
                .bus(busId)
                .trip(tripId)
                .issuedBy(userId)
                .numberOfPassenger(dto.getNumberOfPassengerDto())
                .totalAmount(tripId.getTicketPricePerPerson() * dto.getNumberOfPassengerDto())
                .pickUpLocation(dto.getPickUpLocationDto())
                .issuedDate(new Date())
                .contactPerson(dto.getContactPersonDto())
                .contactPersonPhoneNumber(dto.getContactPersonPhoneNumberDto())
                .totalAmount(dto.getTotalAmountDto() * dto.getNumberOfPassengerDto())
                .issuedBy(User.builder().userId(1l).build())
                .build());

        // save into ticket issue seat
        List<TicketIssueSeat> ticketIssueSeatList = new ArrayList<>();
        dto.getSeatList().stream().forEach(seatId -> {
            Seat seat = seatRepo.findById(seatId).orElseThrow(() -> new SeatNotFoundException("Seat not found"));
            ticketIssueSeatList.add(TicketIssueSeat.builder()
                    .ticketIssue(ticketIssue)
                    .seat(seat)
                    .trip(tripId)
                    .bus(busId)
                    .build());
        });
        if (!ticketIssueSeatList.isEmpty())
            ticketIssueSeatRepo.saveAll(ticketIssueSeatList);
    }

    @Transactional
    @Override
    public void updateTicket(TicketIssueDto ticketIssueDto, Long ticketIdDto) {
        Bus busId = busRepo.findById(ticketIssueDto.getBusIdDto()).orElseThrow(() -> new BusNotFoundException("Bus Not Found"));

        Trip tripId = tripRepo.findById(ticketIssueDto.getTripIdDto()).orElseThrow(() ->
                new TripNotFoundException("Trip Not found"));

        User userId = userRepo.findById(ticketIssueDto.getIssuedByIdDto()).orElseThrow(() ->
                new UserNotFound("User not found"));
        TicketIssue existingTicketIssue = ticketIssueRepo.findById(ticketIdDto).orElseThrow(() ->
                new TicketNotFoundException("Ticket id " + ticketIdDto + " not found"));

        existingTicketIssue.setIssuedBy(userId);
        existingTicketIssue.setTrip(tripId);
        existingTicketIssue.setBus(busId);
        existingTicketIssue.setNumberOfPassenger(ticketIssueDto.getNumberOfPassengerDto());
        existingTicketIssue.setTotalAmount(ticketIssueDto.getTotalAmountDto());
        existingTicketIssue.setPickUpLocation(ticketIssueDto.getPickUpLocationDto());
        existingTicketIssue.setIssuedDate(ticketIssueDto.getIssuedDateDto());
        existingTicketIssue.setContactPerson(ticketIssueDto.getContactPersonDto());
        existingTicketIssue.setContactPersonPhoneNumber(ticketIssueDto.getContactPersonPhoneNumberDto());
        existingTicketIssue.setTotalAmount(ticketIssueDto.getTotalAmountDto());
        TicketIssue ticketIssue = ticketIssueRepo.save(existingTicketIssue);

        // delete ticket issue seat by ticketIssueID
        ticketIssueSeatRepo.deleteAllByTicketIssue_TicketId(ticketIssue.getTicketId());
        // save into ticket issue seat
        List<TicketIssueSeat> ticketIssueSeatList = new ArrayList<>();
        ticketIssueDto.getSeatList().stream().forEach(seatId -> {
            Seat seat = seatRepo.findById(seatId).orElseThrow(() -> new SeatNotFoundException("Seat not found"));
            ticketIssueSeatList.add(TicketIssueSeat.builder()
                    .ticketIssue(ticketIssue)
                    .seat(seat)
                    .trip(tripId)
                    .bus(busId)
                    .build());
        });
        if (!ticketIssueSeatList.isEmpty())
            ticketIssueSeatRepo.saveAll(ticketIssueSeatList);

    }

    @Override
    public void deleteTicket(Long ticketIdDto) {
        if (!ticketIssueRepo.existsById(ticketIdDto)) {
            throw new TicketNotFoundException("Ticket id " + ticketIdDto + " not found");
        }
        ticketIssueRepo.deleteById(ticketIdDto);
    }

    @Override
    public TicketIssueDto getTicket(Long ticketIdDto) {
        return TicketIssueMapper.ticketToTicketDto(ticketIssueRepo.findById(ticketIdDto).orElseThrow(()
                -> new TicketNotFoundException("Ticket not found")));

    }

    @Override
    public List<TicketIssueResponseDto> getAllTickets() {
        return ticketIssueRepo.getAllTicketIssueDate().stream()
                .map(TicketIssueMapper::mapTicketIssueToDto)
                .map(ticketIssue -> {
                    // find seat number by ticket issue id
                    ticketIssue.setSeatNumberList(ticketIssueSeatRepo.getSeatNumbersByTicketIssueId(ticketIssue.getIssueId()));
                    return ticketIssue;
                })
                .collect(Collectors.toList());
    }
}
