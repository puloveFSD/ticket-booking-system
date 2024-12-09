package com.pulove.ticket_booking_system.serviceImpl;

import com.pulove.ticket_booking_system.Service.BusService;
import com.pulove.ticket_booking_system.dto.BusDto;
import com.pulove.ticket_booking_system.entity.Bus;
import com.pulove.ticket_booking_system.exception.BusNotFoundException;
import com.pulove.ticket_booking_system.mapper.BusMapper;
import com.pulove.ticket_booking_system.repository.BusRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BusServiceImpl implements BusService {
    private final BusRepo busRepo;

    @Override
    public void createBus(BusDto busDto) {
        Bus fetchData = busRepo.save(BusMapper.mapBusDtoToBus(busDto));
        BusMapper.mapBusToBusDto(fetchData);
    }

    @Override
    public List<BusDto> getAllBuses() {
        return busRepo.findAll()
                .stream().map(BusMapper::mapBusToBusDto).collect(Collectors.toList());
    }

    @Override
    public BusDto getBusById(Long busId) {
        return BusMapper.mapBusToBusDto(busRepo.findById(busId).orElseThrow(() ->
                new BusNotFoundException("Bus not found with id " + busId)));

    }

    @Override
    public void updateBus(BusDto busDto, Long busId) {
        Bus existingBus = busRepo.findById(busId).orElseThrow(
                () -> new BusNotFoundException("Bus with id" + busId + "not found"));
        existingBus.setBusNumber(busDto.getBusNumberDto());
        existingBus.setBusType(busDto.getBusTypeDto());
        existingBus.setBusOperatorName(busDto.getBusOperatorNameDto());
        existingBus.setBusTotalSeats(busDto.getBusTotalSeatsDto());
        busRepo.save(existingBus);
    }

    @Override
    public void deleteBus(Long busId) {
        if (!busRepo.existsById(busId)) {
            throw new BusNotFoundException("Bus not found with id " + busId);
        }
        busRepo.deleteById(busId);
    }


//    public void save(BusDto busDto) {
//        busRepo.save(BusMapper.mapBusDtoToBus(busDto));
//    }
//
//    public List<BusDto> getAllBus() {
//
//        return busRepo.findAll()
//                .stream().map(BusMapper::mapBusToBusDto).collect(Collectors.toList());
//    }
//
//    public BusDto getBusById(Long busId) {
//        return BusMapper.mapBusToBusDto(busRepo.findById(busId).orElseThrow(() ->
//                new BusNotFoundException("Bus with id" + busId + "not found")));
//    }
//
//    public void updateBusById(BusDto busDto, Long busId) {
//        Bus existingBus = busRepo.findById(busId).orElseThrow(
//                () -> new BusNotFoundException("Bus with id" + busId + "not found"));
//        existingBus.setBusNumber(busDto.getBusNumberDto());
//        existingBus.setBusType(busDto.getBusTypeDto());
//        existingBus.setBusOperatorName(busDto.getBusOperatorNameDto());
//        existingBus.setBusTotalSeats(busDto.getBusTotalSeatsDto());
//        busRepo.save(existingBus);
//    }
//
//    public void deleteBus(Long busId) {
//        busRepo.deleteById(busId);
//    }
}
