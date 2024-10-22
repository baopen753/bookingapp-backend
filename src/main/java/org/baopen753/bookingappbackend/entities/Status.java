package org.baopen753.bookingappbackend.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.baopen753.bookingappbackend.enums.AppointmentStatus;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "statuses")
public class Status {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "status_id", nullable = false)
    private Integer statusId;

    @Enumerated(EnumType.STRING)
    @Column(name = "status_name", nullable = false)
    private AppointmentStatus statusName;

    @Column(name = "time", nullable = false, columnDefinition = "DATETIME")
    private LocalDateTime time;

    @Column(name = "note", nullable = true)
    private String note;

    // Bidirectional, identifying relationship
    // Owning side: Status
    // Inverse side: Appointment
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "appointment_id", nullable = false, referencedColumnName = "appointment_id")
    private Appointment appointment;


}
