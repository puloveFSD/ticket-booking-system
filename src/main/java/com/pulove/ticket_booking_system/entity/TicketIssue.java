package com.pulove.ticket_booking_system.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;


@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "tbl_ticket_issue")
public class TicketIssue {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ticket_id")
    private Long ticketId;


    @Column(name = "number_of_passenger")
    private Long numberOfPassenger;

    @Column(name = "total_amount")
    private double totalAmount;

    @Column(name = "pickup_location")
    private String pickUpLocation;

    @Column(name = "issued_date")
    private Date issuedDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "issued_by", referencedColumnName = "user_id")
    private User issuedBy;

    @Column(name = "contact_person")
    private String contactPerson;

    @Column(name = "contact_person_phone_number")
    private String contactPersonPhoneNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bus_id", referencedColumnName = "bus_id")
    private Bus bus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "trip_id", referencedColumnName = "trip_id")
    private Trip trip;


}
