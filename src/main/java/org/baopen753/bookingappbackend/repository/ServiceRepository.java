package org.baopen753.bookingappbackend.repository;

import org.baopen753.bookingappbackend.model.Service;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepository extends JpaRepository<Service, Integer> {
  }