package org.baopen753.bookingappbackend.controllers;


import jakarta.annotation.security.RolesAllowed;
import org.baopen753.bookingappbackend.dtos.UserDto;
import org.baopen753.bookingappbackend.entities.User;
import org.baopen753.bookingappbackend.services.userservice.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;


    @Autowired
    public UserController(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody UserDto userDto) {
        String hashedPassword = passwordEncoder.encode(userDto.getPassword());
        userDto.setPassword(hashedPassword);
        User registeredUser = userService.registerUser(userDto);
        return ResponseEntity.ok(registeredUser);
    }


//
//    @GetMapping("/profile")
//    public ResponseEntity<?> getProfile(@RequestParam Integer userId) {
//
//        Integer userIdFromToken = 1;  // the userId takes from Authentication object in SecurityContext
//        User user = userService.getUserProfile(userId);
//        UserDto userDto = UserMapper.INSTANCE.convertEntityToDto(user);
//        return ResponseEntity.ok(userDto);
//    }
//
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
