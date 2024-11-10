package com.pulove.ticket_booking_system.mapper;

import com.pulove.ticket_booking_system.dto.LocationMasterDto;
import com.pulove.ticket_booking_system.entity.LocationMaster;

public class LocationMasterMapper {
    public static LocationMasterDto mapLocationToLocationMasterDto(LocationMaster locationMaster) {
        return LocationMasterDto.builder()
                .locationMasterIdDto(locationMaster.getLocationId())
                .locationNameDto(locationMaster.getLocationName())
                .build();
    }

    public static LocationMaster mapLocationMasterDtoToLocationMaster(LocationMasterDto locationMasterDto) {
        return LocationMaster.builder()
                .locationId(locationMasterDto.getLocationMasterIdDto())
                .locationName(locationMasterDto.getLocationNameDto())
                .build();
    }
}
