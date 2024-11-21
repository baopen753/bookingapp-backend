package org.baopen753.bookingappbackend.controllers;

import jakarta.annotation.security.RolesAllowed;
import org.baopen753.bookingappbackend.dtos.UserDto;
import org.baopen753.bookingappbackend.entities.User;
import org.baopen753.bookingappbackend.services.userservice.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final MyUserDetailsService myUserService;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserController(MyUserDetailsService userService, PasswordEncoder passwordEncoder) {
        this.myUserService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody UserDto userDto) {
        String hashedPassword = passwordEncoder.encode(userDto.getPassword());
        userDto.setPassword(hashedPassword);
        myUserService.registerUser(userDto);
        return ResponseEntity.status(HttpStatus.CREATED).body("Register account successfully !");
    }

    @GetMapping("/profile")
    public ResponseEntity<?> getProfile(Authentication authentication) {
        UserDetails userDetails = myUserService.loadUserByUsername(authentication.getName());
        return ResponseEntity.ok(userDetails);
    }


//    @PutMapping("/address")
//    public ResponseEntity<?> updateAddressForCustomer(@RequestParam Integer userId, @RequestBody AddressDto addressFromRequest) {
//
//        Address convertedAddress = AddressMapper.INSTANCE.convertDtoToEntity(addressFromRequest);
//
//        Integer userIdFromToken = 1; // the userId takes from Authentication object in SecurityContext
//
//        // check(userIdFromToken, userId)
//
//        User updatedCustomer = userService.updateAddress(userId, convertedAddress);
//        UserDto userDto = UserMapper.INSTANCE.convertEntityToDto(updatedCustomer);
//        return ResponseEntity.ok(userDto);
//    }
//
//    @PutMapping("/profile")
//    public ResponseEntity<?> updateUserProfile(@RequestParam Integer userId, @RequestBody UserDto userFromRequest) {
//
//
//        try {
//            User convertedCustomer = UserMapper.INSTANCE.convertDtoToEntity(userFromRequest);
//            Integer userIdFromToken = 1; // the userId takes from Authentication object in SecurityContext
//
//            if (!userId.equals(userIdFromToken)) {
//                return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
//            }
//
//            // check(userIdFromToken, userId)
//            User updatedCustomer = userService.updateUserProfile(userId, convertedCustomer);
//            UserDto userDto = UserMapper.INSTANCE.convertEntityToDto(updatedCustomer);
//            return ResponseEntity.ok(userDto);
//
//        } catch (Exception e) {
//            return ResponseEntity.badRequest().build();
//        }
//
//    }


    @RolesAllowed({"ADMIN"})
    @GetMapping("/vip")
    public String zoneVip() {
        return "zone vip";
    }

    @RolesAllowed({"USER", "ADMIN"})
    @GetMapping("/normal")
    public String zoneNormal() {
        return "zone normal";
    }

    @GetMapping("/info")
    public Authentication info() {
        return SecurityContextHolder.getContext().getAuthentication();
    }

}
