package org.baopen753.bookingappbackend.controllers;

import org.baopen753.bookingappbackend.dtos.LoginRequestDto;
import org.baopen753.bookingappbackend.dtos.UserDto;
import org.baopen753.bookingappbackend.mappers.UserMapper;
import org.baopen753.bookingappbackend.responses.service.LoginResponseDto;
import org.baopen753.bookingappbackend.responses.service.UserResponse;
import org.baopen753.bookingappbackend.services.userservice.MyUserDetailsService;
import org.baopen753.bookingappbackend.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.crypto.SecretKey;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Value("${jwt.secret-key}")
    private String JWT_SECRET_KEY;

    @Value("${jwt.header}")
    private String JWT_HEADER;


    private final MyUserDetailsService myUserService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtUtils jwtUtils;

    @Autowired
    public UserController(MyUserDetailsService userService, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager, JwtUtils jwtUtils) {
        this.myUserService = userService;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.jwtUtils = jwtUtils;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody UserDto userDto) {
        String hashedPassword = passwordEncoder.encode(userDto.getPassword());
        userDto.setPassword(hashedPassword);
        myUserService.registerUser(userDto);
        return ResponseEntity.status(HttpStatus.CREATED).body("Register account successfully!");
    }

    @GetMapping("/profile")
    public ResponseEntity<?> getProfile(Authentication authentication) {
        UserDetails userDetails = myUserService.loadUserByUsername(authentication.getName());
        UserResponse userResponse = UserMapper.userToUserResponse(userDetails);
        return ResponseEntity.ok(userResponse);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> apiLogin(@RequestBody LoginRequestDto loginRequestDto) {

        String jwt = null;

        // wrapping unauthenticated credential
        Authentication authenticationRequest = UsernamePasswordAuthenticationToken.unauthenticated(loginRequestDto.getUsername(), loginRequestDto.getPassword());

        // authenticate credential
        Authentication authentication = this.authenticationManager.authenticate(authenticationRequest);

        if (authentication != null && authentication.isAuthenticated()) {
            // get SecretKey
            SecretKey secretKey = jwtUtils.getSecretKey(JWT_SECRET_KEY);

            // build token
            jwt = jwtUtils.generateToken(secretKey, authentication);
        }

        return ResponseEntity.status(HttpStatus.OK)
                .header(JWT_HEADER, jwt)
                .body(new LoginResponseDto(HttpStatus.OK.getReasonPhrase(), jwt));
    }


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

//
//    @RolesAllowed({"ADMIN"})
//    @GetMapping("/vip")
//    public String zoneVip() {
//        return "zone vip";
//    }
//
//    @RolesAllowed({"USER", "ADMIN"})
//    @GetMapping("/normal")
//    public String zoneNormal() {
//        return "zone normal";
//    }


}
