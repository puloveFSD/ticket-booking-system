package com.pulove.ticket_booking_system.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "tbl_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "user_role")
    private String userRole;
    @Column(name="user_fullname")
    private String userFullName;
    @Column(name = "user_phonenumber")
    private String userPhoneNumber;
    @Column(name="user_address")
    private String userAddress;
    @Column(name = "user_email")
    private String userEmail;

}
