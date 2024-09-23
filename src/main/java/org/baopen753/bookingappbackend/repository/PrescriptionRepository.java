package org.baopen753.bookingappbackend.repository;

import org.baopen753.bookingappbackend.model.Prescription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrescriptionRepository extends JpaRepository<Prescription, Integer> {
  }