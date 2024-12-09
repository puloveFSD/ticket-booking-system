package com.pulove.ticket_booking_system.serviceImpl;

import com.pulove.ticket_booking_system.Service.LocationMasterService;
import com.pulove.ticket_booking_system.dto.LocationMasterDto;
import com.pulove.ticket_booking_system.entity.LocationMaster;
import com.pulove.ticket_booking_system.exception.LocationNotFoundException;
import com.pulove.ticket_booking_system.mapper.LocationMasterMapper;
import com.pulove.ticket_booking_system.repository.LocationMasterRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LocationMasterImpl implements LocationMasterService {
    private final LocationMasterRepo locationMasterRepo;

    @Override
    public LocationMasterDto getLocationMasterById(Long locationId) {
        return LocationMasterMapper.mapLocationToLocationMasterDto(locationMasterRepo.findById(locationId).orElseThrow(() ->
                new LocationNotFoundException("Location not found")));

    }

    @Override
    public List<LocationMasterDto> getAllLocationMaster() {
        return locationMasterRepo.findAll().stream().map(LocationMasterMapper::mapLocationToLocationMasterDto).collect(Collectors.toList());
    }

    @Override
    public void updateLocationMaster(LocationMasterDto locationMasterDto, Long locationMasterId) {
        LocationMaster existingLocations = locationMasterRepo.findById(locationMasterId).orElseThrow(() ->
                new LocationNotFoundException("Location not found"));

        existingLocations.setLocationName(locationMasterDto.getLocationNameDto());
        locationMasterRepo.save(existingLocations);

    }

    @Override
    public void createLocation(LocationMasterDto locationMasterDto) {
        locationMasterRepo.save(LocationMasterMapper.mapLocationMasterDtoToLocationMaster(locationMasterDto));
    }

    @Override
    public void deleteLocation(Long locationId) {
        if (!locationMasterRepo.existsById(locationId)) {
            throw new LocationNotFoundException("Location not found");
        }
        locationMasterRepo.deleteById(locationId);
    }
}
