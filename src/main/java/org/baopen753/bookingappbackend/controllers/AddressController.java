package org.baopen753.bookingappbackend.controllers;

import org.baopen753.bookingappbackend.aop.annotations.Authenticated;
import org.baopen753.bookingappbackend.aop.aspect.UserContext;
import org.baopen753.bookingappbackend.entities.Address;
import org.baopen753.bookingappbackend.mappers.AddressMapper;
import org.baopen753.bookingappbackend.responses.service.AddressResponse;
import org.baopen753.bookingappbackend.services.userservice.UserAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/addresses")
public class AddressController {

    private final UserAddressService userAddressService;

    @Autowired
    public AddressController(UserAddressService userAddressService) {
        this.userAddressService = userAddressService;
    }

    @Authenticated
    @GetMapping()
    public ResponseEntity<List<AddressResponse>> getAllAddresses() {
        List<Address> addressList = userAddressService.getAllAddresses(UserContext.getAuthenticatedUsername());
        List<AddressResponse> addressResponseList = addressList.stream().map(AddressMapper.INSTANCE::convertToAddressResponse).toList();
        return ResponseEntity.ok(addressResponseList);
    }
}
