package org.baopen753.bookingappbackend.services.serviceservice;

import org.baopen753.bookingappbackend.entities.Service;

import java.math.BigDecimal;
import java.util.List;

public interface ServiceService {
    Service updateServicePrice(Integer serviceId, double servicePrice);
    Service getServiceById(Integer serviceId);
    List<Service> getAllServices();
}
