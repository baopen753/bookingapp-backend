package org.baopen753.bookingappbackend.repositories;

import org.baopen753.bookingappbackend.models.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedbackRepository extends JpaRepository<Feedback, Integer> {
  }