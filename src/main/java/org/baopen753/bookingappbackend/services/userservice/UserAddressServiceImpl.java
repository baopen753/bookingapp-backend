package org.baopen753.bookingappbackend.services.userservice;

import org.baopen753.bookingappbackend.entities.Address;
import org.baopen753.bookingappbackend.entities.User;
import org.baopen753.bookingappbackend.exception.DataNotFoundException;
import org.baopen753.bookingappbackend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserAddressServiceImpl implements UserAddressService {

    private final UserRepository userRepository;

    @Autowired
    public UserAddressServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<Address> getAllAddresses(String username) {
        Optional<User> customer = userRepository.findByUsername(username);
        if (customer.isEmpty())
            throw new DataNotFoundException("User", username);
        return customer.get().getAddresses().stream().toList();
    }

    @Override
    public Address getAddressById(Integer addressId) {
        return null;
    }

    @Override
    public Address updateAddressDetails(Address address, Integer addressId) {
        return null;
    }

    @Override
    public Address addAddress(Address address, Integer customerId) {
        return null;
    }
}
