package org.baopen753.bookingappbackend.repository;

import org.baopen753.bookingappbackend.model.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedbackRepository extends JpaRepository<Feedback, Integer> {
  }