package org.baopen753.bookingappbackend.repository;

import org.baopen753.bookingappbackend.entity.Service;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepository extends JpaRepository<Service, Integer> {
  }