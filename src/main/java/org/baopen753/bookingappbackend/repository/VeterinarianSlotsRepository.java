package org.baopen753.bookingappbackend.repository;

import org.baopen753.bookingappbackend.entity.veterinarian_slots.VeterinarianSlotId;
import org.baopen753.bookingappbackend.entity.veterinarian_slots.VeterinarianSlots;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VeterinarianSlotsRepository extends JpaRepository<VeterinarianSlots, VeterinarianSlotId> {
  }