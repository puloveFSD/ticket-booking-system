package com.pulove.ticket_booking_system.Service;

import com.pulove.ticket_booking_system.dto.UserDto;
import com.pulove.ticket_booking_system.dto.UserResponseDto;

import java.util.List;

public interface UserService {
    UserResponseDto createUser(UserResponseDto userResponseDto);
    void updateUser(UserResponseDto userResponseDto, Long userId);
    UserResponseDto getUserById(Long userId);
    List<UserResponseDto> getAllUsers();
    void deleteUser(Long userId);
    UserResponseDto checkValidUser(UserDto userDto);
}
