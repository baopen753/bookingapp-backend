package org.baopen753.bookingappbackend.repository;

import org.baopen753.bookingappbackend.entity.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicineRepository extends JpaRepository<Medicine, Integer> {
  }