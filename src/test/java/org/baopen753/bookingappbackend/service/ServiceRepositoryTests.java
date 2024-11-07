package org.baopen753.bookingappbackend.service;

import org.assertj.core.api.Assertions;

import org.baopen753.bookingappbackend.entities.Service;
import org.baopen753.bookingappbackend.repositories.ServiceRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@DataJpaTest  // enables JPA testing
@ActiveProfiles("test")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)  // /// Use the configured database, not an embedded provided in-memory by spring
@Rollback
public class ServiceRepositoryTests {

    @Autowired
    private ServiceRepository serviceRepository;

    @Test
    public void testGetAllServicesSuccess() {
        List<Service> serviceList = serviceRepository.findAll();

        Assertions.assertThat(serviceList).isNotEmpty();
        serviceList.forEach(System.out::println);
    }


    @Test
    public void testGetServiceByIdSuccess() {
        Integer serviceId = 1;
        Optional<Service> service = serviceRepository.findById(serviceId);
        Assertions.assertThat(service).isPresent();
        System.out.println(service.toString());
    }

    @Test
    public void testUpdateServicePriceSuccess() {
        Integer serviceId = 1;

        Service service = serviceRepository.findById(serviceId).get();
        service.setServicePrice(BigDecimal.valueOf(300.00));

        serviceRepository.save(service);

        Assertions.assertThat(serviceRepository.findById(serviceId).get().getServicePrice()).isEqualTo(BigDecimal.valueOf(300.00));
    }

}
