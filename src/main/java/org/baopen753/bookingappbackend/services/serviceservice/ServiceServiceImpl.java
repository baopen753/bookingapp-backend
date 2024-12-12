package org.baopen753.bookingappbackend.services.serviceservice;

import org.baopen753.bookingappbackend.entities.Service;
import org.baopen753.bookingappbackend.exception.BadRequestException;
import org.baopen753.bookingappbackend.exception.DataNotFoundException;
import org.baopen753.bookingappbackend.repositories.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@org.springframework.stereotype.Service
public class ServiceServiceImpl implements ServiceService {

    private final ServiceRepository serviceRepository;

    @Autowired
    public ServiceServiceImpl(ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    /*
     * Get all available services
     * */
    @Override
    public List<Service> getAllServices() {
        return serviceRepository.findAll();
    }


    @Override
    public Service getServiceById(Integer serviceId) {
        Service service = serviceRepository.findById(serviceId).orElse(null);
        if (service == null) throw new DataNotFoundException("Service", serviceId);
        return service;
    }

    /*
     * Update price of service
     * */
    @Transactional
    @Override
    public Service updateServicePrice(Integer serviceId, BigDecimal servicePrice) {

        if (servicePrice == null || servicePrice.compareTo(BigDecimal.ZERO) < 0) throw new BadRequestException("Update failed: service price must be a positive number");

        // check service existed from db
        Service serviceFromDb = serviceRepository.findById(serviceId).orElse(null);
        if (serviceFromDb == null) {
            throw new DataNotFoundException("Service", serviceId);
        }

        serviceFromDb.setServicePrice(servicePrice);
        return serviceRepository.save(serviceFromDb);
    }
}
