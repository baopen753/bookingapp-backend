package org.baopen753.bookingappbackend.repositories;

import org.baopen753.bookingappbackend.models.Fish;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FishRepository extends JpaRepository<Fish, Integer> {
  }