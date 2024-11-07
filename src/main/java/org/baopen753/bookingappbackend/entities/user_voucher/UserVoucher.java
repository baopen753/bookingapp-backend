package org.baopen753.bookingappbackend.entities.user_voucher;

import jakarta.persistence.*;
import lombok.Data;
import org.baopen753.bookingappbackend.entities.User;
import org.baopen753.bookingappbackend.entities.Voucher;


@Data
@Entity
@Table(name = "user_voucher")
public class UserVoucher {

    @EmbeddedId
    private UserVoucherId userVoucherId;

    @Column(name = "quantity", nullable = true)
    private Integer quantity;

    @MapsId("userId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false, referencedColumnName = "user_id")
    private User user;

    @MapsId("voucherId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "voucher_id", nullable = false, referencedColumnName = "voucher_id")
    private Voucher voucher;
}
