package org.baopen753.bookingappbackend.repositories;

import org.baopen753.bookingappbackend.models.Service;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepository extends JpaRepository<Service, Integer> {
  }