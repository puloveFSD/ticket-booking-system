package com.pulove.ticket_booking_system.repository;

import com.pulove.ticket_booking_system.entity.Bus;
import com.pulove.ticket_booking_system.entity.Trip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TripRepo extends JpaRepository<Trip, Long> {

    @Query("select t from Trip t ")
    List<Trip> findAllTrips();
//
//    @Query("select t from Trip t join fetch t.bus left join fetch t.route where t.tripId=:id")
//    Optional<Trip> getTripByIdWithBusAndRoute(Long id);
}
