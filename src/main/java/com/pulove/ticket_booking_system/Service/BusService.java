package com.pulove.ticket_booking_system.Service;

import com.pulove.ticket_booking_system.dto.BusDto;
import org.springframework.stereotype.Service;

import java.util.List;


public interface BusService {
    void createBus(BusDto busDto);

    List<BusDto> getAllBuses();

    BusDto getBusById(Long busId);

    void updateBus(BusDto busDto, Long busId);

    void deleteBus(Long busId);

}
