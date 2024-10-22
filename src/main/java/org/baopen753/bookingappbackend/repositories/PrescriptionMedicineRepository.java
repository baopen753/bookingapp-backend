package org.baopen753.bookingappbackend.repositories;

import org.baopen753.bookingappbackend.models.prescription_medicine.PrescriptionMedicine;
import org.baopen753.bookingappbackend.models.prescription_medicine.PrescriptionMedicineId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrescriptionMedicineRepository extends JpaRepository<PrescriptionMedicine, PrescriptionMedicineId> {
  }