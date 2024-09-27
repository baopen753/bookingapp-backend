package org.baopen753.bookingappbackend.entity.veterinarian_slots;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.baopen753.bookingappbackend.enums.SlotStatus;
import org.baopen753.bookingappbackend.entity.TimeSlot;
import org.baopen753.bookingappbackend.entity.User;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@Entity
@Table(name = "veterinarian_slots")
public class VeterinarianSlots {

    @EmbeddedId
    private VeterinarianSlotId veterinarianSlotId;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    @ColumnDefault("'AVAILABLE'")
    private SlotStatus status;

    // Bidirectional, identifying  relationship
    // Owning side: VeterinarianSlots
    // Inverse side: TimeSlot
    @MapsId("slotId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "slot_id", nullable = false, referencedColumnName = "slot_id")
    private TimeSlot timeSlot;

    // Bidirectional, identifying  relationship
    // Owning side: VeterinarianSlots
    // Inverse side: User(Veterinarian)
    @MapsId("veterinarianId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "veterinarian_id", nullable = false, referencedColumnName = "user_id")
    private User veterinarian;

}
