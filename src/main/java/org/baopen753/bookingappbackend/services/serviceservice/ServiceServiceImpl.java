package org.baopen753.bookingappbackend.services.serviceservice;

import org.baopen753.bookingappbackend.entities.Service;
import org.baopen753.bookingappbackend.exception.DataNotFoundException;
import org.baopen753.bookingappbackend.repositories.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;

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
        if (service == null) {
            throw new DataNotFoundException("Service", serviceId);
        }
        return service;
    }


    /*
     * Update price of service
     * */
    @Override
    public Service updateServicePrice(Integer serviceId, double servicePrice) {

        // check service existed from db
        Service serviceFromDb = serviceRepository.findById(serviceId).orElse(null);
        if (serviceFromDb == null) {
            throw new DataNotFoundException("Service", serviceId);
        }
        serviceFromDb.setServicePrice(BigDecimal.valueOf(servicePrice));
        return serviceRepository.save(serviceFromDb);
    }

}
