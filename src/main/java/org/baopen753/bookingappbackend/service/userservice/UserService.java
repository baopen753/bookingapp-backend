package org.baopen753.bookingappbackend.service.userservice;

import org.baopen753.bookingappbackend.entity.Address;
import org.baopen753.bookingappbackend.entity.User;

public interface UserService {
    User getUserProfile(Integer userId);
    User updateAddress(Integer userId, Address convertedAddress);
    User updateUserProfile(Integer userId, User convertedCustomer);
}
