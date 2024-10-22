package org.baopen753.bookingappbackend.repositories;

import org.baopen753.bookingappbackend.entities.MedicalReport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicalReportRepository extends JpaRepository<MedicalReport, Integer> {
    MedicalReport findByReportId(Integer medicalReportId);
}