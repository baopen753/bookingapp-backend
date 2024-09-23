package org.baopen753.bookingappbackend.repository;

import org.baopen753.bookingappbackend.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusRepository extends JpaRepository<Status, Integer> {
  }