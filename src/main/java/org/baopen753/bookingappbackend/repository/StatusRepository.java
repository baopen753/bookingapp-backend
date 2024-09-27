package org.baopen753.bookingappbackend.repository;

import org.baopen753.bookingappbackend.entity.Status;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusRepository extends JpaRepository<Status, Integer> {
  }