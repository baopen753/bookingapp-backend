package org.baopen753.bookingappbackend.repository;

import org.baopen753.bookingappbackend.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {
  }