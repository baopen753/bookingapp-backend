package org.baopen753.bookingappbackend.repositories;

import org.baopen753.bookingappbackend.models.TimeSlot;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TimeSlotRepository extends JpaRepository<TimeSlot, Integer> {
  }