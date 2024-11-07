package org.baopen753.bookingappbackend.repositories;

import org.baopen753.bookingappbackend.entities.User;
import org.baopen753.bookingappbackend.enums.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findUsersByUserId(int userId);

    @Query("SELECT u FROM User u WHERE u.userId = :veterinarianId AND u.role = :role")
    User findVeterinarianById(@Param("veterinarianId") Integer veterinarianId, @Param("role") Role role);

    @Query("SELECT u FROM User u WHERE u.userId = :customerId AND u.role = :role")
    User findCustomerById(@Param("customerId") Integer customerId, @Param("role") Role role);


    boolean existsUserByPhoneNumber(String phoneNumber);

    List<User> findAllByRole(Role role);

    List<User> findUserByRole(Role role);

    Optional<User> findByUsername(String username);

    User findUserByEmail(String email);

}

