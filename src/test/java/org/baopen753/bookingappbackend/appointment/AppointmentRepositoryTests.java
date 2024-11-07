package org.baopen753.bookingappbackend.appointment;

import org.baopen753.bookingappbackend.entities.Appointment;
import org.baopen753.bookingappbackend.repositories.AppointmentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

@DataJpaTest
@ActiveProfiles("test")
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
