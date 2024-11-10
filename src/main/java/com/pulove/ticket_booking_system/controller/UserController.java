package com.pulove.ticket_booking_system.controller;

import com.pulove.ticket_booking_system.Service.UserService;
import com.pulove.ticket_booking_system.dto.UserDto;
import com.pulove.ticket_booking_system.dto.UserResponseDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @PostMapping
    private ResponseEntity<?> save(@Valid @RequestBody UserResponseDto userResponseDto) {
        userService.createUser(userResponseDto);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping
    private ResponseEntity<List<UserResponseDto>> getAll() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDto> getById(@PathVariable("id") Long userId) {
        return ResponseEntity.ok(userService.getUserById(userId));
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateUser(@RequestBody UserResponseDto userResponseDto, @PathVariable("id") Long userId) {
        userService.updateUser(userResponseDto, userId);
        return new ResponseEntity<>("Updated Successfully", HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable("id") Long userId) {
        userService.deleteUser(userId);
        return ResponseEntity.ok("deleted");
    }

    @PostMapping("/login")
    public ResponseEntity<?> checkValidUser(@RequestBody UserDto userDto) {
//        System.err.println("checkValidUser");
        UserResponseDto userResponseDto = userService.checkValidUser(userDto);
        if (userResponseDto != null) {
            return ResponseEntity.ok(userResponseDto);
        } else {
            return ResponseEntity.status(401).body(null);
        }
    }


}
