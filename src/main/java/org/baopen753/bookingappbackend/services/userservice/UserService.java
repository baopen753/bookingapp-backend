package org.baopen753.bookingappbackend.services.userservice;

import org.baopen753.bookingappbackend.models.Address;
import org.baopen753.bookingappbackend.models.User;

public interface UserService {
    User getUserProfile(Integer userId);
    User updateAddress(Integer userId, Address convertedAddress);
    User updateUserProfile(Integer userId, User convertedCustomer);
}
