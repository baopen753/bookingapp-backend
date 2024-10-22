package org.baopen753.bookingappbackend.repositories;

import org.baopen753.bookingappbackend.entities.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {

    @Query("SELECT p FROM Payment p JOIN Appointment a ON p.paymentId = a.payment.paymentId WHERE a.appointmentId = :appointmentId")
    Payment findByAppointmentId(Integer appointmentId);
  }