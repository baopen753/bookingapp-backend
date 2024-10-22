package org.baopen753.bookingappbackend.repositories;

import org.baopen753.bookingappbackend.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findUsersByUserId(int userId);

    boolean existsUserByPhoneNumber(String phoneNumber);
}