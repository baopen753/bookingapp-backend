package org.baopen753.bookingappbackend.repository;

import org.baopen753.bookingappbackend.entity.TimeSlot;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TimeSlotRepository extends JpaRepository<TimeSlot, Integer> {
  }