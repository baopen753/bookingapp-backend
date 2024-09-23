package org.baopen753.bookingappbackend.repository;

import org.baopen753.bookingappbackend.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Integer> {
  }