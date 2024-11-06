package org.baopen753.bookingappbackend.repositories;

import org.baopen753.bookingappbackend.entities.Appointment;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;

@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = true)
public class AppointmentRepositoryTests {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Test
    public void testFindAppointmentByCustomerIdSuccess(){
        Integer customerId = 6;
        List<Appointment> appointmentList = appointmentRepository.findAppointmentByCustomerId(customerId);

        System.out.println(appointmentList.size());
    }

}
