package org.baopen753.bookingappbackend.repositories;

import org.baopen753.bookingappbackend.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address, Integer> {

    @Query("SELECT a FROM Address a WHERE a.customer.userId = :customerId AND a.enabled = TRUE")
    List<Address> findByCustomerId(Integer customerId);

}