package org.baopen753.bookingappbackend.services.userservice;

import org.baopen753.bookingappbackend.entities.Address;

import java.util.List;

public interface UserAddressService {
    List<Address> getAllAddresses(String username);

    Address getAddressById(Integer addressId);

    Address updateAddressDetails(Address address, Integer addressId);

    Address addAddress(Address address, Integer customerId);
}




