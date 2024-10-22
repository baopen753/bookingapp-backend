package org.baopen753.bookingappbackend.repositories;

import org.baopen753.bookingappbackend.entities.Prescription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrescriptionRepository extends JpaRepository<Prescription, Integer> {
  }