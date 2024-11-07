package org.baopen753.bookingappbackend.entities;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "invalidate_token")
public class InvalidatedToken {

    @Id
    @Column(name = "id", nullable = false)
    private String id;

    @Column(name = "expiry_time", nullable = false)
    private LocalDateTime expiryTime;

}
