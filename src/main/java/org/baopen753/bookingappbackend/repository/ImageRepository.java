package org.baopen753.bookingappbackend.repository;

import org.baopen753.bookingappbackend.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, Integer> {
  }