package org.baopen753.bookingappbackend.repository;

import org.baopen753.bookingappbackend.model.TimeSlot;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TimeSlotRepository extends JpaRepository<TimeSlot, Integer> {
  }