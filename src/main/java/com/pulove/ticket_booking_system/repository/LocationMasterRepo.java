package com.pulove.ticket_booking_system.repository;

import com.pulove.ticket_booking_system.entity.LocationMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationMasterRepo extends JpaRepository<LocationMaster, Long> {
}
