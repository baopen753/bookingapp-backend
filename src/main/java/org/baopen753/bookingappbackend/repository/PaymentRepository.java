package org.baopen753.bookingappbackend.repository;

import org.baopen753.bookingappbackend.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {
  }