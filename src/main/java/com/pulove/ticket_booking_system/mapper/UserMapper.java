package com.pulove.ticket_booking_system.mapper;

import com.pulove.ticket_booking_system.dto.UserResponseDto;
import com.pulove.ticket_booking_system.entity.User;

public class UserMapper {


    public static UserResponseDto mapUserToDto(User user) {
        return UserResponseDto.builder().userIdDto(user.getUserId())
                .userFullNameDto(user.getUserFullName())
                .userPhoneNumberDto(user.getUserPhoneNumber())
                .userAddressDto(user.getUserAddress())
                .userEmailDto(user.getUserEmail())
                .usernameDto(user.getUsername())
                .passwordDto(user.getPassword())
                .userRole(user.getUserRole())
                .build();
    }

    public static User mapDtoToUser(UserResponseDto userResponseDto) {
        return User.builder().userId(userResponseDto.getUserIdDto())
                .userFullName(userResponseDto.getUserFullNameDto())
                .userPhoneNumber(userResponseDto.getUserPhoneNumberDto())
                .userAddress(userResponseDto.getUserAddressDto())
                .userEmail(userResponseDto.getUserEmailDto())
                .userRole(userResponseDto.getUserRole())
                .username(userResponseDto.getUsernameDto())
                .password(userResponseDto.getPasswordDto())
                .build();
    }
}
