package com.pulove.ticket_booking_system.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_trip")
public class Trip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "trip_id")
    private Long tripId;
    @Column(name = "trip_date")
    private Date tripDate;
    @Column(name = "trip_departure_time")
    private LocalTime tripDepartureTime;
    @Column(name = "trip_arrival_time")
    private LocalTime tripArrivalTime;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "start_location_id", referencedColumnName = "location_id")
    private LocationMaster startLocationId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "destination_location_id", referencedColumnName = "location_id")
    private LocationMaster tripDestinationId;
    @Column(name = "ticket_price_per_person")
    private double ticketPricePerPerson;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bus_id", referencedColumnName = "bus_id")
    private Bus bus;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "location_id", referencedColumnName = "location_id")
//    private LocationMaster locationMaster;

}
