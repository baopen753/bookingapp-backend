package org.baopen753.bookingappbackend.repository;

import org.baopen753.bookingappbackend.model.Fish;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FishRepository extends JpaRepository<Fish, Integer> {
  }