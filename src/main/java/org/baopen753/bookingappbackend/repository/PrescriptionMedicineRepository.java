package org.baopen753.bookingappbackend.repository;

import org.baopen753.bookingappbackend.model.prescription_medicine.PrescriptionMedicine;
import org.baopen753.bookingappbackend.model.prescription_medicine.PrescriptionMedicineId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrescriptionMedicineRepository extends JpaRepository<PrescriptionMedicine, PrescriptionMedicineId> {
  }