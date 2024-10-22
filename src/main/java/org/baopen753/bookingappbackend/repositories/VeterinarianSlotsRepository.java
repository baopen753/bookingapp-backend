package org.baopen753.bookingappbackend.repositories;

import org.baopen753.bookingappbackend.models.veterinarian_slots.VeterinarianSlotId;
import org.baopen753.bookingappbackend.models.veterinarian_slots.VeterinarianSlots;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VeterinarianSlotsRepository extends JpaRepository<VeterinarianSlots, VeterinarianSlotId> {
  }