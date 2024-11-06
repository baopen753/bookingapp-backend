package org.baopen753.bookingappbackend.controllers;

import org.baopen753.bookingappbackend.dtos.ServiceDto;
import org.baopen753.bookingappbackend.entities.Service;
import org.baopen753.bookingappbackend.mappers.ServiceMapper;
import org.baopen753.bookingappbackend.responses.service.ServiceResponse;
import org.baopen753.bookingappbackend.services.serviceservice.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/services")
public class ServiceController {

    private final ServiceService serviceService;

    @Autowired
    public ServiceController(ServiceService serviceService) {
        this.serviceService = serviceService;
    }

    @GetMapping("/all")
    public ResponseEntity<?> getServices() {
        List<Service> serviceList = serviceService.getAllServices();
        if (serviceList.isEmpty())
            return ResponseEntity.notFound().build();
        List<ServiceResponse> serviceResponseList = serviceList.stream().map(ServiceMapper.INSTANCE::convertToResponse).toList();
        return ResponseEntity.ok(serviceResponseList);
    }


    @GetMapping("/{serviceId}")
    public ResponseEntity<?> getService(@PathVariable Integer serviceId) {
        Service service = serviceService.getServiceById(serviceId);
        if (service == null)
            return ResponseEntity.notFound().build();
        ServiceResponse serviceResponse = ServiceMapper.INSTANCE.convertToResponse(service);
        return ResponseEntity.ok(serviceResponse);
    }

    @PatchMapping("/{serviceId}")
    public ResponseEntity<?> updateServicePrice(@PathVariable Integer serviceId, @RequestBody ServiceDto serviceDto) {
        if (serviceDto.getServicePrice() == null)
            return ResponseEntity.badRequest().build();
        Service updatedService = serviceService.updateServicePrice(serviceId, Double.parseDouble(String.valueOf(serviceDto.getServicePrice())));
        return ResponseEntity.ok(updatedService);
    }

}
