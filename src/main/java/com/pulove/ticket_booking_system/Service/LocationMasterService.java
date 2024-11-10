package com.pulove.ticket_booking_system.Service;

import com.pulove.ticket_booking_system.dto.LocationMasterDto;

import java.util.List;

public interface LocationMasterService {
    LocationMasterDto getLocationMasterById(Long locationId);

    List<LocationMasterDto> getAllLocationMaster();

    void updateLocationMaster(LocationMasterDto locationMasterDto, Long locationMasterId);

    void createLocation(LocationMasterDto locationMasterDto);

    void deleteLocation(Long locationId);
}
