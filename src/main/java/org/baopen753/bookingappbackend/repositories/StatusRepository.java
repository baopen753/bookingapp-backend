package org.baopen753.bookingappbackend.repositories;

import org.baopen753.bookingappbackend.entities.Status;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusRepository extends JpaRepository<Status, Integer> {
  }