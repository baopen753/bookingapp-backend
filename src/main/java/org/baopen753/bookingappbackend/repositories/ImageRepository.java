package org.baopen753.bookingappbackend.repositories;

import org.baopen753.bookingappbackend.entities.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, Integer> {
  }