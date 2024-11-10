package com.pulove.ticket_booking_system.mapper;

import com.pulove.ticket_booking_system.dto.BusDto;
import com.pulove.ticket_booking_system.entity.Bus;

public class BusMapper {

    public static BusDto mapBusToBusDto(Bus bus) {
        return BusDto.builder().busIdDto(bus.getBusId())
                .busNumberDto(bus.getBusNumber())
                .busTypeDto(bus.getBusType())
                .busOperatorNameDto(bus.getBusOperatorName())
                .busTotalSeatsDto(bus.getBusTotalSeats())

                .build();
    }

    public static Bus mapBusDtoToBus(BusDto busDto) {
        return Bus.builder()
                .busId(busDto.getBusIdDto())
                .busType(busDto.getBusTypeDto())
                .busOperatorName(busDto.getBusOperatorNameDto())
                .busNumber(busDto.getBusNumberDto())
                .busTotalSeats(busDto.getBusTotalSeatsDto())

                .build();
    }
}
