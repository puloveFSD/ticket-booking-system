package com.pulove.ticket_booking_system.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "tbl_seat")
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "seat_id")
    private Long seatId;
    @Column(name = "seat_number")
    private String seatNumber;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "bus_id", referencedColumnName = "bus_id")
    private Bus bus;


}
