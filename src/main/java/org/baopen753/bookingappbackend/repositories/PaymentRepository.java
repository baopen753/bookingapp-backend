package org.baopen753.bookingappbackend.repositories;

import org.baopen753.bookingappbackend.models.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {
  }