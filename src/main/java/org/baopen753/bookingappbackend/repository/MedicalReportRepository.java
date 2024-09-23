package org.baopen753.bookingappbackend.repository;

import org.baopen753.bookingappbackend.model.MedicalReport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicalReportRepository extends JpaRepository<MedicalReport, Integer> {
  }