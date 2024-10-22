package org.baopen753.bookingappbackend.entities;


import jakarta.persistence.*;
import lombok.*;
import org.baopen753.bookingappbackend.entities.prescription_medicine.PrescriptionMedicine;

import java.util.Set;

@Getter
@Setter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "prescription")
public class Prescription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "prescription_id", nullable = false)
    private Integer prescriptionId;

//    @Lob
    @Column(name = "instruction", nullable = false, columnDefinition = "TEXT")
    private String instruction;

    // Bidirectional, identifying  relationship
    // Owning side: Prescription
    // Inverse side: PrescriptionMedicine
    @OneToMany(mappedBy = "prescription", orphanRemoval = true)
    private Set<PrescriptionMedicine> prescriptionMedicines;

}
