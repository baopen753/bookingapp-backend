package org.baopen753.bookingappbackend.repository;

import org.baopen753.bookingappbackend.entity.Fish;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FishRepository extends JpaRepository<Fish, Integer> {
  }