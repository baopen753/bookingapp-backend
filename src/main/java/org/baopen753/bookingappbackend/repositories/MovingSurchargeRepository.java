package org.baopen753.bookingappbackend.repositories;

import org.baopen753.bookingappbackend.entities.MovingSurcharge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MovingSurchargeRepository extends JpaRepository<MovingSurcharge, Integer> {

    @Query("SELECT m FROM Address a, MovingSurcharge m WHERE a.district LIKE m.district AND a.addressId = :addressId")
    MovingSurcharge getMovingSurchargeByAddressId(Integer addressId);
  }