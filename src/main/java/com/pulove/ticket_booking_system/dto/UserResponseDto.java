package com.pulove.ticket_booking_system.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseDto {
    private Long userIdDto;
    private String usernameDto;
    private String passwordDto;
    private String userRole;
    private String userFullNameDto;
    private String userPhoneNumberDto;
    private String userAddressDto;
    private String userEmailDto;


}
