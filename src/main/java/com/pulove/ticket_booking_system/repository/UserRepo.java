package com.pulove.ticket_booking_system.repository;

import com.pulove.ticket_booking_system.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
    User findUserByUsernameAndPassword(String userName, String password);
    Optional<User> findByUsernameAndPassword(String username, String password);
}
