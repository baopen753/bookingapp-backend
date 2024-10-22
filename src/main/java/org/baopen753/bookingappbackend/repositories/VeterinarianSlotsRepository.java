package org.baopen753.bookingappbackend.repositories;

import org.baopen753.bookingappbackend.entities.veterinarian_slots.VeterinarianSlotId;
import org.baopen753.bookingappbackend.entities.veterinarian_slots.VeterinarianSlots;
import org.baopen753.bookingappbackend.enums.SlotStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VeterinarianSlotsRepository extends JpaRepository<VeterinarianSlots, VeterinarianSlotId> {
    @Query("SELECT vs FROM VeterinarianSlots vs WHERE vs.veterinarian.userId = :veterinarianId")
    List<VeterinarianSlots> findByVeterinarianId(@Param("veterinarianId") Integer veterinarianId);

    @Query("SELECT vs FROM VeterinarianSlots vs WHERE vs.status = ?1 AND vs.veterinarianSlotId.slotId = ?2")
    List<VeterinarianSlots> getAvailableSlotsBySlotId(SlotStatus status, Integer slotId);

    @Query("SELECT vs FROM VeterinarianSlots vs WHERE vs.veterinarianSlotId.veterinarianId = ?1 AND vs.veterinarianSlotId.slotId = ?2")
    VeterinarianSlots getVeterinarianSlotsById(Integer veterinarianId, Integer slotId);

  }