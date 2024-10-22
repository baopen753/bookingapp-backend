package org.baopen753.bookingappbackend.services.serviceservice;

import org.baopen753.bookingappbackend.entities.Service;

import java.util.List;

public interface ServiceService {
    Service updateService(Integer serviceId, Service service);
    Service getServiceById(Integer serviceId);
    List<Service> getAllServices();
}
