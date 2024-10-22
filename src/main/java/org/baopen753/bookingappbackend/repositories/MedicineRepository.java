package org.baopen753.bookingappbackend.repositories;

import org.baopen753.bookingappbackend.entities.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicineRepository extends JpaRepository<Medicine, Integer> {
  }