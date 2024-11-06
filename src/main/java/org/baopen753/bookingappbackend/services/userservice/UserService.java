package org.baopen753.bookingappbackend.services.userservice;

import org.baopen753.bookingappbackend.dtos.UserDto;
import org.baopen753.bookingappbackend.entities.Address;
import org.baopen753.bookingappbackend.entities.User;

public interface UserService {
    User getUserProfile(Integer userId);
    User updateAddress(Integer userId, Address convertedAddress);
    User updateUserProfile(Integer userId, User convertedCustomer);
    User registerUser(UserDto userDto);
}
