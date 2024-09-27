package org.baopen753.bookingappbackend.repository;

import org.baopen753.bookingappbackend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findUsersByUserId(int userId);

    boolean existsUserByPhoneNumber(String phoneNumber);
}