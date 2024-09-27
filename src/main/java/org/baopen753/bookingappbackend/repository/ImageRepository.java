package org.baopen753.bookingappbackend.repository;

import org.baopen753.bookingappbackend.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, Integer> {
  }