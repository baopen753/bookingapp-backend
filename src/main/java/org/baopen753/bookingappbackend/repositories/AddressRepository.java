package org.baopen753.bookingappbackend.repositories;

import org.baopen753.bookingappbackend.models.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Integer> {
}