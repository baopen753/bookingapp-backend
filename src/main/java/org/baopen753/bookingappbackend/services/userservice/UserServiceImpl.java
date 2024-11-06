package org.baopen753.bookingappbackend.services.userservice;

import org.baopen753.bookingappbackend.dtos.UserDto;
import org.baopen753.bookingappbackend.entities.Address;
import org.baopen753.bookingappbackend.entities.User;
import org.baopen753.bookingappbackend.enums.Role;
import org.baopen753.bookingappbackend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User getUserProfile(Integer userId) {
        return null;
    }

    @Override
    public User updateAddress(Integer userId, Address convertedAddress) {
        return null;
    }

    @Override
    public User updateUserProfile(Integer userId, User convertedCustomer) {
        return null;
    }

    @Override
    public User registerUser(UserDto userDto) {
        User user = new User();
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        user.setRole(Role.CUSTOMER);
        return userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException(username));
        //  List<GrantedAuthority> grantedAuthorities = List.of()

        // return new org.springframework.security.core.userdetails.User()
        return null;
    }

}
