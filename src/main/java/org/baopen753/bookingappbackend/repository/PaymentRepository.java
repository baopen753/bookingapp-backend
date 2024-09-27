package org.baopen753.bookingappbackend.repository;

import org.baopen753.bookingappbackend.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {
  }