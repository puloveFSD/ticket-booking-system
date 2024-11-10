package com.pulove.ticket_booking_system.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@Table(name = "tbl_bus")
public class Bus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bus_id")
    private Long busId;


    @Column(name = "bus_operator_name")
    private String busOperatorName;
    @Column(name = "bus_number")
    private String busNumber;
    @Column(name = "bus_type")
    private String busType;
    @Column(name = "bus_total_seats")
    private int busTotalSeats;



}
