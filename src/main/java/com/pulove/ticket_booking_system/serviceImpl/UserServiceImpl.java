package com.pulove.ticket_booking_system.serviceImpl;

import com.pulove.ticket_booking_system.Service.UserService;
import com.pulove.ticket_booking_system.dto.UserDto;
import com.pulove.ticket_booking_system.dto.UserResponseDto;
import com.pulove.ticket_booking_system.entity.User;
import com.pulove.ticket_booking_system.exception.UserNotFound;
import com.pulove.ticket_booking_system.mapper.UserMapper;
import com.pulove.ticket_booking_system.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final UserRepo userRepo;

    public UserResponseDto createUser(UserResponseDto userResponseDto) {
        return UserMapper.mapUserToDto(userRepo.save(UserMapper.mapDtoToUser(userResponseDto)));
    }

    public List<UserResponseDto> getAllUsers() {
        return userRepo.findAll().stream()
                .map(UserMapper::mapUserToDto)
                .collect(Collectors.toList());
    }

    public UserResponseDto getUserById(Long customerId) {
        return UserMapper.mapUserToDto(userRepo.findById(customerId).get());
    }

    public void updateUser(UserResponseDto userResponseDto, Long userId) {

        User existingUser = userRepo.findById(userId).orElseThrow(() ->
                new UserNotFound("Customer with " + userId + " not found"));
        existingUser.setUserFullName(userResponseDto.getUserFullNameDto());
        existingUser.setUserPhoneNumber(userResponseDto.getUserPhoneNumberDto());
        existingUser.setUserAddress(userResponseDto.getUserAddressDto());
        existingUser.setUserEmail(userResponseDto.getUserEmailDto());
        UserMapper.mapUserToDto(userRepo.save(existingUser));

    }

    public void deleteUser(Long userId) {
        userRepo.deleteById(userId);
    }

    @Override
    public UserResponseDto checkValidUser(UserDto userDto) {

        Optional<User> user = userRepo.findByUsernameAndPassword(userDto.getUsernameDto(), userDto.getPasswordDto());

        return user.map(UserMapper::mapUserToDto).orElseThrow(()
                -> new UserNotFound("Not Found"));

        //        User validateUser = this.userRepo.findByUsernameAndPassword(userDto.getUsernameDto(), userDto.getPasswordDto());
//        if (validateUser != null) {
//            return UserMapper.mapUserToDto(validateUser);
//        }
//        return null;
//    }
    }

}

