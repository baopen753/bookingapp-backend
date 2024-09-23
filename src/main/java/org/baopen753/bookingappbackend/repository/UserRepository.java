package org.baopen753.bookingappbackend.repository;

import org.baopen753.bookingappbackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
  }