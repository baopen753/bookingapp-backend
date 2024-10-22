package org.baopen753.bookingappbackend.repositories;

import org.baopen753.bookingappbackend.models.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {
  }