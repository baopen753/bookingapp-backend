package org.baopen753.bookingappbackend.services.userservice;

import org.baopen753.bookingappbackend.dtos.UserDto;
import org.baopen753.bookingappbackend.entities.Address;
import org.baopen753.bookingappbackend.entities.User;
import org.baopen753.bookingappbackend.enums.Role;
import org.baopen753.bookingappbackend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Autowired
    public MyUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public User getUserProfile(Integer userId) {
        return null;
    }


    public User updateAddress(Integer userId, Address convertedAddress) {
        return null;
    }

    public User updateUserProfile(Integer userId, User convertedCustomer) {
        return null;
    }

    public void registerUser(UserDto userDto) {
        User user = new User();
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        user.setRole(Role.valueOf(userDto.getRole().toUpperCase()));
        userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User details not found with username: " + username));
        List<GrantedAuthority> grantedAuthorities = List.of(new SimpleGrantedAuthority(user.getRole().toString()));

        return new org.springframework.security.core.userdetails.User(username, user.getPassword(), grantedAuthorities);
    }

}
