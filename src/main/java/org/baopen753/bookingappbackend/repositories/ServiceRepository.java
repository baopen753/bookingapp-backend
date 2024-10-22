package org.baopen753.bookingappbackend.repositories;

import org.baopen753.bookingappbackend.entities.Service;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepository extends JpaRepository<Service, Integer> {
  }