package org.baopen753.bookingappbackend.repositories;

import org.baopen753.bookingappbackend.models.MedicalReport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicalReportRepository extends JpaRepository<MedicalReport, Integer> {
  }