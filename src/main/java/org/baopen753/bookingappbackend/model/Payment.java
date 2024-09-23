package org.baopen753.bookingappbackend.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.baopen753.bookingappbackend.enums.PaymentMethod;
import org.baopen753.bookingappbackend.enums.PaymentStatus;
import org.hibernate.annotations.ColumnDefault;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "payments")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_id", nullable = false)
    private Integer paymentId;

    @Enumerated(EnumType.STRING)
    @Column(name = "payment_method", nullable = false)
    private PaymentMethod paymentMethod;

    @Column(name = "transaction_time", nullable = false, columnDefinition = "DATETIME")
    private LocalDateTime transactionTime;

    @Column(name = "transaction_id", length = 100, nullable = true, unique = true)
    private String transactionId;

    @Column(name = "amount", nullable = false, precision = 6, scale = 2)
    private BigDecimal amount;

//    @Lob
    @Column(name = "description", nullable = true, columnDefinition = "TEXT")
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = true)
    @ColumnDefault("'NOT_PAID'")
    private PaymentStatus status;


}
